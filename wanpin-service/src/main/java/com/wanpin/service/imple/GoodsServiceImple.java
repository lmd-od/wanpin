package com.wanpin.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanpin.dao.GoodsDao;
import com.wanpin.entity.Goods;
import com.wanpin.query.GoodsQuery;
import com.wanpin.service.GoodsService;
@Service("goodsService")
public class GoodsServiceImple implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public List<Goods> queryList(GoodsQuery queryObject) throws Exception {
		return goodsDao.queryList(queryObject);
	}

}
