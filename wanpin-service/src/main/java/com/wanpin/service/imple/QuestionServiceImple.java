package com.wanpin.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanpin.dao.QuestionDao;
import com.wanpin.entity.Question;
import com.wanpin.service.QuestionService;
@Service("questionService")
public class QuestionServiceImple implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public void save(Question question) throws Exception {
		if (question.getQuestionId() == null) {
			questionDao.insert(question);
		} else {
			questionDao.update(question);
		}
	}

}
