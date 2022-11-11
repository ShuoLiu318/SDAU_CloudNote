package com.sdau.note.service;

import com.sdau.entity.Result;

public interface NoteService {
	// 加载选中的笔记本
	public Result loadNotes(String noteBookId);

	// 添加新笔记
	public Result addNote(String noteTitle, String noteBookId);

	// 显示笔记
	public Result showNote(String noteId);
	
	// 保存笔记
	public Result saveNote(String noteId, String noteTitle, String noteBody);
	
	// 删除笔记
	public Result deleteNote(String noteId);
	
	// 移动笔记
	public Result moveNote(String noteBookId, String noteId);
}
