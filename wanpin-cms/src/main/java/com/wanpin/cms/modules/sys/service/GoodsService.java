package com.wanpin.cms.modules.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanpin.cms.common.persistence.Page;
import com.wanpin.cms.common.service.BaseService;
import com.wanpin.cms.modules.sys.dao.CountryDao;
import com.wanpin.cms.modules.sys.dao.DictDao;
import com.wanpin.cms.modules.sys.dao.GoodsDao;
import com.wanpin.cms.modules.sys.entity.Goods;
import com.wanpin.common.exception.WanPinExceptionCommon;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.entity.Country;
/**
 * cms 解决方案 service
 * @author MingDing.Li
 */
@Service
public class GoodsService  extends BaseService implements InitializingBean{
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private DictDao dictDao;
	@Autowired
	private CountryDao countryDao;
	
	

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
	public void saveGoods(Goods goods) {
		/** 国别名 */
		Country country = new Country();
		country.setCode(goods.getCountryCode());
		List<Country> countryList = countryDao.findList(country);
		country = countryList.get(0);
		goods.setCountryName(country.getZhName());//存中文国家名
		
		/** 创建时间 */
		goods.setCreateTime(new Date());
		/** 创建用户 */
		goods.setCreateUser(goods.getCurrentUser());
		/** 方案状态 */
		goods.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);//默认是审核通过的
		/** 方案封面*/
		goods.setGoodsCover(goods.getGoodsImage().split(",")[0]);
		
		int size = goodsDao.insert(goods);
		if(size != 1){
			WanPinExceptionCommon.runtimeException("添加方案失败");
		}
	}
	/**
	 * 删除解决方案
	 * @author MingDing.Li
	 * @param goodsId
	 */
	@Transactional(readOnly = false)
    public void deleteGoodById(Goods good) {
    	goodsDao.delete(good);
	}
	
	

}
