package com.sdau.dao;

import java.util.List;

import com.sdau.entity.NoteBook;

public interface NoteBookDao {
	//根据用户名查询当前用户的笔记本
	public List<NoteBook> findByUserId(String userId);
	//插入新的笔记
	public void insertNoteBook(NoteBook noteBook);
}
