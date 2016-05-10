package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Dict;
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {
	
	public Dict getInfo(String dictCode);
	
}