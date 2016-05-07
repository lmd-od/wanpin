package com.wanpin.sys.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.Des3Utils;
import com.wanpin.service.LogService;


/**
 * 参数自动解密过滤器
 * @author MingDing.Li
 */
public class ParameterDecodeFilter extends OncePerRequestFilter {
	@Autowired
	private LogService logService;
	/* 解密参数名列表 */
	private Map<String,Integer> parameMap = new HashMap<String,Integer>();
	 public ParameterDecodeFilter(){
//		 parameMap.put("sid", 1);
//		 parameMap.put("loginName", 1);
//		 parameMap.put("password", 1);
	 }
	
	/**
	 * DES解密
	 * @author MingDing.Li
	 * @param request
	 * @param input
	 * @return
	 * @throws Exception 
	 */
	private String decode(HttpServletRequest request, String name, String  key) {
		        if(key == null || key.trim().equals("(null)")){
		        	return null;
		        }else{
		        	/* 解密参数池 */
		        	 if(parameMap.get(name) != null&& parameMap.get(name) == 1){
		        		 try {
		        			 if(request.getMethod().equalsIgnoreCase("get")){
		        				 key = key.replaceAll(" ", "+");
		        			 }
		 					return Des3Utils.decode(key);
		 				} catch (Exception e) {
		 					e.printStackTrace();
		 					return null;
		 				}
		        	 }else{
		        		 return key;
		        	 }
		        	
		        }
		        
		    }

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		/** 重写获取参数方式 */
		filterChain.doFilter(new HttpServletRequestWrapper(request) {
		             @Override
		             public String getParameter(String name) {
		            	 /* language 获取用户语言 */
		            	 if("language".equals(name)){
		            		 String ip = super.getRemoteHost();
		            		 String sid = this.getParameter("sid");
		            		 String centLanguage = logService.getLanguage(sid, ip);
		            		 if(centLanguage != null && !"".equals(centLanguage)){
		            			 return centLanguage;
		            		 }else{
		            			 return SystemEnum.SYS_USER_LANGUAGE_ZH;
		            		 } 
		            		 
		            	 }
		                 String value = super.getParameter(name);
		                 return decode(this, name, value);
		             }
		  
		             @Override
		             public String[] getParameterValues(String name) {
		                 String[] values = super.getParameterValues(name);
		                 if (values == null) {
		                     return null;
		                 }
		                 for (int i = 0; i < values.length; i++) {
		                     values[i] = decode(this, name, values[i]);
		                 }
		                 return values;
		             }
		  
		         }, response);
	}

}
