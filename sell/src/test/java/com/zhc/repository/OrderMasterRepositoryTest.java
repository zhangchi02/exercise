package com.zhc.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.dataobject.OrderMaster;

/**
* @author zhangchi02
* @date 2018年9月30日
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

	@Autowired
	private OrderMasterRepository repository;
	
	private final String OPENID="110110";
	
	@Test
	@Transactional
	public void saveTest(){
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("1234567");
		orderMaster.setBuyerName("帅哥");
		orderMaster.setBuyerPhone("12345678912");
		orderMaster.setBuyerAddress("华为基地");
		orderMaster.setBuyerOpenid(OPENID);
		orderMaster.setOrderAmount(new BigDecimal(2.3));
		
		OrderMaster result = repository.save(orderMaster);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void findByBuyerOpenId(){
		PageRequest request = new PageRequest(0,1);
		Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);
		Assert.assertNotEquals(0, result.getTotalElements());
	}
}
