package com.wanpin.dao;

import java.util.List;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.entity.UserGoods;
import com.wanpin.query.UserGoodsQuery;
import com.wanpin.vo.GoodsVO;
@MyBatisDao
public interface UserGoodsDao extends CrudDao<UserGoods> {
	
	public List<GoodsVO> queryUserGoods(UserGoodsQuery queryObject);
	
}