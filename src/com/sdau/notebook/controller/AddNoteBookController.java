package com.sdau.notebook.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdau.entity.Result;
import com.sdau.notebook.service.NoteBookService;

@Controller
@RequestMapping("/notebook")
public class AddNoteBookController {
    @Resource
	private NoteBookService noteBookService;
		
	@RequestMapping("/addnotebook.do")
	@ResponseBody
	public Result execute(String noteBookName, String userId){
		Result result=noteBookService.addNoteBook(noteBookName, userId);
		
		return result;
    }
}
