package com.roh.restful;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.roh.restful.board.mapper.TestMapper;


@EnableResourceServer
@SpringBootApplication
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private TestMapper testMapper;
	
	@Bean
	public void test() {
		
	}
}
