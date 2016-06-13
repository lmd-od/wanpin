package com.wanpin.web.sys;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wanpin.common.utils.MD5Utils;
import com.wanpin.common.utils.SecurityHelper;
import com.wanpin.entity.User;
import com.wanpin.entity.UserGoods;
import com.wanpin.service.UserGoodsService;
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
	
	@Autowired
	private UserGoodsService userGoodsService;
	
	/**
	 * <p>跳转用户信息页面</p>
	 * @author litr 2016年6月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * <p>保存用户信息</p>
	 * @author litr 2016年6月13日
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	
	/**
	 * <p>用户收藏方案信息</p>
	 * @author litr 2016年6月13日
	 * @param goodsId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("collect${urlSuffix}")
	@ResponseBody
	public Map<String, Object> collect(@RequestParam("id") Long goodsId,HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Long userId = SecurityHelper.getUserId(request);
			if (userId != null) {
				UserGoods userGoods = userGoodsService.getByUserIdAndGoodsId(userId, goodsId);
				if (userGoods == null) {
					UserGoods ug = new UserGoods();
					ug.setUserId(userId);
					ug.setGoodsId(goodsId);
					userGoodsService.save(ug);
				} else {
					userGoodsService.deleteByUserIdAndGoodsIds(userId, goodsId);
				}
			}
			this.setSuccessFlag(model);
		} catch (Exception e) {
			this.setFailFlag(model);
			e.printStackTrace();
			log.error("用户收藏方案信息失败："+e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("goChangePwd${urlSuffix}")
	public ModelAndView goChangePwd() throws Exception {
		return new ModelAndView("user/user_change_pass");
	}
	
	/**
	 * <p>用户修改密码</p>
	 * @author litr 2016年6月13日
	 * @param goodsId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("changepwd${urlSuffix}")
	@ResponseBody
	public Map<String, Object> changepwd(HttpServletRequest request) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			String repwd = request.getParameter("repwd");
			if (StringUtils.isEmpty(newpwd) || StringUtils.isEmpty(repwd) || !newpwd.equals(repwd)) {
				setFailFlag(model, "新密码与再次确认密码不一致");
			} else if (StringUtils.isEmpty(oldpwd)) {
				setFailFlag(model, "旧密码不能为空");
			} else {
				User userInfo = userService.getInfo(SecurityHelper.getUserId(request));
				if (!userInfo.getPassword().equals(MD5Utils.encode(oldpwd))) {
					setFailFlag(model, "旧密码输入不正确");
				} else {
					User user = new User();
					user.setUserId(userInfo.getUserId());
					user.setPassword(MD5Utils.encode(newpwd));
					userService.update(user);
					setSuccessFlag(model);
				}
			}
		} catch (Exception e) {
			setFailFlag(model);
			e.printStackTrace();
			log.error("用户收藏方案信息失败："+e.getMessage());
		}
		return model;
	}
	
}
