package com.zhc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

	@Test
	public void test1(){
		String name = "SimonJang";
		String password = "123456";
		
		log.debug("debug...");
		log.info("name: {}, password: {}", name, password);
		log.error("error...");
		log.warn("warn...");
	}
}
