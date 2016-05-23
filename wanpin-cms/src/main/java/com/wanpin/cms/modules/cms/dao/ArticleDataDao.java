/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/wanpin">wanpin</a> All rights reserved.
 */
package com.wanpin.cms.modules.cms.dao;

import com.wanpin.cms.common.persistence.CrudDao;
import com.wanpin.cms.common.persistence.annotation.MyBatisDao;
import com.wanpin.cms.modules.cms.entity.ArticleData;

/**
 * 文章DAO接口
 * @author MingDingLi
 * @version 2013-8-23
 */
@MyBatisDao
public interface ArticleDataDao extends CrudDao<ArticleData> {
	
}
