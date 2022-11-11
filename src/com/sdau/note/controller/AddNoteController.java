package com.sdau.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	@Resource
	private NoteService noteService;

	@RequestMapping("/addnote.do")
	@ResponseBody
	public Result execute(String noteTitle, String noteBookId) {
		Result result = noteService.addNote(noteTitle, noteBookId);

		return result;
	}
}