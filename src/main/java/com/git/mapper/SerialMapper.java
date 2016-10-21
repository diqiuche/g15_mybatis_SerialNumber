package com.git.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.git.domain.SerialEntity;
import com.github.abel533.sql.SqlMapper;

@Repository
public class SerialMapper{
	@Autowired
	private SqlMapper sqlMapper;
	
	public SerialEntity maxNum() {
		return this.sqlMapper.selectOne("select max(serial_num) serial_num from serial_table",SerialEntity.class);
	}
	
	public void insert(SerialEntity serialEntity){
		this.sqlMapper.insert("insert into serial_table  values(#{serialNum})", serialEntity);
	}
	
	
	public void cleartable() {
		this.sqlMapper.delete("delete from serial_table");
	}
	
}
