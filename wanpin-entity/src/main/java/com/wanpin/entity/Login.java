package com.wanpin.entity;

/**
 * 登录公用实体
 * @author MingDing.Li
 */
public class Login extends Base {
	protected String sid;//登录成功后生成 sid

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
}
