package com.wanpin.dao;

import com.wanpin.common.persistence.CrudDao;
import com.wanpin.common.persistence.annotation.MyBatisDao;
import com.wanpin.vo.GoodsVO;
@MyBatisDao
public interface GoodsDao extends CrudDao<GoodsVO>{
	
}
