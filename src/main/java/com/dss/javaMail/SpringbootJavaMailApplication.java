package com.dss.javaMail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mybatis mapper 的包路径
@MapperScan(basePackages = "com.dss.javaMail.mapper")
public class SpringbootJavaMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJavaMailApplication.class, args);
	}
}
