package com.wanpin.web.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.MD5Utils;
import com.wanpin.common.utils.SmsUtils;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.entity.User;
import com.wanpin.service.UserService;
import com.wanpin.web.AppBaseController;

@Controller
@RequestMapping("${appAdminPath}/login")
public class AppLoginController extends AppBaseController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * <p>app用户登录</p>
	 * @author litr 2016年6月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login${urlSuffix}")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			
			if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
				WanpinUtils.organizeData(model, StatusCodes.MOBILE_PASSWORD_NULL);
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo == null) {
					WanpinUtils.organizeData(model, StatusCodes.MOBILE_NOT_REGISTER);
				} else if (userInfo.getStatus() == SystemEnum.USER_STATUS_DISABLED) {
					WanpinUtils.organizeData(model, StatusCodes.MOBILE_DISABLED);
				} else if (!userInfo.getPassword().equals(MD5Utils.encode(password))) {
					WanpinUtils.organizeData(model, StatusCodes.MOBILE_PASSWORD_ERROR);
				} else {
					String token = WanpinUtils.getToken(userInfo.getMobile(), userInfo.getUserId());
					this.saveToken(mobile, token);
					data.put("token", token);
					WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
					return model;
				}
			}
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("用户登录失败："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>app用户注册</p>
	 * @author litr 2016年6月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("register${urlSuffix}")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String code = request.getParameter("code");
			String password = request.getParameter("password");
			String recommendUser = request.getParameter("recommendUser");
			
			if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
				WanpinUtils.organizeData(model, StatusCodes.MOBILE_PASSWORD_NULL);
			} else if (!SmsUtils.checkSMSCode(mobile, code, model, request)) {
				return model;
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo != null) {
					WanpinUtils.organizeData(model, StatusCodes.MOBILE_REGISTER);
				} else {
					userInfo = new User();
					userInfo.setMobile(mobile);
					userInfo.setPassword(MD5Utils.encode(password));
					userInfo.setType(SystemEnum.SYS_USER_TYPE_ORDINARY);
					userInfo.setLanguage(SystemEnum.SYS_USER_LANGUAGE_ZH);
					userInfo.setNickName(mobile);
					userInfo.setRecommendCode(mobile);
					userInfo.setRecommendUser(recommendUser);
					userInfo.setCreateUser(mobile);
					userInfo.setCreateTime(new Date());
					userService.save(userInfo);
					String token = WanpinUtils.getToken(mobile, userInfo.getUserId());
					// 保存令牌
					this.saveToken(mobile, token);
					data.put("token", token);
					WanpinUtils.organizeData(model, StatusCodes.SUCCESS, data);
				}
			}
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("用户注册失败："+e.getMessage());
		}
		return model;
	}
	
	/**
	 * <p>忘记密码修改密码</p>
	 * @author litr 2016年6月20日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("forgetPwd${urlSuffix}")
	@ResponseBody
	public Map<String, Object> forgetPwd(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String mobile = request.getParameter("mobile");
			String code = request.getParameter("code");
			String password = request.getParameter("password");
			
			if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)) {
				WanpinUtils.organizeData(model, StatusCodes.MOBILE_PASSWORD_NULL);
			} else if (!SmsUtils.checkSMSCode(mobile, code, model, request)) {
				return model;
			} else {
				User userInfo = userService.getInfoByMobile(mobile);
				if (userInfo == null) {
					WanpinUtils.organizeData(model, StatusCodes.MOBILE_NOT_REGISTER);
				} else {
					User user = new User();
					user.setUserId(userInfo.getUserId());
					user.setPassword(MD5Utils.encode(password));
					user.setUpdateUser(mobile);
					user.setUpdateTime(new Date());
					userService.update(user);
					//String token = WanpinUtils.getToken(mobile, userInfo.getUserId());
					//model.put("token", token);
					WanpinUtils.organizeData(model, StatusCodes.SUCCESS);
				}
			}
			
		} catch (Exception e) {
			WanpinUtils.organizeData(model, StatusCodes.SYSTEM_BUSY);
			e.printStackTrace();
			log.error("用户通过忘记密码修改失败："+e.getMessage());
		}
		return model;
	}
	
}
