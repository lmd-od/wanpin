package com.wanpin.common.persistence;

/**
 * 系统定义枚举
 * @author MingDing.Li
 *
 */
public class SystemEnum {
    
	/*
	 * 返回状态定义
	 */
	/** 请求成功的 */
	public static final String APP_RES_STATUS_SUCCESS = "0";
	/** 请求失败的 */
	public static final String APP_RES_STATUS_FAILED = "1";
	/** 登录成功 */
	public static final String APP_LOGIN_STATUS_SUCCESS = "2";
	/** 登录失败 */
	public static final String APP_LOGIN_STATUS_FAILED = "3";
	
	/*
	 * 处理状态信息
	 */
	/** 处理成功的 */
	public static final String APP_RES_MSG_SUCCESS = "SUCCESS";
	/** 处理失败的 */
	public static final String APP_RES_MSG_FAILED = "FAILED";
	/** 登录成功的 */
	public static final String APP_LOGIN_MSG_SUCCESS = "LOGIN SUCCESS";
	/** 登录失败的 */
	public static final String APP_LOGIN_MSG_FAILED = "LOGIN FAILED";
	
	/*
	 * 用户类型
	 */
	/** vip 用户 */
	public static final String SYS_USER_TYPE_VIP = "vip";
	/** 普通用户 */
	public static final String SYS_USER_TYPE_ORDINARY = "ordinary";
	/** 游客 */
	public static final String SYS_USER_TYPE_VISITOR = "visitor";
	
	/*
	 * 语言
	 */
	/** 中文 */
	public static final String SYS_USER_LANGUAGE_ZH = "zh";
	/** 英文 */
	public static final String SYS_USER_LANGUAGE_EN = "en";
	
	/*
	 * 性别
	 */
	/**男*/
	public static final int SEX_MALE = 0;
	/**女*/
	public static final int SEX_FEMALE = 1;
	/**保密*/
	public static final int SEX_SECRECY = 2;
	
	
}
