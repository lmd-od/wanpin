package com.wanpin.common.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.wanpin.common.constants.StatusCodes;

public class SmsUtils {

	public static final String SEND_TIME = "sendTime";
	
	/**
	 * <p>PC端将手机验证码放置到session中</p>
	 * @author litr 2016年7月7日
	 * @param mobile
	 * @param vcode
	 * @param request
	 */
	public static void setMobileCode(String mobile, String vcode, HttpServletRequest request) {
		setMobileCode(mobile, vcode, null, request);
	}
	
	public static String getSmsValidCode(String mobile, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(StringUtils.isEmpty(mobile)) return null;
		if(session == null) return null;
		
		Object validCode = session.getAttribute(mobile);
		
		if(validCode == null) return null;
		
		return (String) validCode;
	}
	
	public static Long getSmsSendTime(String mobile, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(session == null) return null;
		
		Object sendTime = session.getAttribute(mobile + SEND_TIME);
		if(sendTime == null) return null;
		
		return (Long) sendTime;
	}
	
	/**
	 * 
	 * <p>PC端验证短信验证码是否有效</p>
	 * @author litr 2016年7月7日
	 * @param mobile
	 * @param validCode
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static boolean validMobileCodeIsValid(String mobile,String validCode,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		String sessionCode = getSmsValidCode(mobile, request);
		Long beforeTime = getSmsSendTime(mobile, request);
		Long currentTime = System.currentTimeMillis();
		if(StringUtils.isEmpty(validCode) || StringUtils.isEmpty(sessionCode) || beforeTime == null) return false;
		
		if(!sessionCode.equalsIgnoreCase(validCode)) return false;
		
		if((currentTime-beforeTime)/1000 > 600) return false;
		
		session.removeAttribute(mobile);
		session.removeAttribute(mobile + SEND_TIME);
		
		return true;
	}
	
	/**
	 * <p>移动端校验手机验证码</p>
	 * @author litr 2016年7月7日
	 * @param mobile
	 * @param code
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static boolean checkSMSCode(String mobile, String code, Map<String, Object> model,HttpServletRequest request) throws Exception {
		Object codeObj = request.getSession().getServletContext().getAttribute(mobile);
		Object timeObj = request.getSession().getServletContext().getAttribute(mobile + SEND_TIME);
		if (StringUtils.isEmpty(code) || StringUtils.isEmpty(codeObj) || StringUtils.isEmpty(timeObj)) {
			WanpinUtils.organizeData(model, StatusCodes.SMS_CODE_INVALID);
			return false;
		}
		
		String smsCode = String.valueOf(codeObj);
		if (!smsCode.equals(code)) {
			WanpinUtils.organizeData(model, StatusCodes.SMS_CODE_INVALID);
			return false;
		}
		
		Long time = Long.valueOf(timeObj.toString());
		Long now = System.currentTimeMillis();
		if ((now - time)/1000 > 600) {
			WanpinUtils.organizeData(model, StatusCodes.SMS_CODE_OVERTIME);
			return false;
		}
		
		request.getSession().getServletContext().removeAttribute(mobile);
		request.getSession().getServletContext().removeAttribute(mobile + SEND_TIME);
		
		return true;
	}
	
	public static void setMobileCode(String mobile, String vcode, Boolean type, HttpServletRequest request) {
		if (type == null || !type) {
			request.getSession().setAttribute(mobile, vcode);
			request.getSession().setAttribute(mobile + SEND_TIME, System.currentTimeMillis());
		} else {
			request.getSession().getServletContext().setAttribute(mobile, vcode);
			request.getSession().getServletContext().setAttribute(mobile + SEND_TIME, System.currentTimeMillis());
		}
	}
	
}
