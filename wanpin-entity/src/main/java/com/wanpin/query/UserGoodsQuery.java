package com.wanpin.query;

import com.wanpin.common.query.BaseQuery;
import com.wanpin.vo.GoodsVO;

public class UserGoodsQuery extends BaseQuery<GoodsVO> {

	/** 方案名称*/
	private String goodsName;
	/** 方案位置（1：搜索引擎  2：方案商城）*/
	private Integer[] goodsPlaces;
	
	private Long userId; // 用户ID
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName == null ? null : goodsName.trim();
	}
	public Integer[] getGoodsPlaces() {
		return goodsPlaces;
	}
	public void setGoodsPlaces(Integer... goodsPlaces) {
		this.goodsPlaces = goodsPlaces;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
