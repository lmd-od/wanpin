package com.wanpin.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>app状态返回码</p>
 * @author litr 2016年6月16日
 * @version 1.0
 */
public class StatusCodes {

	public static Map<Integer, String> ERROR_MSG = new HashMap<Integer, String>();
	
	/** 请求成功*/
	public static int SUCCESS = 0;
	/** 系统繁忙*/
	public static int SYSTEM_BUSY = -1;
	/** 手机号或密码为空*/
	public static int MOBILE_PASSWORD_NULL = 10001;
	/** 手机号未注册*/
	public static int MOBILE_NOT_REGISTER = 10002;
	/** 手机号被禁用*/
	public static int MOBILE_DISABLED = 10003;
	/** 手机号或密码错误*/
	public static int MOBILE_PASSWORD_ERROR = 10004;
	/** 手机号已注册*/
	public static int MOBILE_REGISTER = 10005;
	/** 旧密码错误*/
	public static int OLD_PASSWORD_ERROR = 10006;
	
	/** 短信验证码无效*/
	public static int SMS_CODE_INVALID = 20001;
	/** 短信验证码超时*/
	public static int SMS_CODE_OVERTIME = 20002;
	
	/** 不合法的请求参数*/
	public static int INVALID_PARAMETER = 30001;
	/** 必须请求参数为空*/
	public static int MUST_PARAMETER_NULL = 30002;
	/** 请求的期刊数据为空*/
	public static int PERIODICAL_NULL = 30003;
	/** 请求的令牌无效*/
	public static int TOKEN_INVALID = 30004;
	/** 方案未收藏*/
	public static int GOODS_NOT_COLLECT = 30005;
	/** 方案已收藏*/
	public static int GOODS_COLLECT = 30006;
	
	
	static {
		ERROR_MSG.put(SYSTEM_BUSY, "系统繁忙，请稍后再试");
		
		ERROR_MSG.put(MOBILE_PASSWORD_NULL, "手机号或密码为空");
		ERROR_MSG.put(MOBILE_NOT_REGISTER, "手机号未注册");
		ERROR_MSG.put(MOBILE_DISABLED, "手机号被禁用");
		ERROR_MSG.put(MOBILE_PASSWORD_ERROR, "手机号或密码错误");
		ERROR_MSG.put(MOBILE_REGISTER, "手机号已注册");
		ERROR_MSG.put(OLD_PASSWORD_ERROR, "旧密码错误");
		
		ERROR_MSG.put(SMS_CODE_INVALID, "短信验证码无效");
		ERROR_MSG.put(SMS_CODE_OVERTIME, "短信验证码超时");
		
		ERROR_MSG.put(INVALID_PARAMETER, "不合法的请求参数");
		ERROR_MSG.put(MUST_PARAMETER_NULL, "不合法的必须请求参数");
		ERROR_MSG.put(PERIODICAL_NULL, "请求的期刊数据为空");
		ERROR_MSG.put(TOKEN_INVALID, "请求的令牌无效");
		ERROR_MSG.put(GOODS_NOT_COLLECT, "方案未收藏");
		ERROR_MSG.put(GOODS_COLLECT, "方案已收藏");
	}
	
}
