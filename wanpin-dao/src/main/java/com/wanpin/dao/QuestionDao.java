package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Question;
@MyBatisDao
public interface QuestionDao extends CrudDao<Question> {
	
}
