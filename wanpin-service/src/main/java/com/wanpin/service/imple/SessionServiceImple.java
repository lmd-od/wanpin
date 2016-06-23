package com.wanpin.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.SessionDao;
import com.wanpin.entity.Session;
import com.wanpin.service.SessionService;
@Service("sessionService")
public class SessionServiceImple implements SessionService {

	@Autowired
	private SessionDao sessionDao;
	
	@Override
	public Session getByUserCode(String userCode) throws Exception {
		if (StringUtils.hasText(userCode)) {
			Session s = new Session();
			s.setUserCode(userCode);
			return sessionDao.get(s);
		}
		return null;
	}

	@Override
	public Session getBySid(String sid) throws Exception {
		if (StringUtils.hasText(sid)) {
			Session s = new Session();
			s.setSid(sid);
			return sessionDao.get(s);
		}
		return null;
	}

	@Override
	public void save(Session session) throws Exception {
		Session s = getByUserCode(session.getUserCode());
		if (s == null) {
			sessionDao.insert(session);
		} else {
			sessionDao.update(session);
		}
	}
	
	

}
