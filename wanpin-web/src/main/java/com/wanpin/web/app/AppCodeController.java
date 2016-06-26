package com.wanpin.web.app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.core.sms.SmsTemplateCode;
import com.wanpin.common.exception.ParamIsNullException;
import com.wanpin.common.exception.SmsException;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.CommonUtils;
import com.wanpin.common.utils.MessageSendUtils;
import com.wanpin.common.utils.VerifyCodeUtils;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.web.AppBaseController;

@Controller
@RequestMapping("${appAdminPath}/code")
public class AppCodeController extends AppBaseController {
	
	@Autowired
	private MessageSendUtils messageSendUtils;
	
	public Map<String, Object> smsCode(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			// 验证必填字段
			// WanpinUtils.isRequiredFields("mobile,code,code1,code2,smsType,smsSource", model, request);
			WanpinUtils.isRequiredFields("mobile,smsType,smsSource", model, request);
			
			String mobile = request.getParameter("mobile");
			String smsType = request.getParameter("smsType");
			Byte smsSource = Byte.valueOf(request.getParameter("smsSource"));
			/*String code = request.getParameter("code");
			String code1 = request.getParameter("code1");
			String code2 = request.getParameter("code2");
			String newcode = MD5Utils.encode(code1 + mobile + code2);
			if (!code.equals(newcode)) {
				WanpinUtils.organizeData(model, StatusCodes.INVALID_PARAMETER);
				return model;
			}*/
			
			if (!CommonUtils.isMobileNO(mobile)) {
				WanpinUtils.organizeData(model, StatusCodes.MOBILE_FORMAT_ERROR);
				return model;
			}
			
			if (smsSource != SystemEnum.SMS_SOURCE_PC && smsSource != SystemEnum.SMS_SOURCE_ANDROID && smsSource != SystemEnum.SMS_SOURCE_IOS) {
				WanpinUtils.organizeData(model, StatusCodes.INVALID_PARAMETER, "smsSource参数无效");
				return model;
			}
			
			SmsTemplateCode smsTypeCode = SmsTemplateCode.valueOf(smsType);
			// 获取6位随机数验证码
			String vcode = VerifyCodeUtils.generateTextCode(VerifyCodeUtils.TYPE_NUM_ONLY, 6, null);
			
			boolean flag = messageSendUtils.sendSms(smsTypeCode, mobile, vcode, CommonUtils.getIpAddr(request), String.valueOf(smsSource));
			if (!flag) {
				WanpinUtils.organizeData(model, StatusCodes.SMS_SEND_FAIL);
				return model;
			}
			model.put("code", vcode);
			
		} catch (ParamIsNullException e) {
			
		} catch (SmsException e) {
			WanpinUtils.organizeData(model, StatusCodes.SMS_SEND_FAIL);
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
}
