package com.git.service.impl;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.domain.SerialEntity;
import com.git.mapper.SerialMapper;
import com.git.service.SerialService;
@Service
public class SerialServiceImpl implements SerialService{
	private static final String STR_FORMAT = "00000";
	private static final String START="00000";
	@Autowired
	private SerialMapper serialMapper;
	
	@Override
	public synchronized String nextNum() {
		SerialEntity serialEntity = this.serialMapper.maxNum();
		
		serialEntity.setSerialNum(this.increase(serialEntity.getSerialNum()));
		
		this.serialMapper.insert(serialEntity);
		return serialEntity.getSerialNum();
	}
	
	@Override
	public void clearTable(){
		this.serialMapper.cleartable();
		SerialEntity serialEntity = new SerialEntity();
		serialEntity.setSerialNum(START);
		this.serialMapper.insert(serialEntity);
	}
	
	public String increase(String serialNum){
		Integer temp = Integer.parseInt(serialNum);  
	    temp++;
	    DecimalFormat df = new DecimalFormat(STR_FORMAT);  
	    return df.format(temp);
	}
}
