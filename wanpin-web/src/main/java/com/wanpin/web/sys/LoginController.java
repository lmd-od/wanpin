package com.wanpin.web.sys;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.CommonUtils;
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
@RequestMapping("${webAdminPath}/login")
public class LoginController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login${urlSuffix}")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String img_code = request.getParameter("img_code");
			if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
				setFailFlag(model, "手机号或密码错误");
			} else if(StringUtils.isEmpty(img_code)){
				setFailFlag(model, "验证码错误");
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo == null) {
					setFailFlag(model, "手机号未注册");
				} else if (userInfo.getStatus() == SystemEnum.USER_STATUS_DISABLED) {
					setFailFlag(model, "用户已被禁用");
				} else if (!userInfo.getPassword().equals(password)) {
					setFailFlag(model, "手机号或密码错误");
				} else {
					setSuccessFlag(model);
					request.getSession().setAttribute(SecurityHelper.USER_INFO, userInfo);
					String action = request.getSession().getAttribute("redirectUrl") == null ? null:request.getSession().getAttribute("redirectUrl").toString();
					if (StringUtils.hasText(action)) {
						model.put("action", action);
					}
				}
			}
		} catch (Exception e) {
			setFailFlag(model,SystemEnum.RESP_SYSTEM_BUSY);
			e.printStackTrace();
			log.error("用户登录失败："+e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("register${urlSuffix}")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String validCode = request.getParameter("code");
			String recommendUser = request.getParameter("recommendUser");
			if (StringUtils.isEmpty(validCode)) {
				setFailFlag(model, "验证码不正确");
			} else if (StringUtils.isEmpty(mobile) || !CommonUtils.isMobileNO(mobile)) {
				setFailFlag(model, "手机号不正确");
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo != null) {
					setFailFlag(model, "手机号已注册");
				} else {
					User user = new User();
					user.setMobile(mobile);
					//user.setPassword(Des3Utils.encode(password));
					user.setPassword(password);
					user.setType(SystemEnum.SYS_USER_TYPE_ORDINARY);
					user.setLanguage(SystemEnum.SYS_USER_LANGUAGE_ZH);
					user.setNickName(mobile);
					user.setRecommendCode(mobile);
					user.setRecommendUser(recommendUser);
					user.setCreateUser(mobile);
					user.setCreateTime(new Date());
					userService.save(user);
					setSuccessFlag(model);
					model.put("url", "/page/login.jsp");
				}
			}
		} catch (Exception e) {
			setFailFlag(model,SystemEnum.RESP_SYSTEM_BUSY);
			e.printStackTrace();
			log.error("用户注册失败："+e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/logout.do")  
    public ModelAndView logout(HttpServletRequest request) throws Exception{
		request.getSession().removeAttribute(SecurityHelper.USER_INFO);
		return new ModelAndView("redirect:/page/login.jsp");
    }
	
}
