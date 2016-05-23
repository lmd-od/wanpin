package com.wanpin.cms.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.wanpin.cms.common.persistence.DataEntity;
/**
 * 解决方案实体
 * @author MingDing.Li
 */
public class Goods extends DataEntity<Goods>{
    private Long goodsId;

    private Byte goodsSource;//方案来源：1：公司自有，2：其它公司

    private Byte goodsStatus;//1：草稿 2：待审核 3：审核通过 4：审核不通过 5：已下架

    private String goodsName;//方案名称

    private BigDecimal goodsMoney;//方案金额

    private Long detail;//详情（方案描述）；外键：关联文章表

    private String goodsCover;//方案封面；图片链接

    private String goodsImage;//方案图片；图片链接，多个以逗号分隔

    private String countryCode;//国别

    private String countryName;//国别名

    private Long cityId;//城市

    private String cityZhName;//城市名称

    private String architect;//建筑师

    private String builtArea;//建筑面积

    private Integer projectYear;//项目年份

    private User createUser;//创建用户

    private Date createTime;

    private User updateUser;//更新人

    private Date updateTime;
    
    public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Byte getGoodsSource() {
        return goodsSource;
    }

    public void setGoodsSource(Byte goodsSource) {
        this.goodsSource = goodsSource;
    }

    public Byte getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Byte goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(BigDecimal goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public Long getDetail() {
        return detail;
    }

    public void setDetail(Long detail) {
        this.detail = detail;
    }

    public String getGoodsCover() {
        return goodsCover;
    }

    public void setGoodsCover(String goodsCover) {
        this.goodsCover = goodsCover == null ? null : goodsCover.trim();
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode == null ? null : countryCode.trim();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityZhName() {
        return cityZhName;
    }

    public void setCityZhName(String cityZhName) {
        this.cityZhName = cityZhName == null ? null : cityZhName.trim();
    }

    public String getArchitect() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect = architect == null ? null : architect.trim();
    }

    public String getBuiltArea() {
        return builtArea;
    }

    public void setBuiltArea(String builtArea) {
        this.builtArea = builtArea == null ? null : builtArea.trim();
    }

    public Integer getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(Integer projectYear) {
        this.projectYear = projectYear;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}