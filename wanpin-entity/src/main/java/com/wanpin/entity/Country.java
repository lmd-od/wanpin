package com.wanpin.entity;
/**
 * 国家
 * @author MingDing.Li
 */
public class Country {
	private String code;//国家编码
	private String enName;//英文国家名
	private String zhName;//国家中文名
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getZhName() {
		return zhName;
	}
	public void setZhName(String zhName) {
		this.zhName = zhName;
	}
	
}
