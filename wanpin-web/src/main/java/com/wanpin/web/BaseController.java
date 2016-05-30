package com.wanpin.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.LogUtils;

/**
 * 控制器支持类
 * @author ThinkGem
 * @version 2013-3-23
 */
public class BaseController {
	
	/**
	 * 日志对象
	 */
	protected LogUtils log = new LogUtils();
	/**
	 * 管理基础路径
	 */
	@Value("${adminPath}")
	protected String adminPath;
	
	/**
	 * 前端基础路径
	 */
	@Value("${frontPath}")
	protected String frontPath;
	
	/**
	 * 前端URL后缀
	 */
	@Value("${urlSuffix}")
	protected String urlSuffix;
	
	/**
	 * 客户端返回字符串
	 * @author MingDing.Li
	 * @param response
	 * @param string
	 * @param type
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
	        response.setContentType(type);
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	protected void setSuccessFlag(Map<String, Object> model) {
		model.put("status", SystemEnum.RESP_STATUS_SUCCESS);
	}
	
	protected void setFailFlag(Map<String, Object> model,String msg) {
		model.put("status", SystemEnum.RESP_STATUS_FAIL);
		if (StringUtils.hasText(msg)) {
			model.put("msg", msg);
		}
	}
	
	protected void setFailFlag(Map<String, Object> model,Integer status) {
		model.put("status", status);
	}
	
	protected void setFailFlag(Map<String, Object> model,Integer status,String msg) {
		model.put("status", status);
		if (StringUtils.hasText(msg)) {
			model.put("msg", msg);
		}
	}
	
	protected void setFailFlag(Map<String, Object> model) {
		setFailFlag(model,"");
	}
	
}
