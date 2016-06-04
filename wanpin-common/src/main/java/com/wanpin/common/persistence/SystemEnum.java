package com.wanpin.common.persistence;

/**
 * 系统定义枚举
 * @author MingDing.Li
 *
 */
public class SystemEnum {
    /*
     * 请求响应状态
     */
	/** 请求成功*/
	public static final int RESP_STATUS_SUCCESS = 0;
	/** 请求失败*/
	public static final int RESP_STATUS_FAIL = 1;
	/** 系统繁忙*/
	public static final int RESP_SYSTEM_BUSY = -1;
	/** session超时*/
	public static final int RESP_SESSION_INVALID = -2;
	
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
	
	/*
	 * 方案来源
	 */
	/** 公司内部 */
	public static final int GOODS_SOURCE_MY  = 1;
	/** 其他公司 */
	public static final int GOODS_SOURCE_ORTHER  = 2;
	
	/*
	 * 方案位置
	 */
	/** 搜索引擎 */
	public static final int GOODS_PLACES_ENGINE  = 1;
	/** 商城 */
	public static final int GOODS_PLACES_SHOPPING = 2;
	
	/*
	 * 审核状态
	 */
	/** 1：草稿 */
	public static final Byte GOODS_STATUS_DRAFT  = 1;
	/** 2：待审核 */
	public static final Byte GOODS_STATUS_PENDING  = 2;
	/** 3：审核通过*/
	public static final Byte GOODS_STATUS_PASSED  = 3;
	/** 4：审核不通过*/
	public static final Byte GOODS_STATUS_NO_PASSED  = 4;
	/** 5：已下架*/
	public static final Byte GOODS_STATUS_FROMSALE  = 5;
	
	/** 方案风格字典类型 */
	public static final String WP_GOODS_STYLE  = "wp_goods_style";
	/** 方案功能字典类型 */
	public static final String WP_GOODS_FUNCTION  = "wp_goods_function";
	/** 方案层数字典类型 */
	public static final String WP_GOODS_HIERARCHY  = "wp_goods_hierarchy";

	/*
	 * 用户状态
	 */
	/** 已启用*/
	public static final int USER_STATUS_NORMAL = 1;
	/** 未启用*/
	public static final int USER_STATUS_DISABLED = 2;
	
	
	/** 图片文件存储路径 */
	public static final String WP_FILES_IMAGES_PATH  = "/wp/files/images";
	
}
