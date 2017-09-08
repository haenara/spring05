package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@Component
@Setter
@Getter
@CommonsLog
public class CountryDao {

	@Autowired
	DataSource ds;
	
	//생성시에 이것을 호출해준다. (생성이후에)
	@PostConstruct
	public void postConstruct(){
		log.info("################");
		log.info("postConstruct");
		log.info("################");
		
	}
	
	
	@PreDestroy
	public void preDestruct(){
		log.info("################");
		log.info("preDestruct");
		log.info("################");
		
	}
	
	public List<String> selectAll() throws SQLException{
	
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = 
				conn.prepareStatement("select name from country");
		ResultSet rs = pstmt.executeQuery();
		
		List<String> list = new ArrayList<>();
		
		while(rs.next()){
			list.add(rs.getString("name"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
		
	}
}