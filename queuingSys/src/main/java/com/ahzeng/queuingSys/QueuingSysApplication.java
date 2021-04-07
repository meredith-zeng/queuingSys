package com.ahzeng.queuingSys;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages={"com.ahzeng.queuingSys"})
@MapperScan("com.ahzeng.queuingSys.mapper")
public class QueuingSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueuingSysApplication.class, args);
	}

}
