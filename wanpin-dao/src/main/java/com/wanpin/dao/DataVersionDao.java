package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.DataVersion;
@MyBatisDao
public interface DataVersionDao extends CrudDao<DataVersion> {
	
}