package com.wanpin.service;

import java.util.List;

import com.wanpin.entity.DataVersion;
import com.wanpin.query.DataVersionQuery;

public interface DataVersionService {

	/**
	 * <p>查询数据版本信息</p>
	 * @author litr 2016年6月17日
	 * @param queryObject
	 * @return
	 * @throws Exception
	 */
	public List<DataVersion> queryList(DataVersionQuery queryObject) throws Exception;
	
	/**
	 * <p>通过数据编码获取版本</p>
	 * @author litr 2016年6月16日
	 * @param dataCode 数据编码
	 * @return
	 * @throws Exception
	 */
	public DataVersion getByDataCode(String dataCode) throws Exception;
	
}
