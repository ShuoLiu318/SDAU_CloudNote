package com.sdau.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public Result execute(String noteBookId){
		Result result=(Result) noteService.loadNotes(noteBookId);
		return result;
	}
}
