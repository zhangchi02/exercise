package com.zhc.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhc.dataobject.OrderDetail;
import com.zhc.dataobject.OrderMaster;
import com.zhc.dto.OrderDTO;
import com.zhc.enums.OrderStatusEnum;
import com.zhc.enums.PayStatusEnum;

import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;

/**
* @author zhangchi02
* @date 2018年10月15日
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	private final String BUYER_OPENID="1101110";
	
	private final String ORDERID="123456";
	
	@Test
	public void testCreate() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerPhone("12345678912");
		orderDTO.setBuyerOpenid(BUYER_OPENID);
		orderDTO.setBuyerName("SimonJang");
		orderDTO.setBuyerAddress("huawei");
		
		//购物车
		List<OrderDetail> orderDetailList = new ArrayList<>();
		
		OrderDetail orderDetail1 = new OrderDetail();
		orderDetail1.setProductId("123456");
		orderDetail1.setProductQuantity(2);
		orderDetailList.add(orderDetail1);
		
		OrderDetail orderDetail2 = new OrderDetail();
		orderDetail2.setProductId("123457");
		orderDetail2.setProductQuantity(2);
		orderDetailList.add(orderDetail2);
		
		orderDTO.setOrderDetailList(orderDetailList);
		
		OrderDTO result = orderServiceImpl.create(orderDTO);
		
		log.info("【创建订单】result={}",result);
		
		Assert.assertNotNull(result);
		
	}

	@Test
	public void testFindOne() {
		OrderDTO result = orderServiceImpl.findOne(ORDERID);
		log.info("【查询单个订单】result={}",result);
		Assert.assertEquals(ORDERID, result.getOrderId());
	}

	@Test
	public void testFindList() {
		PageRequest request = new PageRequest(0,2);
		Page<OrderDTO> orderDTOPage = orderServiceImpl.findList(BUYER_OPENID, request);
		log.info("【查询订单列表】result={}",orderDTOPage.getContent());
		Assert.assertNotSame(0, orderDTOPage.getTotalElements());
	}

	@Test
	public void testCancel() {
		OrderDTO orderDTO = orderServiceImpl.findOne(ORDERID);
		OrderDTO result = orderServiceImpl.cancel(orderDTO);
		Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
	}

	@Test
	public void testFinish() {
		OrderDTO orderDTO = orderServiceImpl.findOne(ORDERID);
		OrderDTO result = orderServiceImpl.finish(orderDTO);
		Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
	}

	@Test
	public void testPaid() {
		OrderDTO orderDTO = orderServiceImpl.findOne(ORDERID);
		OrderDTO result = orderServiceImpl.paid(orderDTO);
		Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
	}

}
