package com.wanpin.service.imple;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanpin.common.exception.WanPinExceptionCommon;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.common.utils.RanNumGainUtils;
import com.wanpin.dao.SessionDao;
import com.wanpin.dao.UserDao;
import com.wanpin.entity.Session;
import com.wanpin.entity.User;
import com.wanpin.service.LogService;

/**
 * LogService
* @Description: 登陆 Service
* @author MingDingLi
* @date 2016年2月25日 下午7:06:07
 */
@Service
@Transactional(readOnly = true)
public class LogServiceImple extends BaseServiceImple implements LogService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private SessionDao sessionDao;
	
    /**
     * 登录业务
     */
	@Override
	@Transactional(readOnly = false)
	public User login(User user,String ip) {
		/** 1.验证用户 */
		User userL = userDao.login(user);
		if(userL == null){
			if(SystemEnum.SYS_USER_LANGUAGE_EN.equals(user.getLanguage())){
				WanPinExceptionCommon.runtimeException("Wrong username or password");
			}else{
				WanPinExceptionCommon.runtimeException("用户名或密码错误");
			}
		}
		
		/** 2.添加 session */
		Session session = new Session();
		session.setUserCode(userL.getUserCode());//根据 userCode 查询 session
		session = sessionDao.get(session);
		Date endDate = new Date();
		endDate.setDate(endDate.getDate() + 1);// 保留登录1天时间
		if(session != null){
			session.setBeginDate(new Date());
			session.setEndDate(endDate);
			session.setSid(RanNumGainUtils.random("SID"));// 新sid
			/* 跟新 session */
			sessionDao.update(session);
			userL.setSid(session.getSid());
		}else{
			/* 创建新的 session */
			Session sessionN = new Session();
			sessionN.setBeginDate(new Date());
			sessionN.setEndDate(endDate);
			sessionN.setUserCode(userL.getUserCode());
			sessionN.setSid(RanNumGainUtils.random("SID"));
			sessionDao.insert(sessionN);
			userL.setSid(sessionN.getSid());
		}
		
		/** 3.更新用户登录时间 ip */
		userL.setOldLoginIp(userL.getLoginIp());
		userL.setOldLoginDate(userL.getLoginDate());
		userL.setLoginIp(ip);
		userL.setLoginDate(new Date());
		userDao.update(userL);
		return userL;
	}
    
	/**
	 * 获取当前登录用户信息
	 */
	@Override
	public User loginUser(String sid) {
		/** 根据 sid 获取 session */
		Session session = new Session();
		session.setSid(sid);
		session = sessionDao.get(session);
		if(session == null || session.getEndDate().getTime() > new Date().getTime()){
			return null;
		}
		
		/** 根据 user_code 获取用户信息 */
		User user = new User();
		user.setUserCode(session.getUserCode());
		return userDao.get(user);
	}
    
	/**
	 * 根据 ip 获取游客信息
	 */
	@Override
	public User getVisitorUser(String ip) {
		/** 根据 ip 获取用户信息 */
		User user = new User();
		user.setUserCode(ip);
		user.setType(SystemEnum.SYS_USER_TYPE_VISITOR);
		user = userDao.get(user);
		if(user != null){
			return user;
		}
		
		/** 创建游客信息 */
		user = new User();
		user.setUserCode(ip);
		user.setType(SystemEnum.SYS_USER_TYPE_VISITOR);
		user.setCreateDate(new Date());
		user.setLoginIp(ip);
		user.setLoginDate(new Date());
		user.setLanguage(SystemEnum.SYS_USER_LANGUAGE_ZH);
		userDao.insert(user);
		return user;
	}
	
	/**
	 * 获取当前用户语言(有 sid 就获取用户语言,否则就用 ip 获取游客语言信息)
	 */
	public String getLanguage(String sid, String ip){
		/** 根据 sid 获取登录用户语言 */
		if(sid != null && !"".equals(sid.trim())){
			User loginuser = this.loginUser(sid.trim());
			if(loginuser != null){
				return loginuser.getLanguage();
			}
		}
		
		/** 如果是游客就获取游客语言信息 */
		if(ip != null && !"".equals(ip.trim())){
			User visitorUser = this.getVisitorUser(ip.trim());
			if(visitorUser != null){
				return visitorUser.getLanguage();
			}
		}
		return null;
	}
	
}
