package com.wanpin.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.wanpin.common.constants.StatusCodes;
import com.wanpin.common.exception.ParamIsNullException;

/**
 * <p>组织app请求返回参数</p>
 * @author litr 2016年6月16日
 * @version 1.0
 */
public class WanpinUtils {

	/**响应返回的结果值*/
	private static final String STATUS_CODE = "statusCode";
	/**失败信息*/
	private static final String ERROR_MSG = "errorMsg";
	/**返回数据*/
	private static final String DATA = "data";
	
	public static final String IMG_PREFIX = "http://res.wanpin.sh";
	
	/**
	 * <p>对返回对象中赋值</p>
	 * @author litr 2016年6月16日
	 * @param model 返回对象
	 * @param statusCode 状态码
	 * @param errorMsg 错误信息
	 * @param data 返回数据
	 */
	public static void organizeData(Map<String, Object> model,String statusCode,String errorMsg,Object data){
		model.put(STATUS_CODE, statusCode);
		if (statusCode.equals(StatusCodes.SUCCESS)) {
			model.put(ERROR_MSG, "");
		} else {
			model.put(ERROR_MSG, StringUtils.hasText(errorMsg)? errorMsg : StatusCodes.ERROR_MSG.get(statusCode));
		}
		model.put(DATA, data);
	}
	
	/**
	 * <p>对返回对象中赋值</p>
	 * @author litr 2016年6月20日
	 * @param model 返回对象
	 * @param statusCode 状态码
	 * @param data 返回数据
	 */
	public static void organizeData(Map<String, Object> model,String statusCode,Object data){
		organizeData(model, statusCode, null, data);
	}
	
	public static void organizeData(Map<String, Object> model, String statusCode, String errorMsg){
		model.put(STATUS_CODE, statusCode);
		if (statusCode.equals(StatusCodes.SUCCESS)) {
			model.put(ERROR_MSG, "");
		} else {
			model.put(ERROR_MSG, StringUtils.hasText(errorMsg)? errorMsg : StatusCodes.ERROR_MSG.get(statusCode));
		}
		model.put(DATA, new HashMap<String, Object>());
	}
	
	public static void organizeData(Map<String, Object> model, String statusCode){
		organizeData(model, statusCode, null);
	}
	
	/**
	 * <p>判断传过来的必填字段是否为空;如果为空返回false如果不为空返回true</p>
	 * @author litr 2016年6月16日
	 * @param fieldStr 以','分割的字段名
	 * @param request
	 * @return
	 * @throws ParamIsNullException 
	 */
	public static Boolean isRequiredFields(String fieldStr, Map<String, Object> model, HttpServletRequest request) throws ParamIsNullException{
		if(StringUtils.isEmpty(fieldStr)) return true;
		
		String[] fields = fieldStr.split(",");
		if(fields != null && fields.length > 0){
			for(String field : fields){
				String temp = request.getParameter(field);
				if(StringUtils.isEmpty(temp) || temp.trim() == ""){
					WanpinUtils.organizeData(model, StatusCodes.MUST_PARAMETER_NULL, field + StatusCodes.ERROR_MSG.get(StatusCodes.MUST_PARAMETER_NULL));
					throw new ParamIsNullException();
				}
			}
		}
		return true;
	}
	
	/**
	 * <p>校验参数是否为空；若为空，则抛出ParamIsNullException异常，反之返回该参数的值</p>
	 * @author litr 2016年6月21日
	 * @param paramName
	 * @param request
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	public static String checkParams(String paramName, HttpServletRequest request,
			Map<String, Object> model) throws ParamIsNullException {
		String param = request.getParameter(paramName);
		if (StringUtils.hasText(param)) {
			return param.trim();
		} else {
			WanpinUtils.organizeData(model, StatusCodes.MUST_PARAMETER_NULL, paramName + StatusCodes.ERROR_MSG.get(StatusCodes.MUST_PARAMETER_NULL));
			throw new ParamIsNullException();
		}
	}
	
	/**
	 * <p>移除map中value值为空的属性</p>
	 * @author litr 2016年6月16日
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	public static void removeMapValueIsNull(Map<String,Object> map){
		if(map != null && map.size() > 0){
			  Iterator it = map.entrySet().iterator();
			  while (it.hasNext()) {
				   Map.Entry entry = (Map.Entry) it.next();
				   Object value = entry.getValue();
				   if(value == null){
					   it.remove();
				   }
			  }
		}
	}
	
	/**
	 * <p>获取手机登录令牌</p>
	 * @author litr 2016年6月20日
	 * @param mobile
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public static String getToken(String mobile,Long userId) throws Exception {
		String str = mobile + "-" + userId + "-" + RanNumGainUtils.getRandomNum(6);
		return Base64.encode(str);
	}
	
	/**
	 * <p>通过令牌获取手机号</p>
	 * @author litr 2016年6月20日
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String getMobileByToken(String token) throws Exception {
		if (StringUtils.isEmpty(token)) {
			return null;
		}
		String[] array = Base64.decode(token).split("-");
		return array[0];
	}
	
	/**
	 * <p>通过令牌获取userId</p>
	 * @author litr 2016年6月20日
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static Long getUserIdByToken(String token) throws Exception {
		if (StringUtils.isEmpty(token)) {
			return null;
		}
		String[] array = Base64.decode(token).split("-");
		return Long.valueOf(array[1]);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(getToken("15036900300", 1L));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
