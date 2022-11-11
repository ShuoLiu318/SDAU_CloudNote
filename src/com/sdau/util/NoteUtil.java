package com.sdau.util;

import java.util.UUID;

public class NoteUtil {
	//随机创建笔记id
	public static String creatId(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}
