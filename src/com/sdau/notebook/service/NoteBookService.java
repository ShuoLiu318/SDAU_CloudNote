package com.sdau.notebook.service;

import com.sdau.entity.Result;

public interface NoteBookService {
	//���رʼǱ��б�
	public Result loadNoteBooks(String userId);
	//�½��ʼ�
	public Result addNoteBook(String noteBookName, String userId);
	
}
