package com.wanpin.service;

import com.wanpin.entity.Session;

public interface SessionService {

	/**
	 * <p>通过手机号获取session信息</p>
	 * @author litr 2016年6月21日
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public Session getByUserCode(String userCode) throws Exception;
	
	/**
	 * <p>通过sid查询session信息</p>
	 * @author litr 2016年6月21日
	 * @param sid
	 * @return
	 * @throws Exception
	 */
	public Session getBySid(String sid) throws Exception;
	
	/**
	 * <p>保存session信息</p>
	 * <p>若userCode已存在进行更新操作，反之进行新增操作</p>
	 * @author litr 2016年6月21日
	 * @param session
	 * @throws Exception
	 */
	public void save(Session session) throws Exception;
	
}
