package com.git.controller.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.git.service.SerialService;

@Controller
public class ClearSerialNum {
	@Autowired
	private SerialService serialService;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void clear(){
		this.serialService.clearTable();
		System.out.println("执行");
	}
}
