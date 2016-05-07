package com.wanpin.entity;

import java.util.Date;

import com.wanpin.common.persistence.SystemEnum;

/**
 * 用户Entity
 * 
 * @author MingDingLi
 * @version 2013-12-05
 */
public class User extends Login{
    
	private String loginName; // 登录名
	private String password; // 密码
	private String payPassword;//支付密码
	private String name; // 姓名
	private String mobile; // 手机
	private String newPassword; // 新密码
	private String type;// 用户类型 vip 用户/普通用户/游客
	private String userCode;
	private String language = SystemEnum.SYS_USER_LANGUAGE_ZH;// 语言 默认中文

	private String loginIp; // 最后登陆IP
	private Date loginDate; // 最后登陆日期
	private String loginFlag; // 是否允许登陆
	private String oldLoginIp; // 上次登陆IP
	private Date oldLoginDate; // 上次登陆日期

	private String photo; // 头像
	private String email; // 邮箱
	private String phone; // 电话

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public String getOldLoginIp() {
		return oldLoginIp;
	}
	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}
	public Date getOldLoginDate() {
		return oldLoginDate;
	}
	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}