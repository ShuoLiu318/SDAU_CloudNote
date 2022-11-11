package com.sdau.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class MoveNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/movenote.do")
	@ResponseBody
	public Result execute(String noteBookId, String noteId){
		Result result=(Result) noteService.moveNote(noteBookId, noteId);
		return result;
	}
}
