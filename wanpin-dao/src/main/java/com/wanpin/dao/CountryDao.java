package com.wanpin.dao;

import java.util.List;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Country;

/**
 * 国家 dao
 * @author MingDing.Li
 */
@MyBatisDao
public interface CountryDao extends CrudDao<Country>{
	/**
	 * 国家列表查询,要吗根据编码查询单个国家,要么查询所有国家列表
	 * @author MingDing.Li
	 * @param country
	 * @return
	 */
	public List<Country> list(Country country);

}
