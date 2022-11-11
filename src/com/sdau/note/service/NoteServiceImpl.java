package com.sdau.note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdau.dao.NoteDao;
import com.sdau.entity.Note;
import com.sdau.entity.Result;
import com.sdau.util.NoteUtil;

@Service
public class NoteServiceImpl implements NoteService {

	@Resource
	private NoteDao noteDao;

	// ���رʼ�
	public Result loadNotes(String noteBookId) {
		List<Note> notes = noteDao.findByNoteBookId(noteBookId);
		Result result = new Result();
		result.setStatus(0);
		result.setMsg("���سɹ�");
		result.setData(notes);

		return result;
	}

	// ����±ʼ�
	public Result addNote(String noteTitle, String noteBookId) {

		Note note = new Note();
		String noteId = NoteUtil.creatId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(noteBookId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body("");
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());

		noteDao.insertNote(note);

		Result result = new Result();
		result.setStatus(0);
		result.setMsg("��ӳɹ�");
		result.setData(noteId); // �����½��ʼ�id

		return result;

	}

	// ��ʾѡ�еıʼ�
	public Result showNote(String noteId) {
		Note note = noteDao.findByNoteId(noteId);
		Result result = new Result();
		result.setStatus(0);
		result.setMsg("���ݱʼ�id��ѯ�ʼ�");
		result.setData(note);

		return result;
	}

	//����ʼ�
	public Result saveNote(String noteId, String noteTitle, String noteBody) {
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		
		noteDao.updateNote(note);
		
		Result result=new Result();
		result.setStatus(0);
		result.setMsg("����ʼǳɹ�");
		
		
		return result;
	}

	public Result deleteNote(String noteId) {
		noteDao.deleteNote(noteId);
		
		Result result=new Result();
		result.setStatus(0);
		result.setMsg("�ʼǼ������վ�ɹ�");
		
		return result;
	}

	@Override
	public Result moveNote(String noteBookId, String noteId) {
		Note note=noteDao.findByNoteId(noteId);
		//noteDao.updateNoteBookId(noteBookId, noteId);
		
		Result result=new Result();
		result.setStatus(0);
		result.setMsg("�ƶ��ʼǳɹ�");
		
		return result;
	}
}
