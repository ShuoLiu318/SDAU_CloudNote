package com.sdau.notebook.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sdau.dao.NoteBookDao;
import com.sdau.entity.NoteBook;
import com.sdau.entity.Result;
import com.sdau.util.NoteUtil;

@Service
public class NoteBookServiceImpl implements NoteBookService{
	
	@Resource
	private NoteBookDao noteBookDao;
	
	//���رʼǱ��б�
	public Result loadNoteBooks(String userId){
		List<NoteBook> noteBooks=noteBookDao.findByUserId(userId);
        Result result=new Result();
        result.setStatus(0);
        result.setMsg("���سɹ�");
        result.setData(noteBooks);
		return result;
	}
	
	//����±ʼ�
	public Result addNoteBook(String noteBookName, String userId){
		NoteBook noteBook=new NoteBook();
		String noteBookId=NoteUtil.creatId();
		noteBook.setCn_notebook_id(noteBookId);
		noteBook.setCn_user_id(userId);
		noteBook.setCn_notebook_name(noteBookName);;
		noteBook.setCn_notebook_type_id("5");
		noteBook.setCn_notebook_desc("�˼�ʧ��");
		Timestamp time= new Timestamp(System.currentTimeMillis());
		noteBook.setCn_notebook_createtime(time);
		
		noteBookDao.insertNoteBook(noteBook);
		
		Result result=new Result();
		result.setStatus(0);
		result.setMsg("��ӳɹ�");
		result.setData(noteBookId);  //�����½��ʼ�id
		return result;
	}

	
}
