package com.sdau.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.user.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource
	private UserService service;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Result execute(String name, String password) throws Exception{
		Result result=service.checkLogin(name, password);
		return result;
	}
}
