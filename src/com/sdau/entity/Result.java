package com.sdau.entity;

import java.io.Serializable;

public class Result implements Serializable{//实现系序列化接口可以将数据读写到磁盘
	private Object data;//数据
	private int status;//状态
	private String msg;//消息
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
