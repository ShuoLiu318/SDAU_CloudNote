package com.sdau.dao;

import com.sdau.entity.User;

public interface UserDao {
	//ע��
	public void insertUser(User user);
	public User findByUserName(String name);

}
