package com.ahzeng.queuingSys;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages={"com.ahzeng.queuingSys"})
@MapperScan("com.ahzeng.queuingSys.mapper")
public class QueuingSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueuingSysApplication.class, args);
	}

	//这里配置静态资源文件的路径导包都是默认的直接导入就可以
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		//因为有这一句，static目录下的静态资源才能被加载，适用标准目录
		registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
	}

}
