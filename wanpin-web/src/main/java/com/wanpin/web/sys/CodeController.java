package com.wanpin.web.sys;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.core.sms.SmsTemplateCode;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.CommonUtils;
import com.wanpin.common.utils.MessageSendUtils;
import com.wanpin.common.utils.SmsUtils;
import com.wanpin.common.utils.VerifyCodeUtils;
import com.wanpin.web.BaseController;

/**
 * <p>验证码控制层（包含图形验证码和手机验证码）</p>
 * @author litr 2016年6月13日
 * @version 1.0
 */
@Controller
@RequestMapping("${webAdminPath}/code")
public class CodeController extends BaseController {

	@Autowired
	private MessageSendUtils messageSendUtils;
	
	/**
	 * <p>生成图形验证码</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "imgcode${urlSuffix}")
	public void imgcode(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		try {
			String verifyCode = VerifyCodeUtils.generateTextCode(VerifyCodeUtils.TYPE_ALL_MIXED, 4, null);
			request.getSession().setAttribute("IMG_CODE", verifyCode);
			//设置输出的内容的类型为JPEG图像
			BufferedImage bufferedImage = VerifyCodeUtils.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
			//写给浏览器
			ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <p>发送手机验证码</p>
	 * @author litr 2016年6月26日
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "mobilecode${urlSuffix}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> mobilecode(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		String mobile = request.getParameter("mobile");
		String smsType = request.getParameter("codeType");
		Byte smsSource = SystemEnum.SMS_SOURCE_PC;
		String imgcode = request.getParameter("imgcode");
		
		if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(imgcode) || StringUtils.isEmpty(smsType)
				|| StringUtils.isEmpty(smsSource)) {
			this.setFailFlag(model);
			return model;
		}
		
		Object sessionImgcode = request.getSession().getAttribute("IMG_CODE");
		if (sessionImgcode == null || !sessionImgcode.toString().equalsIgnoreCase(imgcode)) {
			this.setFailFlag(model, SystemEnum.RESP_IMGCODE_INVALID);
			return model;
		}
		
		if (!CommonUtils.isMobileNO(mobile)) {
			this.setFailFlag(model, StatusCodes.MOBILE_FORMAT_ERROR);
			return model;
		}
		
		try {
			SmsTemplateCode stc = SmsTemplateCode.valueOf(smsType);
			// 获取6位随机数验证码
			String vcode = VerifyCodeUtils.generateTextCode(VerifyCodeUtils.TYPE_NUM_ONLY, 6, null);
			boolean flag = messageSendUtils.sendSms(stc, mobile, vcode, CommonUtils.getIpAddr(request), String.valueOf(smsSource));
			if (!flag) {
				this.setFailFlag(model, StatusCodes.SMS_SEND_FAIL);
				return model;
			}
			
			SmsUtils.setMobileCode(mobile, vcode, request);
			
			this.setSuccessFlag(model);
		} catch (Exception e) {
			this.setFailFlag(model, StatusCodes.SMS_SEND_FAIL);
			e.printStackTrace();
		}
		
		return model;
	}
	
}
