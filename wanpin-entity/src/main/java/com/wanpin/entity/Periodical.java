package com.wanpin.entity;

import java.util.Date;
import java.util.List;

public class Periodical {
    private Long periodicalId;

    private String belongProduct;// 所属产品
    
    private String content;// 期刊内容

    private Integer status;// 状态 1：是，0：否

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    
    private List<PeriodicalItem> periodicalItems;//期刊条目

    public Long getPeriodicalId() {
        return periodicalId;
    }

    public void setPeriodicalId(Long periodicalId) {
        this.periodicalId = periodicalId;
    }

    public String getBelongProduct() {
        return belongProduct;
    }

    public void setBelongProduct(String belongProduct) {
        this.belongProduct = belongProduct == null ? null : belongProduct.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public List<PeriodicalItem> getPeriodicalItems() {
		return periodicalItems;
	}

	public void setPeriodicalItems(List<PeriodicalItem> periodicalItems) {
		this.periodicalItems = periodicalItems;
	}
    
}