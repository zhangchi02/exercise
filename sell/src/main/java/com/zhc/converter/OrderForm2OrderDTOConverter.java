package com.zhc.converter;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhc.dataobject.OrderDetail;
import com.zhc.dto.OrderDTO;
import com.zhc.enums.ResultEnum;
import com.zhc.exception.SellException;
import com.zhc.form.OrderForm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangchi02
 * @date 2018年10月16日
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

	public static OrderDTO convert(OrderForm orderForm) {
		Gson gson = new Gson();
		OrderDTO orderDTO = new OrderDTO();

		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerPhone(orderForm.getPhone());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());
		List<OrderDetail> orderDetailList = new ArrayList<>();
		try {
			orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
			}.getType());
		} catch (Exception e) {
			log.error("【对象转换】错误,string={}", orderForm.getItems());
			throw new SellException(ResultEnum.PARAM_ERROR);
		} 

		orderDTO.setOrderDetailList(orderDetailList);
		return orderDTO;
	}
}
