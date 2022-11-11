package com.sdau.note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	@Resource
	private NoteService noteService;

	@RequestMapping("/deletenote.do")
	@ResponseBody
	public Result execute(String noteId) {
		Result result = noteService.deleteNote(noteId);

		return result;
	}
}