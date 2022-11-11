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
	//ע��
	public Result register(String name,String password,String nick) throws NoSuchAlgorithmException {
		Result result=new Result();
		
		//���name�Ƿ��Ѿ�����
		if(userDao.findByUserName(name)==null){
			User user=new User();
			user.setCn_user_id(UserUtil.creatId());
			user.setCn_user_name(name);
			user.setCn_user_password(UserUtil.md5(password));
			user.setCn_user_token("No.1");
			user.setCn_user_nick(nick);
			userDao.insertUser(user);
			result.setStatus(0);
			result.setMsg("ע��ɹ�");
		}else{
			result.setStatus(1);
			result.setMsg("�û����Ѵ���");
		}
		return result;
	}
	
	//��¼��0�ɹ���1�û������ڣ�2�������
	public Result checkLogin(String name, String password) throws NoSuchAlgorithmException {
		Result result=new Result();
		User user=userDao.findByUserName(name);
		if(user==null){  //�û���������
			result.setStatus(1);
			result.setMsg("�û�������");
		}else{  //�û������ڣ���Ҫ�������
			//������ȷ����¼�ɹ�
			if(user.getCn_user_password().equals(UserUtil.md5(password))){
				result.setStatus(0);
				result.setMsg("��¼�ɹ�");
				//��½�ɹ��󣬼��µ�ǰ��¼�ߵ�id
				result.setData(user.getCn_user_id());
			}else{ //������󣬵�¼ʧ��
				result.setStatus(2);
				result.setMsg("�������");
			}
		}
		return result;
	}

}
