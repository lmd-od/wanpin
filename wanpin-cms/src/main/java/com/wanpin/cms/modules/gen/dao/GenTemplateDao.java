/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/wanpin">wanpin</a> All rights reserved.
 */
package com.wanpin.cms.modules.gen.dao;

import com.wanpin.cms.common.persistence.CrudDao;
import com.wanpin.cms.common.persistence.annotation.MyBatisDao;
import com.wanpin.cms.modules.gen.entity.GenTemplate;

/**
 * 代码模板DAO接口
 * @author MingDingLi
 * @version 2013-10-15
 */
@MyBatisDao
public interface GenTemplateDao extends CrudDao<GenTemplate> {
	
}
