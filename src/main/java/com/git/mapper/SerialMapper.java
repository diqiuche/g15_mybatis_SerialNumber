package com.git.mapper;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.git.domain.SerialEntity;
import com.github.abel533.sql.SqlMapper;

@Repository
public class SerialMapper{
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	public SerialEntity maxNum() {
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactoryBean.getObject().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlMapper sqlMapper = new SqlMapper(openSession);
		return sqlMapper.selectOne("select max(serial_num) serial_num from serial_table",SerialEntity.class);
	}
	public void insert(SerialEntity serialEntity){
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactoryBean.getObject().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlMapper sqlMapper = new SqlMapper(openSession);
		sqlMapper.insert("insert into serial_table  values(#{serialNum})", serialEntity);
	}
	
	
	public void cleartable() {
		SqlSession openSession = null;
		try {
			openSession = sqlSessionFactoryBean.getObject().openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlMapper sqlMapper = new SqlMapper(openSession);
		sqlMapper.delete("delete from serial_table");
	}
	
}
