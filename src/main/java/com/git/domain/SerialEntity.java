package com.git.domain;

import javax.persistence.Table;

@Table(name = "serial_table")
public class SerialEntity {
	private String serialNum;

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}


	
}
