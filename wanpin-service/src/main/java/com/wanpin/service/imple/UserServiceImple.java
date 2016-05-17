package com.wanpin.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wanpin.dao.UserDao;
import com.wanpin.entity.User;
import com.wanpin.service.UserService;
@Service("userService")
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getInfo(Long userId) throws Exception {
		if (userId != null) {
			User user = new User();
			user.setUserId(userId);
			return userDao.get(user);
		}
		return null;
	}

	@Override
	public User getInfoByMobile(String mobile) throws Exception {
		if (StringUtils.hasText(mobile)) {
			User user = new User();
			user.setMobile(mobile);
			return userDao.get(user);
		}
		return null;
	}

	@Override
	public void save(User user) throws Exception {
		if (user.getUserId() == null) {
			userDao.insert(user);
		} else {
			userDao.update(user);
		}
	}

	@Override
	public void update(User user) throws Exception {
		if (user != null && user.getUserId() != null) {
			userDao.update(user);
		}
	}

}
