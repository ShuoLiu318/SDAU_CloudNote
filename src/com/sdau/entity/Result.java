package com.sdau.entity;

import java.io.Serializable;

public class Result implements Serializable{//ʵ��ϵ���л��ӿڿ��Խ����ݶ�д������
	private Object data;//����
	private int status;//״̬
	private String msg;//��Ϣ
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
