package com.wanpin.cms.modules.sys.dao;


import com.wanpin.cms.common.persistence.CrudDao;
import com.wanpin.cms.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Country;

/**
 * 国家 dao
 * @author MingDing.Li
 */
@MyBatisDao
public interface CountryDao extends CrudDao<Country>{

}
