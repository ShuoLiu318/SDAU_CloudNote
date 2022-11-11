package com.sdau.user.service;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdau.dao.UserDao;
import com.sdau.entity.Result;
import com.sdau.entity.User;
import com.sdau.util.UserUtil;



@Service
public class UserServiceImpl implements UserService{
	@Resource
    private UserDao userDao;
	//注册
	public Result register(String name,String password,String nick) throws NoSuchAlgorithmException {
		Result result=new Result();
		
		//检测name是否已经存在
		if(userDao.findByUserName(name)==null){
			User user=new User();
			user.setCn_user_id(UserUtil.creatId());
			user.setCn_user_name(name);
			user.setCn_user_password(UserUtil.md5(password));
			user.setCn_user_token("No.1");
			user.setCn_user_nick(nick);
			userDao.insertUser(user);
			result.setStatus(0);
			result.setMsg("注册成功");
		}else{
			result.setStatus(1);
			result.setMsg("用户名已存在");
		}
		return result;
	}
	
	//登录：0成功，1用户不存在，2密码错误
	public Result checkLogin(String name, String password) throws NoSuchAlgorithmException {
		Result result=new Result();
		User user=userDao.findByUserName(name);
		if(user==null){  //用户名不存在
			result.setStatus(1);
			result.setMsg("用户不存在");
		}else{  //用户名存在，需要检测密码
			//密码正确，登录成功
			if(user.getCn_user_password().equals(UserUtil.md5(password))){
				result.setStatus(0);
				result.setMsg("登录成功");
				//登陆成功后，记下当前登录者的id
				result.setData(user.getCn_user_id());
			}else{ //密码错误，登录失败
				result.setStatus(2);
				result.setMsg("密码错误！");
			}
		}
		return result;
	}

}
