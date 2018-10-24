package com.zhc.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.dataobject.OrderDetail;

import lombok.extern.slf4j.Slf4j;

/**
* @author zhangchi02
* @date 2018年9月30日
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderDetailRepositoryTest {

	@Autowired
	private OrderDetailRepository repository;
	
	@Test
	@Transactional
	public void saveTest(){
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("1234567812");
		orderDetail.setOrderId("1111113");
		orderDetail.setProductIcon("http://xxxx.jpg");
		orderDetail.setProductId("11121212");
		orderDetail.setProductName("皮蛋粥");
		orderDetail.setProductPrice(new BigDecimal(3.2));
		orderDetail.setProductQuantity(2);
		
		OrderDetail result = repository.save(orderDetail);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void findByOrderId(){
		 List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
		 log.info("【查询订单详情列表】result={}",orderDetailList);
		 Assert.assertNotEquals(0,orderDetailList.size());
	}
}
