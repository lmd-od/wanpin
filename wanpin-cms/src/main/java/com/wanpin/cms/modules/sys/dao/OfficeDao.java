/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/wanpin">wanpin</a> All rights reserved.
 */
package com.wanpin.cms.modules.sys.dao;

import com.wanpin.cms.common.persistence.TreeDao;
import com.wanpin.cms.common.persistence.annotation.MyBatisDao;
import com.wanpin.cms.modules.sys.entity.Office;

/**
 * 机构DAO接口
 * @author MingDingLi
 * @version 2014-05-16
 */
@MyBatisDao
public interface OfficeDao extends TreeDao<Office> {
	
}
