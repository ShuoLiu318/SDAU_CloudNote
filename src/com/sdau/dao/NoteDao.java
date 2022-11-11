package com.sdau.dao;

import java.util.List;

import com.sdau.entity.Note;

public interface NoteDao {
	// 加载选中笔记本
	public List<Note> findByNoteBookId(String noteBookId);

	// 添加新笔记
	public void insertNote(Note note);

	// 加载选中笔记
	public Note findByNoteId(String noteId);
	
	// 保存笔记
	public void updateNote(Note note);
	
	// 删除笔记
	public void deleteNote(String noteId);
	
	// 移动笔记
	public void updateNote(String noteBookId, String noteId);
}
