package com.sdau.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdau.dao.NoteBookDao;
import com.sdau.dao.NoteDao;
import com.sdau.dao.UserDao;
import com.sdau.entity.Note;
import com.sdau.entity.NoteBook;


public class TestNoteBook {
	@Test
	public void test01(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		NoteBookDao noteBookDao=ac.getBean("noteBookDao",NoteBookDao.class);
		
		List<NoteBook> ns=noteBookDao.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
		for(NoteBook n:ns){
			System.out.println(n.getCn_notebook_name());
		}
	}
	
	@Test
	public void test02(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		
		Note note=new Note();
		
		note.setCn_note_id("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		note.setCn_note_title("修改111");
		note.setCn_note_body("大水水水水");
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		
		dao.updateNote(note);
		Note note2=dao.findByNoteId("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		System.out.println(note2.getCn_note_title()+" "+note2.getCn_note_body());
	}
	
	@Test
	public void test03(){
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		
		dao.deleteNote("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		
		Note note=dao.findByNoteId("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		System.out.println(note.getCn_note_title()+" "+note.getCn_note_id());
	}
}
