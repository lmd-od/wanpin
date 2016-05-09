package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Session;

@MyBatisDao
public interface SessionDao extends CrudDao<Session> {
	
}
