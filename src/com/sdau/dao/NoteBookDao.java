package com.sdau.dao;

import java.util.List;

import com.sdau.entity.NoteBook;

public interface NoteBookDao {
	//�����û�����ѯ��ǰ�û��ıʼǱ�
	public List<NoteBook> findByUserId(String userId);
	//�����µıʼ�
	public void insertNoteBook(NoteBook noteBook);
}
