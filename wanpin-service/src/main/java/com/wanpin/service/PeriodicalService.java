package com.wanpin.service;

import com.wanpin.entity.Periodical;

public interface PeriodicalService {

	/**
	 * <p>通过期刊ID获取期刊信息（包含期刊项信息）</p>
	 * @author litr 2016年6月17日
	 * @param periodicalId
	 * @return
	 * @throws Exception
	 */
	public Periodical getByPeriodicalId(Long periodicalId) throws Exception;
	
	/**
	 * <p>通过所属产品获取期刊信息（包含期刊项信息）</p>
	 * <ul>
	 * 	<li>包含期刊项信息</li>
	 * 	<li>查询状态为有效的期刊</li>
	 * </ul>
	 * @author litr 2016年6月17日
	 * @param belongProduct
	 * @return
	 * @throws Exception
	 */
	public Periodical getByBelongProduct(String belongProduct) throws Exception;
	
}
