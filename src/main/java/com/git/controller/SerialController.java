package com.git.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.git.service.SerialService;

@Controller
@RequestMapping("serialController")
public class SerialController {
	@Autowired
	private SerialService serialService;
	
	@RequestMapping("nextNum")
	@ResponseBody
	public String nextNum(){
		return this.serialService.nextNum();
	}
}
