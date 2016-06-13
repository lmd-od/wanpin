package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.UserGoods;
@MyBatisDao
public interface UserGoodsDao extends CrudDao<UserGoods> {
	
}