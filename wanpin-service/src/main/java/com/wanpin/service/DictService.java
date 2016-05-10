package com.wanpin.service;

import java.util.List;

import com.wanpin.entity.Dict;
import com.wanpin.query.DictQuery;

public interface DictService {

	/**
	 * <p>查询数据字典列表</p>
	 * @author litr 2016年5月10日
	 * @param queryObject
	 * @return
	 */
	public List<Dict> queryList(DictQuery queryObject);
	
	/**
	 * <p>通过数据字典编码查询数据字典信息</p>
	 * @author litr 2016年5月10日
	 * @param dictId
	 * @return
	 */
	public Dict getInfo(String dictCode);
	
	/**
	 * <p>通过数据字典编码删除数据字典</p>
	 * <p>该操作会级联删除数据字典值数据，慎重操作</p>
	 * @author litr 2016年5月10日
	 * @param dictId
	 */
	public void delete(String dictCode);
}
