package com.sdau.dao;

import java.util.List;

import com.sdau.entity.Note;

public interface NoteDao {
	// ����ѡ�бʼǱ�
	public List<Note> findByNoteBookId(String noteBookId);

	// ����±ʼ�
	public void insertNote(Note note);

	// ����ѡ�бʼ�
	public Note findByNoteId(String noteId);
	
	// ����ʼ�
	public void updateNote(Note note);
	
	// ɾ���ʼ�
	public void deleteNote(String noteId);
	
	// �ƶ��ʼ�
	public void updateNote(String noteBookId, String noteId);
}
