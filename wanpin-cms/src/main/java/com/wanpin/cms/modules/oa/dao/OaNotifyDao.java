/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/wanpin">wanpin</a> All rights reserved.
 */
package com.wanpin.cms.modules.oa.dao;

import com.wanpin.cms.common.persistence.CrudDao;
import com.wanpin.cms.common.persistence.annotation.MyBatisDao;
import com.wanpin.cms.modules.oa.entity.OaNotify;

/**
 * 通知通告DAO接口
 * @author MingDingLi
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyDao extends CrudDao<OaNotify> {
	
	/**
	 * 获取通知数目
	 * @param oaNotify
	 * @return
	 */
	public Long findCount(OaNotify oaNotify);
	
}