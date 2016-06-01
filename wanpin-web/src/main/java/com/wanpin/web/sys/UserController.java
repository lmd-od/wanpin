package com.wanpin.web.sys;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.common.utils.SecurityHelper;
import com.wanpin.entity.User;
import com.wanpin.service.UserService;
import com.wanpin.web.BaseController;

/**
* @Description: 登陆控制器
* @author MingDingLi
* @date 2016年2月26日 上午11:13:51
 */
@Controller
@RequestMapping("${webAdminPath}/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("gobase${urlSuffix}")
	public ModelAndView gobase(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Long userId = SecurityHelper.getUserId(request);
			if (userId != null) {
				User user = userService.getInfo(userId);
				model.put("user", user);
			}
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("用户中心保存用户信息失败："+e.getMessage());
		}
		return new ModelAndView("user/user_base",model);
	}
	
	@RequestMapping("save${urlSuffix}")
	@ResponseBody
	public Map<String, Object> save(User user,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (user != null) {
				user.setUserId(SecurityHelper.getUserId(request));
				user.setMobile(null);
				if (StringUtils.hasText(user.getRealName())) {
					user.setNickName(user.getRealName());
				}
				userService.save(user);
				setSuccessFlag(model);
				User userInfo = userService.getInfo(SecurityHelper.getUserId(request));
				request.getSession().setAttribute(SecurityHelper.USER_INFO, userInfo);;
			}
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("用户中心保存用户信息失败："+e.getMessage());
		}
		return model;
	}
	
}
