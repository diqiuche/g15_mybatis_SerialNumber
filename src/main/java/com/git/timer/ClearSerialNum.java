package com.git.timer;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.git.service.SerialService;

public class ClearSerialNum {
	@Autowired
	private SerialService serialService;
	
	@Scheduled(cron = "0 0/1 * * * ?")
	public void clear(){
		this.serialService.clearTable();
		System.out.println("在时间："+DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss")+"执行流水号清零");
	}
}
