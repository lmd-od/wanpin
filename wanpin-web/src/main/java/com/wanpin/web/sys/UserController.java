package com.wanpin.web.sys;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView gobase() throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Long userId = SecurityHelper.getUserId();
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
	public Map<String, Object> save(User user) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			if (user != null) {
				userService.save(user);
			}
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("用户中心保存用户信息失败："+e.getMessage());
		}
		return model;
	}
	
}
