package com.itheima.dao;

import com.itheima.domain.User;

/**
 * 用户的DAO的接口
 */
public interface UserDao {
	User login(User user);
}
