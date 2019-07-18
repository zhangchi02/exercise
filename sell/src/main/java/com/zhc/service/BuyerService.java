package com.zhc.service;

import com.zhc.dto.OrderDTO;

/**
* @author zhangchi02
* @date 2019年4月4日
*/
public interface BuyerService {
	//查询一个订单
	OrderDTO findOrderOne(String openid,String orderId);
	//取消订单
	OrderDTO cancelOrder(String openid,String orderId);
}
