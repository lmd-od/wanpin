package com.wanpin.service;

import java.util.List;

import com.wanpin.query.GoodsQuery;
import com.wanpin.vo.GoodsVO;

public interface GoodsService {

	/**
	 * <p>查询引擎或者方案列表</p>
	 * @author litr 2016年6月1日
	 * @param queryObject
	 * @return
	 * @throws Exception
	 */
	public List<GoodsVO> queryList(GoodsQuery queryObject) throws Exception;
	
	/**
	 * <p>通过方案ID获取方案详情</p>
	 * @author litr 2016年6月7日
	 * @param goodsId 方案ID
	 * @return
	 * @throws Exception
	 */
	public GoodsVO getGoodsByGoodsId(Long goodsId) throws Exception;
	
}
