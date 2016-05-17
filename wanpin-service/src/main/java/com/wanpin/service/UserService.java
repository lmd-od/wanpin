package com.wanpin.service;

import com.wanpin.entity.User;

public interface UserService {

	/**
	 * <p>获取用户信息</p>
	 * @author litr 2016年5月15日
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User getInfo(Long userId) throws Exception;
	
	/**
	 * <p>通过手机号获取用户信息</p>
	 * @author litr 2016年5月15日
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public User getInfoByMobile(String mobile) throws Exception;
	
	/**
	 * <p>保存用户信息</p>
	 * <p>若userId为空，则进行新增操作；反之进行更新操作</p>
	 * @author litr 2016年5月15日
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception;
	
	/**
	 * <p>通过userId更新用户信息</p>
	 * @author litr 2016年5月15日
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception;
	
}
