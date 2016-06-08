package com.wanpin.entity;

import java.util.Date;

public class UserGoods {
	/** 收藏ID*/
    private Long userGoodsId;
    /** 用户ID*/
    private Long userId;
    /** 方案ID*/
    private Long goodsId;
    /** 收藏时间*/
    private Date collectTime;
	public Long getUserGoodsId() {
		return userGoodsId;
	}
	public void setUserGoodsId(Long userGoodsId) {
		this.userGoodsId = userGoodsId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	
    
}