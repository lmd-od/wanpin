package com.wanpin.service;

import java.util.List;

import com.wanpin.entity.SmsSendRec;

public interface SmsSendRecService {

	/**
	 * <p>通过手机号查询最近一次发送短信记录</p>
	 * @author litr 2016年6月24日
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public SmsSendRec getByMobile(String mobile) throws Exception;
	
	/**
	 * <p>通过ip查询最近一次发送短信记录</p>
	 * @author litr 2016年6月24日
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public SmsSendRec getByIp(String ip) throws Exception;
	
	/**
	 * <p>保存发送记录</p>
	 * <p>若sendRecId为空，则进行新增操作；反之进行更新操作</p>
	 * @author litr 2016年6月24日
	 * @param smsSendRec
	 * @throws Exception
	 */
	public void save(SmsSendRec smsSendRec) throws Exception;
	
	/**
	 * <p>批量保存发送记录信息</p>
	 * @author litr 2016年6月24日
	 * @param smsSendRecs
	 * @throws Exception
	 */
	public void saveList(List<SmsSendRec> smsSendRecs) throws Exception;
	
}
