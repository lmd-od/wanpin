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
import com.wanpin.common.utils.MD5Utils;
import com.wanpin.common.utils.SecurityHelper;
import com.wanpin.common.utils.SmsUtils;
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
	
	/**
	 * <p>跳转登录页面</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("goLogin${urlSuffix}")  
    public ModelAndView goLogin(HttpServletRequest request) throws Exception{
		return new ModelAndView("login");
    }
	
	/**
	 * <p>跳转注册页面</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("goRegister${urlSuffix}")  
    public ModelAndView goRegister(HttpServletRequest request) throws Exception{
		return new ModelAndView("register");
    }
	
	/**
	 * <p>跳转忘记密码页面</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("goForgetPwd${urlSuffix}")  
    public ModelAndView goForgetPwd(HttpServletRequest request) throws Exception{
		return new ModelAndView("forget_pwd");
    }
	
	/**
	 * <p>登录</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login${urlSuffix}")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			//String img_code = request.getParameter("img_code");
			/* else if(StringUtils.isEmpty(img_code)){
				setFailFlag(model, "验证码错误");
			}*/
			if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
				setFailFlag(model, "手机号或密码错误");
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo == null) {
					setFailFlag(model, "手机号未注册");
				} else if (userInfo.getStatus() == SystemEnum.USER_STATUS_DISABLED) {
					setFailFlag(model, "用户已被禁用");
				} else if (!userInfo.getPassword().equals(MD5Utils.encode(password))) {
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
	
	/**
	 * <p>注册</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("register${urlSuffix}")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String validCode = request.getParameter("code");
			String recommendUser = request.getParameter("recommendUser");
			
			if (StringUtils.isEmpty(mobile) || !CommonUtils.isMobileNO(mobile)) {
				setFailFlag(model, "手机号不正确");
			} else if (!SmsUtils.validMobileCodeIsValid(mobile, validCode, request)) {
				setFailFlag(model, "验证码不正确");
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo != null) {
					setFailFlag(model, "手机号已注册");
				} else {
					User user = new User();
					user.setMobile(mobile);
					//user.setPassword(Des3Utils.encode(password));
					user.setPassword(MD5Utils.encode(password));
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
	
	/**
	 * <p>忘记密码进行修改密码操作</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("changepwd${urlSuffix}")
	@ResponseBody
	public Map<String, Object> changepwd(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String newpwd = request.getParameter("newpassword");
			String repwd = request.getParameter("repassword");
			String validCode = request.getParameter("code");
			if (StringUtils.isEmpty(mobile) || !CommonUtils.isMobileNO(mobile)) {
				setFailFlag(model, "手机号不正确");
			} else if (!SmsUtils.validMobileCodeIsValid(mobile, validCode, request)) {
				setFailFlag(model, "验证码不正确");
			} else if (StringUtils.isEmpty(newpwd) || StringUtils.isEmpty(repwd) || !newpwd.equals(repwd)) {
				setFailFlag(model, "新密码与再次确认密码不一致");
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo == null) {
					setFailFlag(model, "手机号未注册");
				} else {
					User user = new User();
					user.setUserId(userInfo.getUserId());
					user.setPassword(MD5Utils.encode(newpwd));
					userService.update(user);
					setSuccessFlag(model);
				}
			}
		} catch (Exception e) {
			setFailFlag(model,SystemEnum.RESP_SYSTEM_BUSY);
			e.printStackTrace();
			log.error("用户注册失败："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>退出登录</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("logout${urlSuffix}")  
    public ModelAndView logout(HttpServletRequest request) throws Exception{
		request.getSession().removeAttribute(SecurityHelper.USER_INFO);
		return new ModelAndView("redirect:/php/login/goLogin.php");
    }
	
}
