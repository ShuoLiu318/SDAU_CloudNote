package com.sdau.user.service;

import com.sdau.entity.Result;

public interface UserService {
	//???
	public Result register(String name,String password,String nick) throws Exception ;
	//???
	public Result checkLogin(String name, String password) throws Exception;
	
}
