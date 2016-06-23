package com.wanpin.query;

import com.wanpin.common.query.BaseQuery;
import com.wanpin.entity.Periodical;

public class PeriodicalQuery extends BaseQuery<Periodical> {

	private Integer[] status;// 状态
	
	private Integer[] belongProduct;// 所属产品

	public Integer[] getStatus() {
		return status;
	}

	public void setStatus(Integer... status) {
		this.status = status;
	}

	public Integer[] getBelongProduct() {
		return belongProduct;
	}

	public void setBelongProduct(Integer... belongProduct) {
		this.belongProduct = belongProduct;
	}
	
}
