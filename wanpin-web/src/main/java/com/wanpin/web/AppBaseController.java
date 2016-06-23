package com.wanpin.web;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.utils.LogUtils;
import com.wanpin.common.utils.WanpinUtils;
import com.wanpin.entity.Session;
import com.wanpin.service.SessionService;

/**
 * app控制器支持类
 * @author ThinkGem
 * @version 2013-3-23
 */
public class AppBaseController {
	
	@Autowired
	private SessionService sessionService;
	
	/**
	 * 日志对象
	 */
	protected LogUtils log = new LogUtils();
	
	
	protected boolean checkToken(String token,Map<String, Object> model) throws Exception {
		if (StringUtils.isEmpty(token)) {
			WanpinUtils.organizeData(model, StatusCodes.TOKEN_INVALID);
			return false;
		}
		
		Session s = sessionService.getBySid(token);
		
		if (s == null) {
			WanpinUtils.organizeData(model, StatusCodes.TOKEN_INVALID);
			return false;
		}
		
		return true;
	}
	
	protected void saveToken(String mobile, String token) throws Exception {
		Session s = new Session();
		s.setUserCode(mobile);
		s.setSid(token);
		Date date = new Date();
		s.setBeginDate(date);
		s.setEndDate(date);
		sessionService.save(s);
	}
	
}
