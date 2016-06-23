package com.wanpin.web.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.exception.ParamIsNullException;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.entity.UserGoods;
import com.wanpin.query.GoodsQuery;
import com.wanpin.service.GoodsService;
import com.wanpin.service.UserGoodsService;
import com.wanpin.vo.GoodsVO;
import com.wanpin.web.AppBaseController;

@Controller
@RequestMapping("${appAdminPath}/goods")
public class AppGoodsController extends AppBaseController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private UserGoodsService userGoodsService;
	
	@RequestMapping(value = "queryAll${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Object queryAll(GoodsQuery queryObject,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			// queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_SHOPPING);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines);
			model.put("dataList", engines);
			model.put("totalPageNum", queryObject.getTotalPageNum());
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询方案信息出错："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>查询语音搜索结果</p>
	 * @author litr 2016年6月21日
	 * @param queryObject
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryVoice${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Object queryVoice(GoodsQuery queryObject,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			// queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_SHOPPING);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines);
			model.put("dataList", engines);
			model.put("totalPageNum", queryObject.getTotalPageNum());
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询方案信息出错："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>查询方案商城信息</p>
	 * @author litr 2016年6月21日
	 * @param queryObject
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryGoods${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Object queryGoods(GoodsQuery queryObject,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_SHOPPING);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines);
			model.put("dataList", engines);
			model.put("totalPageNum", queryObject.getTotalPageNum());
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询方案信息出错："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>查询方案引擎信息</p>
	 * @author litr 2016年6月21日
	 * @param queryObject
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryEngines${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Object queryEngines(GoodsQuery queryObject,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_ENGINE);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines);
			model.put("dataList", engines);
			model.put("totalPageNum", queryObject.getTotalPageNum());
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询引擎信息出错："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>组织方案返回数据</p>
	 * @author litr 2016年6月21日
	 * @param queryObject
	 * @param engines 
	 * @return
	 */
	private void organizeGoods(GoodsQuery queryObject, List<Map<String, Object>> engines) {
		List<GoodsVO> goodsVOs = queryObject.getQueryList();
		for (GoodsVO goodsVO : goodsVOs) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("goodsId", goodsVO.getGoodsId());
			map.put("goodsSource", goodsVO.getGoodsSource());
			map.put("goodsPlaces", goodsVO.getGoodsPlaces());
			map.put("goodsName", goodsVO.getGoodsName());
			map.put("goodsMoney", goodsVO.getGoodsMoney());
			map.put("detail", goodsVO.getDetail());
			map.put("goodsCover", goodsVO.getGoodsCover());
			map.put("goodsImage", goodsVO.getGoodsImage());
			map.put("countryName", goodsVO.getCountryName());
			map.put("cityZhName", goodsVO.getCityZhName());
			map.put("architect", goodsVO.getArchitect());
			map.put("builtArea", goodsVO.getBuiltArea());
			map.put("projectYear", goodsVO.getProjectYear());
			map.put("grade", goodsVO.getGrade());
			map.put("goodsStyleName", goodsVO.getGoodsStyleName());
			map.put("goodsFunctionName", goodsVO.getGoodsFunctionName());
			map.put("goodsHierarchyName", goodsVO.getGoodsHierarchyName());
			WanpinUtils.removeMapValueIsNull(map);
			engines.add(map);
		}
	}

	/**
	 * <p>校验用户是否已收藏该方案信息</p>
	 * @author litr 2016年6月21日
	 * @param goodsId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "checkCollect${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkCollect(@RequestParam("id") Long goodsId,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (StringUtils.isEmpty(token)) {
				WanpinUtils.organizeData(model, StatusCodes.GOODS_NOT_COLLECT);
				return model;
			}
			
			if (!checkToken(token, model)) {
				return model;
			}
			
			UserGoods userGoods = userGoodsService.getByUserIdAndGoodsId(WanpinUtils.getUserIdByToken(token), goodsId);
			if (userGoods == null) {
				WanpinUtils.organizeData(model, StatusCodes.GOODS_NOT_COLLECT);
			} else {
				WanpinUtils.organizeData(model, StatusCodes.GOODS_COLLECT);
			}
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app校验用户是否收藏该方案信息出错："+e.getMessage());
		}
		return model;
	}
	
}
