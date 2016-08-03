package com.wanpin.web.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			String token = request.getParameter("token");
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_ENGINE);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines, token);
			data.put("dataList", engines);
			data.put("totalPageNum", String.valueOf(queryObject.getTotalPageNum()));
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
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
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			String token = request.getParameter("token");
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_ENGINE);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines, token);
			data.put("dataList", engines);
			data.put("totalPageNum", String.valueOf(queryObject.getTotalPageNum()));
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
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
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			String token = request.getParameter("token");
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_SHOPPING);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			// 查询数据
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines, token);
			data.put("dataList", engines);
			data.put("totalPageNum", String.valueOf(queryObject.getTotalPageNum()));
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
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
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("pageNo", request, model);
			
			String token = request.getParameter("token");
			
			queryObject.getOrderFields().add("a.grade ASC");
			queryObject.getOrderFields().add("a.create_time DESC");
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_ENGINE);
			queryObject.setGoodsStatus(SystemEnum.GOODS_STATUS_PASSED);
			goodsService.queryList(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines, token);
			data.put("dataList", engines);
			data.put("totalPageNum", String.valueOf(queryObject.getTotalPageNum()));
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
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
	 * @param token 访问令牌
	 * @return
	 * @throws Exception 
	 */
	private void organizeGoods(GoodsQuery queryObject, List<Map<String, Object>> engines, String token) throws Exception {
		List<GoodsVO> goodsVOs = queryObject.getQueryList();
		Long userId = WanpinUtils.getUserIdByToken(token);
		for (GoodsVO goodsVO : goodsVOs) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("goodsId", String.valueOf(goodsVO.getGoodsId()));
			map.put("goodsSource", String.valueOf(goodsVO.getGoodsSource()));
			map.put("goodsPlaces", String.valueOf(goodsVO.getGoodsPlaces()));
			map.put("goodsName", goodsVO.getGoodsName());
			map.put("goodsMoney", goodsVO.getGoodsMoney());
			map.put("detail", goodsVO.getDetail());
			map.put("goodsCover", StringUtils.isEmpty(goodsVO.getGoodsCover())?"":(WanpinUtils.IMG_PREFIX+goodsVO.getGoodsCover()));
			// map.put("goodsImage", goodsVO.getGoodsImage());
			map.put("countryName", goodsVO.getCountryName());
			map.put("cityZhName", goodsVO.getCityZhName());
			map.put("architect", goodsVO.getArchitect());
			map.put("builtArea", goodsVO.getBuiltArea());
			map.put("projectYear", String.valueOf(goodsVO.getProjectYear()));
			map.put("grade", String.valueOf(goodsVO.getGrade()));
			map.put("goodsStyleName", goodsVO.getGoodsStyleName());
			map.put("goodsFunctionName", goodsVO.getGoodsFunctionName());
			map.put("goodsHierarchyName", goodsVO.getGoodsHierarchyName());
			
			// 校验用户是否已收藏该信息
			UserGoods ug = userGoodsService.getByUserIdAndGoodsId(userId, goodsVO.getGoodsId());
			map.put("isCollect", ug == null ? "0":"1");
			
			// WanpinUtils.removeMapValueIsNull(map);
			engines.add(map);
		}
	}
	
	@RequestMapping(value = "getInfo${urlSuffix}")
	@ResponseBody
	public Object getInfo(Long goodsId,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			WanpinUtils.checkParams("goodsId", request, model);
			
			GoodsVO goodsVO = goodsService.getGoodsByGoodsId(goodsId);
			if (goodsVO == null || goodsVO.getGoodsStatus() != SystemEnum.GOODS_STATUS_PASSED) {
				WanpinUtils.organizeData(model, StatusCodes.GOODS_OFF_THE_SHELVES);
			} else {
				data.put("goodsId", String.valueOf(goodsVO.getGoodsId()));
				data.put("goodsSource", String.valueOf(goodsVO.getGoodsSource()));
				data.put("goodsPlaces", String.valueOf(goodsVO.getGoodsPlaces()));
				data.put("goodsName", goodsVO.getGoodsName());
				data.put("goodsMoney", goodsVO.getGoodsMoney());
				data.put("detail", goodsVO.getDetail());
				data.put("goodsCover", StringUtils.isEmpty(goodsVO.getGoodsCover())?"":(WanpinUtils.IMG_PREFIX+goodsVO.getGoodsCover()));
				if (StringUtils.hasText(goodsVO.getGoodsImage())) {
					String[] gImgArr = goodsVO.getGoodsImage().split(",");
					List<String> arr = new ArrayList<String>();
					for (String str : gImgArr) {
						arr.add(WanpinUtils.IMG_PREFIX + str);
					}
					data.put("goodsImage", arr);
				}
				// map.put("goodsImage", goodsVO.getGoodsImage());
				data.put("countryName", goodsVO.getCountryName());
				data.put("cityZhName", goodsVO.getCityZhName());
				data.put("architect", goodsVO.getArchitect());
				data.put("builtArea", goodsVO.getBuiltArea());
				data.put("projectYear", String.valueOf(goodsVO.getProjectYear()));
				data.put("grade", String.valueOf(goodsVO.getGrade()));
				data.put("goodsStyleName", goodsVO.getGoodsStyleName());
				data.put("goodsFunctionName", goodsVO.getGoodsFunctionName());
				data.put("goodsHierarchyName", goodsVO.getGoodsHierarchyName());
				
				// 获取用户是否已收藏该方案
				String token = request.getParameter("token");
				if (StringUtils.isEmpty(token) || !checkToken(token, model)) {
					data.put("isCollect", 0);
				} else {
					UserGoods userGoods = userGoodsService.getByUserIdAndGoodsId(WanpinUtils.getUserIdByToken(token), goodsId);
					data.put("isCollect", userGoods == null?0:1);
				}
				
				
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			}
			
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询方案详情信息出错："+e.getMessage());
		}
		return model;
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
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (StringUtils.isEmpty(token)) {
				// WanpinUtils.organizeData(model, StatusCodes.GOODS_NOT_COLLECT);
				data.put("isCollect", "0");
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
				return model;
			}
			
			if (!checkToken(token, model)) {
				return model;
			}
			
			UserGoods userGoods = userGoodsService.getByUserIdAndGoodsId(WanpinUtils.getUserIdByToken(token), goodsId);
			if (userGoods == null) {
				// WanpinUtils.organizeData(model, StatusCodes.GOODS_NOT_COLLECT);
				data.put("isCollect", "0");
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			} else {
				// WanpinUtils.organizeData(model, StatusCodes.GOODS_COLLECT);
				data.put("isCollect", "1");
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			}
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app校验用户是否收藏该方案信息出错："+e.getMessage());
		}
		return model;
	}
	
	@RequestMapping(value = "view/{goodsId}${urlSuffix}")
	public ModelAndView view(@PathVariable Long goodsId,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		String url = "app/engine/engine_view";
		try {
			// String token = request.getParameter("token");
			
			GoodsVO goodsInfo = goodsService.getGoodsByGoodsId(goodsId);
			if (goodsInfo == null || goodsInfo.getGoodsStatus() != SystemEnum.GOODS_STATUS_PASSED) {
				return null;
			}
			
			if (StringUtils.hasText(goodsInfo.getGoodsImage())) {
				model.put("goodsImages", goodsInfo.getGoodsImage().split(","));
			}
			
			if (goodsInfo.getGoodsPlaces() == SystemEnum.GOODS_PLACES_SHOPPING) {
				url = "app/goods/goods_view";
			}
			
			model.put("goodsInfo", goodsInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("app查看详情出错："+e.getMessage());
		}
		return new ModelAndView(url, model);
	}
	
}
