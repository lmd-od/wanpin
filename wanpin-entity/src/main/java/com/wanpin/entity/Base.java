package com.wanpin.entity;

import java.util.Date;

/**
 * @author MingDing.Li
 */
public class Base {
	protected Date createDate; // 注册时间
	protected Date updateDate; // 更新时间
	protected String id;
	protected String delFlag;// 删除标记
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}
