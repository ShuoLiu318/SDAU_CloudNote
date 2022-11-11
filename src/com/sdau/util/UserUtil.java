package com.sdau.util;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

//import org.apache.tomcat.util.codec.binary.Base64;

public class UserUtil {
	
	//md5+base64
	public static String md5(String msg) throws NoSuchAlgorithmException{
		//��Ϣ���� msg
		MessageDigest md=MessageDigest.getInstance("MD5");
		//msgת��Ϊ�ֽ�����
		byte[] in=msg.getBytes();
		byte[] out=md.digest(in);
		//����md5��out����Ϊ�ַ��������ҷ�ֹ����
		String message= Base64.encodeBase64String(out);
		return message;
	}
	
	//��������û�ID
	public static String creatId(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}
