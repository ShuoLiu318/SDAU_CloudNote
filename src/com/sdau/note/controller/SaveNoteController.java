package com.sdau.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class SaveNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/savenote.do")
	@ResponseBody
	public Result execute(String noteId, String noteTitle, String noteBody){
		Result result=noteService.saveNote(noteId, noteTitle, noteBody);
		return result;
	}
}
