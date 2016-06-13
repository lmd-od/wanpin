package com.wanpin.web.sys;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wanpin.common.utils.VerifyCodeUtils;

/**
 * <p>验证码控制层（包含图形验证码和手机验证码）</p>
 * @author litr 2016年6月13日
 * @version 1.0
 */
@Controller
@RequestMapping("${webAdminPath}/code")
public class CodeController {

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
	
}
