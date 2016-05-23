package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.Goods;
@MyBatisDao
public interface GoodsDao extends CrudDao<Goods>{
	
}
