package com.wanpin.service;

import com.wanpin.entity.Question;

public interface QuestionService {

	/**
	 * <p>保存用户投诉问题</p>
	 * <p>若questionId为null，则新增；反之则更新</p>
	 * @author litr 2016年7月16日
	 * @param question
	 * @throws Exception
	 */
	public void save(Question question) throws Exception;
	
}
