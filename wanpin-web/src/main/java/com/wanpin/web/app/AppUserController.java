package com.wanpin.web.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.exception.ParamIsNullException;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.MD5Utils;
import com.wanpin.common.utils.UploadUtils;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.entity.Question;
import com.wanpin.entity.User;
import com.wanpin.entity.UserGoods;
import com.wanpin.query.UserGoodsQuery;
import com.wanpin.service.QuestionService;
import com.wanpin.service.UserGoodsService;
import com.wanpin.service.UserService;
import com.wanpin.vo.GoodsVO;
import com.wanpin.web.AppBaseController;

@Controller
@RequestMapping("${appAdminPath}/user")
public class AppUserController extends AppBaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserGoodsService userGoodsService;
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * <p>获取用户信息</p>
	 * @author litr 2016年6月21日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getUserInfo${urlSuffix}")
	@ResponseBody
	public Object getUserInfo(HttpServletRequest request)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			// 校验令牌
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			Long userId = WanpinUtils.getUserIdByToken(token);
			User userInfo = userService.getInfo(userId);
			data.put("userId", userInfo.getUserId());
			data.put("mobile", userInfo.getMobile());
			data.put("nickName", userInfo.getNickName());
			data.put("birthday", userInfo.getBirthday());
			data.put("qq", userInfo.getQq());
			data.put("weiXin", userInfo.getWeiXin());
			data.put("university", userInfo.getUniversity());
			data.put("education", userInfo.getEducation());
			data.put("sex", userInfo.getSex());
			data.put("company", userInfo.getCompany());
			data.put("position", userInfo.getPosition());
			data.put("recommendCode", userInfo.getRecommendCode());
			data.put("recommendUser", userInfo.getRecommendUser());
			data.put("headPhoto", userInfo.getHeadPhoto());
			
			// WanpinUtils.removeMapValueIsNull(data);
			
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>更新用户信息</p>
	 * @author litr 2016年6月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateUserInfo${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Object updateUserInfo(User user,HttpServletRequest request)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			user.setUserId(WanpinUtils.getUserIdByToken(token));
			user.setMobile(null);
			user.setUpdateUser(WanpinUtils.getMobileByToken(token));
			user.setUpdateTime(new Date());
			userService.update(user);
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS);
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>用户修改密码</p>
	 * @author litr 2016年6月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updatePwd${urlSuffix}",method = RequestMethod.POST)
	@ResponseBody
	public Object updatePwd(HttpServletRequest request)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			WanpinUtils.checkParams("oldPwd", request, model);
			WanpinUtils.checkParams("newPwd", request, model);
			
			String oldPwd = request.getParameter("oldPwd");
			String newPwd = request.getParameter("newPwd");
			
			User userInfo = userService.getInfo(WanpinUtils.getUserIdByToken(token));
			if (userInfo == null) {
				WanpinUtils.organizeData(model, StatusCodes.MOBILE_NOT_REGISTER);
			} else if (!userInfo.getPassword().equals(MD5Utils.encode(oldPwd))) {
				WanpinUtils.organizeData(model, StatusCodes.OLD_PASSWORD_ERROR);
			} else {
				User user = new User();
				user.setUserId(userInfo.getUserId());
				user.setPassword(MD5Utils.encode(newPwd));
				user.setUpdateUser(userInfo.getMobile());
				user.setUpdateTime(new Date());
				userService.update(user);
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS);
			}
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>用户修改头像</p>
	 * @author litr 2016年7月19日
	 * @param fileHead
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "uploadHead${urlSuffix}")
	@ResponseBody
	public Object uploadHead(HttpServletRequest request)throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			// 校验令牌
			String token = request.getHeader("token");
			if (!checkToken(token, model)) {
				return model;
			}
			// 上传图片的后缀，例如：png
			String fileExt = request.getHeader("fileExt");
			if (StringUtils.isEmpty(fileExt)) {
				WanpinUtils.organizeData(model, StatusCodes.UPLOAD_FILE_SUFFIX_UNSUPPORT, "上传文件扩展名是不允许的扩展名");
				return model;
			}
			
			ServletInputStream inputStream = request.getInputStream();
			UploadUtils upload = new UploadUtils();
			String fileUrl = upload.uploadFile(inputStream, fileExt, request, model);
			if (StringUtils.isEmpty(fileUrl)) {
				return model;
			}
			
			// 更新用户头像
			Long userId = WanpinUtils.getUserIdByToken(token);
			User user = new User();
			user.setUserId(userId);
			user.setHeadPhoto(fileUrl);
			userService.update(user);
			data.put("headPhoto", WanpinUtils.IMG_PREFIX + fileUrl);
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
		} catch (FileUploadException e) {
			
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>用户投诉</p>
	 * @author litr 2016年7月19日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("complain${urlSuffix}")
	@ResponseBody
	public Map<String, Object> complain(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			// 校验令牌
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			// 校验必填参数
			String suggest = WanpinUtils.checkParams("suggest", request, model);
			Byte qs = Byte.valueOf(WanpinUtils.checkParams("source", request, model));
			
			if (suggest.length() > 500) {
				WanpinUtils.organizeData(model, StatusCodes.INVALID_PARAMETER, "suggest参数内容过长");
				return model;
			}
			
			if (qs != SystemEnum.SOURCE_ANDROID && qs != SystemEnum.SOURCE_IOS) {
				WanpinUtils.organizeData(model, StatusCodes.INVALID_PARAMETER, "source参数无效");
				return model;
			}
			
			Date date = new Date();
			Question q = new Question();
			q.setUserId(WanpinUtils.getUserIdByToken(token));
			q.setQuestionTime(date);
			q.setQuestion(suggest);
			q.setQuestionStatus((byte) SystemEnum.NO);
			q.setQuestionSource(qs);
			q.setCreateUser(WanpinUtils.getMobileByToken(token));
			q.setCreateTime(date);
			questionService.save(q);
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS);
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * <p>app用户收藏（取消收藏）方案信息</p>
	 * @author litr 2016年6月21日
	 * @param goodsId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("collect${urlSuffix}")
	@ResponseBody
	public Map<String, Object> collect(Long goodsId,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			WanpinUtils.checkParams("goodsId", request, model);
			
			Long userId = WanpinUtils.getUserIdByToken(token);
			UserGoods userGoods = userGoodsService.getByUserIdAndGoodsId(userId, goodsId);
			if (userGoods == null) {
				UserGoods ug = new UserGoods();
				ug.setUserId(userId);
				ug.setGoodsId(goodsId);
				userGoodsService.save(ug);
				// WanpinUtils.organizeData(model, StatusCodes.GOODS_COLLECT);
				data.put("isCollect", "1");
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			} else {
				userGoodsService.deleteByUserIdAndGoodsIds(userId, goodsId);
				// WanpinUtils.organizeData(model, StatusCodes.GOODS_NOT_COLLECT);
				data.put("isCollect", "0");
				WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
			}
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户收藏（取消收藏）方案信息失败："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>查询用户收藏引擎信息</p>
	 * @author litr 2016年7月21日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("collectEngines${urlSuffix}")
	@ResponseBody
	public Map<String, Object> collectEngines(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			Integer pageNo = Integer.valueOf(WanpinUtils.checkParams("pageNo", request, model));
			
			UserGoodsQuery queryObject = new UserGoodsQuery();
			queryObject.getOrderFields().add("ug.collect_time DESC");
			queryObject.setPageNo(pageNo);
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_ENGINE);
			queryObject.setUserId(WanpinUtils.getUserIdByToken(token));
			userGoodsService.queryUserGoods(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines);
			
			data.put("dataList", engines);
			data.put("totalPageNum", String.valueOf(queryObject.getTotalPageNum()));
			
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询收藏的引擎信息失败："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>查询用户收藏的方案商城信息</p>
	 * @author litr 2016年7月21日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("collectGoods${urlSuffix}")
	@ResponseBody
	public Map<String, Object> collectGoods(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			String token = request.getParameter("token");
			if (!checkToken(token, model)) {
				return model;
			}
			
			Integer pageNo = Integer.valueOf(WanpinUtils.checkParams("pageNo", request, model));
			
			UserGoodsQuery queryObject = new UserGoodsQuery();
			queryObject.getOrderFields().add("ug.collect_time DESC");
			queryObject.setPageNo(pageNo);
			queryObject.setGoodsPlaces(SystemEnum.GOODS_PLACES_SHOPPING);
			queryObject.setUserId(WanpinUtils.getUserIdByToken(token));
			userGoodsService.queryUserGoods(queryObject);
			List<Map<String, Object>> engines = new ArrayList<Map<String, Object>>();
			this.organizeGoods(queryObject, engines);

			data.put("dataList", engines);
			data.put("totalPageNum", String.valueOf(queryObject.getTotalPageNum()));
			
			WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户查询收藏的引擎信息失败："+e.getMessage());
		}
		return model;
	}

	/**
	 * <p>组织收藏方案返回数据</p>
	 * @author litr 2016年7月21日
	 * @param queryObject
	 * @param engines
	 */
	private void organizeGoods(UserGoodsQuery queryObject, List<Map<String, Object>> engines) {
		List<GoodsVO> goodsVOs = queryObject.getQueryList();
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
			// WanpinUtils.removeMapValueIsNull(map);
			engines.add(map);
		}
	}
	
}
