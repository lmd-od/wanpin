package com.wanpin.common.core.sms;

public enum SmsTemplateCode {

	REG_VCODE("SMS_10990338"),//注册验证码
	FIND_PWD_VCODE("SMS_10990338"),//找回密码验证码
	PAY_VCODE("SMS_10990338"),//支付验证码
	LOGIN_VCODE("SMS_10990338");//动态密码登录
	
	private final String value;
	
	SmsTemplateCode(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
