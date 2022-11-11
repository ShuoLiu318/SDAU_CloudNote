package com.sdau.user.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.user.service.UserService;


@Controller
@RequestMapping("/user")
public class RegisterController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/register.do") //http://localhast:8080/SDAU_CloudNote/user/register.do
	@ResponseBody//将返回的内容转换为JSON
	public Result execute(String name,String password,String nick) throws Exception {//页面传来的参数
		Result result=userService.register(name,password,nick);
		return result;
		
	}

}
