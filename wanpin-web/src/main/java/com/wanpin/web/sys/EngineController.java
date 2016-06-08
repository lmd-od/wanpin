package com.wanpin.web.sys;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.query.GoodsQuery;
import com.wanpin.service.GoodsService;
import com.wanpin.vo.GoodsVO;
import com.wanpin.web.BaseController;

/**
* @Description: 登陆控制器
* @author MingDingLi
* @date 2016年2月26日 上午11:13:51
 */
@Controller
@RequestMapping("${webAdminPath}/engine")
public class EngineController extends BaseController{
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("golist${urlSuffix}")
	public ModelAndView golist(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("跳转引擎页面失败："+e.getMessage());
		}
		return new ModelAndView("engine/engine_home",model);
	}
	
	/*@RequestMapping("query${urlSuffix}")
	@ResponseBody
	public Map<String, Object> query(GoodsQuery queryObject,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_SHOPPING);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			queryObject.setPageSize(20);
			goodsService.queryList(queryObject);
			model.put("result", queryObject);
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("查询方案商城信息失败："+e.getMessage());
		}
		return model;
	}*/
	
	@RequestMapping("query${urlSuffix}")
	public ModelAndView query(GoodsQuery queryObject,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_ENGINE);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			queryObject.setPageSize(20);
			goodsService.queryList(queryObject);
			model.put("result", queryObject);
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("查询引擎信息失败："+e.getMessage());
		}
		return new ModelAndView("engine/engine_list",model);
	}
	
	@RequestMapping("info/{goodsId}${urlSuffix}")
	public ModelAndView get(@PathVariable Long goodsId,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			GoodsVO goods = goodsService.getGoodsByGoodsId(goodsId);
			if (goods == null || goods.getGoodsStatus() != SystemEnum.GOODS_STATUS_PASSED || goods.getGoodsPlaces() != SystemEnum.GOODS_PLACES_ENGINE) {
				return null;
			}
			if (StringUtils.hasText(goods.getGoodsImage())) {
				model.put("goodsImages", goods.getGoodsImage().split(","));
			}
			model.put("goods", goods);
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("查询引擎详情信息失败："+e.getMessage());
		}
		return new ModelAndView("engine/engine_detail",model);
	}
	
}
