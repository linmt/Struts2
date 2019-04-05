package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;
/**
 * 用户的业务层的实现类
 */
public class UserServiceImpl implements UserService {
	@Override
	// 业务层用户登录的方法:
	public User login(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.login(user);
	}
}
