package com.wanpin.common.utils;

import javax.servlet.http.HttpServletRequest;

import com.wanpin.entity.User;

public class SecurityHelper {

	public static final String USER_INFO = "userInfo";
	
	public static String getAccountName(HttpServletRequest request){
		Object userInfo = request.getSession().getAttribute(USER_INFO);
		if (userInfo != null) {
			return ((User)userInfo).getMobile();
		}
		return null;
    }
	
	public static Long getUserId(HttpServletRequest request){
		Object userInfo = request.getSession().getAttribute(USER_INFO);
		if (userInfo != null) {
			return ((User)userInfo).getUserId();
		}
		return null;
    }
	
	public static User getUserInfo(HttpServletRequest request){
		Object userInfo = request.getSession().getAttribute(USER_INFO);
		if (userInfo != null) {
			return (User)userInfo;
		}
		return null;
    }
	
}
