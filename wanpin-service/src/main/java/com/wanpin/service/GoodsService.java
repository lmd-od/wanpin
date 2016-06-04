package com.wanpin.service;

import java.util.List;

import com.wanpin.query.GoodsQuery;
import com.wanpin.vo.GoodsVO;

public interface GoodsService {

	/**
	 * <p>查询引擎或者方案列表</p>
	 * <p>执行流程：</p>
	 * <p>注意事项：</p>
	 * @author litr 2016年6月1日
	 * @param queryObject
	 * @return
	 * @throws Exception
	 */
	public List<GoodsVO> queryList(GoodsQuery queryObject) throws Exception;
	
}
