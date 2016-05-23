/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/wanpin">wanpin</a> All rights reserved.
 */
package com.wanpin.cms.modules.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanpin.cms.common.service.CrudService;
import com.wanpin.cms.modules.test.dao.TestDao;
import com.wanpin.cms.modules.test.entity.Test;

/**
 * 测试Service
 * @author MingDingLi
 * @version 2013-10-17
 */
@Service
@Transactional(readOnly = true)
public class TestService extends CrudService<TestDao, Test> {

}
