package com.wanpin.service;

import com.wanpin.entity.User;

public interface LogService {
	/**
	 * 登录业务
	 * @author MingDing.Li
	 * @param user
	 * @return
	 */
	public User login(User user,String ip);
	
	/**
	 * 获取当前登录用户
	 * @author MingDing.Li
	 * @param sid
	 * @return
	 */
	public User loginUser(String sid);
	
	/**
	 * 根据 ip 获取游客信息
	 * @author MingDing.Li
	 * @param ip
	 * @return
	 */
	public User getVisitorUser(String ip);
	/**
	 * 获取当前用户语言(有 sid 就获取用户语言,否则就用 ip 获取游客语言信息)
	 * @author MingDing.Li
	 * @param sid
	 * @param ip
	 * @return
	 */
	public String getLanguage(String sid, String ip);
}
