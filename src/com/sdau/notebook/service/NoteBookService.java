package com.sdau.notebook.service;

import com.sdau.entity.Result;

public interface NoteBookService {
	//加载笔记本列表
	public Result loadNoteBooks(String userId);
	//新建笔记
	public Result addNoteBook(String noteBookName, String userId);
	
}
