package com.wanpin.vo;

import com.wanpin.entity.Goods;

public class GoodsVO extends Goods {

	/** 方案风格名*/
	private String goodsStyleName;
	/** 方案功能名*/
	private String goodsFunctionName;
	/** 方案层数名*/
	private String goodsHierarchyName;
	public String getGoodsStyleName() {
		return goodsStyleName;
	}
	public void setGoodsStyleName(String goodsStyleName) {
		this.goodsStyleName = goodsStyleName == null ? null : goodsStyleName.trim();
	}
	public String getGoodsFunctionName() {
		return goodsFunctionName;
	}
	public void setGoodsFunctionName(String goodsFunctionName) {
		this.goodsFunctionName = goodsFunctionName == null ? null : goodsFunctionName.trim();
	}
	public String getGoodsHierarchyName() {
		return goodsHierarchyName;
	}
	public void setGoodsHierarchyName(String goodsHierarchyName) {
		this.goodsHierarchyName = goodsHierarchyName == null ? null : goodsHierarchyName.trim();
	}
	
}
