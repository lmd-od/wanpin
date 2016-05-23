package com.wanpin.cms.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanpin.cms.common.persistence.Page;
import com.wanpin.cms.common.service.BaseService;
import com.wanpin.cms.modules.sys.dao.GoodsDao;
import com.wanpin.cms.modules.sys.entity.Goods;
/**
 * cms 解决方案 service
 * @author MingDing.Li
 */
@Service
public class GoodsService  extends BaseService implements InitializingBean{
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public void afterPropertiesSet() throws Exception {
	}
	/**
	 * 分页查询解决方案
	 * @author MingDing.Li
	 * @param page
	 * @param goods
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<Goods> findGoods(Page<Goods> page, Goods goods){
		//设置分页
		goods.setPage(page);
		page.setList(goodsDao.findList(goods));
		return page;
	}
	
	/**
	 * 不分页查询
	 * @author MingDing.Li
	 * @param user
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Goods> findGoods(Goods goods){
		
		
		return null;
	}
	
	/**
	 * 保存解决方案
	 * @author MingDing.Li
	 * @param Goods
	 */
	@Transactional(readOnly = false)
	public void saveGoods(Goods Goods) {
		
	}

}
