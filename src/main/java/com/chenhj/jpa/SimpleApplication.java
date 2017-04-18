package com.chenhj.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplication{
	
	private static Logger logger = LogManager.getLogger();
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
		logger.info("工程启动成功...");
	}
}
