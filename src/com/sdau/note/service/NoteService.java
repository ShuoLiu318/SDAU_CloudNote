package com.sdau.note.service;

import com.sdau.entity.Result;

public interface NoteService {
	// ����ѡ�еıʼǱ�
	public Result loadNotes(String noteBookId);

	// ����±ʼ�
	public Result addNote(String noteTitle, String noteBookId);

	// ��ʾ�ʼ�
	public Result showNote(String noteId);
	
	// ����ʼ�
	public Result saveNote(String noteId, String noteTitle, String noteBody);
	
	// ɾ���ʼ�
	public Result deleteNote(String noteId);
	
	// �ƶ��ʼ�
	public Result moveNote(String noteBookId, String noteId);
}
