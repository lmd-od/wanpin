package com.wanpin.web.sys;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.query.GoodsQuery;
import com.wanpin.service.GoodsService;
import com.wanpin.web.BaseController;

/**
* @Description: 登陆控制器
* @author MingDingLi
* @date 2016年2月26日 上午11:13:51
 */
@Controller
@RequestMapping("${webAdminPath}/goods")
public class GoodsController extends BaseController{
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("golist${urlSuffix}")
	public ModelAndView golist(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("用户中心保存用户信息失败："+e.getMessage());
		}
		return new ModelAndView("goods/goods_home",model);
	}
	
	@RequestMapping("query${urlSuffix}")
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
	}
	
}
