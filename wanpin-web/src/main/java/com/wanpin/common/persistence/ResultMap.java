package com.wanpin.common.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;

/**
 * app 请求返回 map 封装
 * @author MingDing.Li
 */
public class ResultMap{
	private Map<String,Object> map = new HashMap<String,Object>();
	public ResultMap(){
		putStatus(SystemEnum.APP_RES_STATUS_SUCCESS);//默认是成功的
		putMsg(SystemEnum.APP_RES_MSG_SUCCESS);//默认处理成功
		putResult(new ArrayList<Object>());//默认空 集合
	}
	
	public void putStatus(String status){
		this.map.put("status", status);
	}
	public void putMsg(String msg){
		this.map.put("msg", msg);
	}
	
	public void putResult(Object result){
		this.map.put("result", result);
	}
	/**
	 * 直接返回 map
	 * @author MingDing.Li
	 * @return
	 */
	public Map<String,Object> getMap(){
		return this.map;
	}
	/**
	 * 返回 json 串
	 * @author MingDing.Li
	 * @return
	 */
	public String getJSONString(){
		JSONObject jObject = new JSONObject();
		jObject.putAll(this.map);
		return jObject.toJSONString();
	}
}
