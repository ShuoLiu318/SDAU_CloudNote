package com.sdau.util;

import java.util.UUID;

public class NoteUtil {
	//��������ʼ�id
	public static String creatId(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}
