package com.zhc.girl.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhc.girl.domain.Girl;
import com.zhc.girl.service.GirlService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

	@Autowired
	private GirlService girlService;
	
	@Test
	public void findOneTest(){
		Girl girl = girlService.findOne(2);
		Assert.assertEquals(new Integer(26), girl.getAge());
	}
}
