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
	
	//加载笔记本列表
	public Result loadNoteBooks(String userId){
		List<NoteBook> noteBooks=noteBookDao.findByUserId(userId);
        Result result=new Result();
        result.setStatus(0);
        result.setMsg("加载成功");
        result.setData(noteBooks);
		return result;
	}
	
	//添加新笔记
	public Result addNoteBook(String noteBookName, String userId){
		NoteBook noteBook=new NoteBook();
		String noteBookId=NoteUtil.creatId();
		noteBook.setCn_notebook_id(noteBookId);
		noteBook.setCn_user_id(userId);
		noteBook.setCn_notebook_name(noteBookName);;
		noteBook.setCn_notebook_type_id("5");
		noteBook.setCn_notebook_desc("人间失格");
		Timestamp time= new Timestamp(System.currentTimeMillis());
		noteBook.setCn_notebook_createtime(time);
		
		noteBookDao.insertNoteBook(noteBook);
		
		Result result=new Result();
		result.setStatus(0);
		result.setMsg("添加成功");
		result.setData(noteBookId);  //返回新建笔记id
		return result;
	}

	
}
