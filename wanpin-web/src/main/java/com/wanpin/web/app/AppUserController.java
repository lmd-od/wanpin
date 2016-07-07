package com.wanpin.web.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.exception.ParamIsNullException;
import com.wanpin.common.utils.MD5Utils;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.entity.User;
import com.wanpin.entity.UserGoods;
import com.wanpin.service.UserGoodsService;
import com.wanpin.service.UserService;
import com.wanpin.web.AppBaseController;

@Controller
@RequestMapping("${appAdminPath}/user")
public class AppUserController extends AppBaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserGoodsService userGoodsService;
	
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
			
			WanpinUtils.removeMapValueIsNull(data);
			
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
				WanpinUtils.organizeData(model, StatusCodes.GOODS_COLLECT);
			} else {
				userGoodsService.deleteByUserIdAndGoodsIds(userId, goodsId);
				WanpinUtils.organizeData(model, StatusCodes.GOODS_NOT_COLLECT);
			}
		} catch (ParamIsNullException e) {
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("app用户收藏（取消收藏）方案信息失败："+e.getMessage());
		}
		return model;
	}
	
}
