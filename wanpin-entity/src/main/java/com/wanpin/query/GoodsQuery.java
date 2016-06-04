package com.wanpin.query;

import com.wanpin.common.query.BaseQuery;
import com.wanpin.vo.GoodsVO;

public class GoodsQuery extends BaseQuery<GoodsVO> {

	/** 方案名称*/
	private String goodsName;
	/** 方案位置（1：搜索引擎  2：方案商城）*/
	private Integer[] goodsPlaces;
	/** 方案状态（1：草稿 2：待审核 3：审核通过 4：审核不通过 5：已下架）*/
	private Byte[] goodsStatus;
	/** 国别*/
	private String[] countryCode;
	/** 方案风格(欧式/美式/中式等*/
	private String[] goodsStyle;
	/** 方案功能(居住/公用/工业/农业等)*/
	private String[] goodsFunction;
	/** 方案层数(底层/中层/高层)*/
	private String[] goodsHierarchy;
	
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
	public Byte[] getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(Byte... goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String[] getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String... countryCode) {
		this.countryCode = countryCode;
	}
	public String[] getGoodsStyle() {
		return goodsStyle;
	}
	public void setGoodsStyle(String... goodsStyle) {
		this.goodsStyle = goodsStyle;
	}
	public String[] getGoodsFunction() {
		return goodsFunction;
	}
	public void setGoodsFunction(String... goodsFunction) {
		this.goodsFunction = goodsFunction;
	}
	public String[] getGoodsHierarchy() {
		return goodsHierarchy;
	}
	public void setGoodsHierarchy(String... goodsHierarchy) {
		this.goodsHierarchy = goodsHierarchy;
	}
	
}
