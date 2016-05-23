/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/wanpin">wanpin</a> All rights reserved.
 */
package com.wanpin.cms.modules.cms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanpin.cms.common.service.CrudService;
import com.wanpin.cms.modules.cms.dao.ArticleDataDao;
import com.wanpin.cms.modules.cms.entity.ArticleData;

/**
 * 站点Service
 * @author MingDingLi
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class ArticleDataService extends CrudService<ArticleDataDao, ArticleData> {

}
