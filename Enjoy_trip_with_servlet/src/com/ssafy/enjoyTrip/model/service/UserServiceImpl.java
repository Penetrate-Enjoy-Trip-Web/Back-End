package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.dto.User;
import com.ssafy.enjoyTrip.model.dao.UserDao;
import com.ssafy.enjoyTrip.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao = UserDaoImpl.getInstance();
	
	private static UserService instance = new UserServiceImpl();
	private UserServiceImpl() {}
	public static UserService getInstance() {
		return instance;
	}
	
	@Override
	public User checkIdPw(User user) throws Exception {
		return userDao.selectIdPw(user);
	}
	@Override
	public void register(User user) throws Exception {
		userDao.insertUser(user);
	}
}
