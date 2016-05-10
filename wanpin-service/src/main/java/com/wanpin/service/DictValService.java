package com.wanpin.service;

import java.util.List;

import com.wanpin.entity.DictVal;

public interface DictValService {

	/**
	 * <p>通过数据字典编码查询数据字典值</p>
	 * <p>查询有效的数据字典值</p>
	 * @author litr 2016年5月10日
	 * @param dictCode
	 * @return
	 */
	public List<DictVal> queryList(String dictCode);
	
	/**
	 * <p>通过字典值ID获取信息</p>
	 * @author litr 2016年5月10日
	 * @param dictValId
	 * @return
	 */
	public DictVal getInfo(Long dictValId);
	
	public void save(DictVal dictVal);
	
	/**
	 * <p>通过数据字典编码删除数据字典值</p>
	 * @author litr 2016年5月10日
	 * @param dictCode
	 */
	public void deleteByDictCode(String dictCode);
	
	/**
	 * <p>通过主键删除字典值</p>
	 * @author litr 2016年5月10日
	 * @param dictValId
	 */
	public void deleteById(Long dictValId);
}
