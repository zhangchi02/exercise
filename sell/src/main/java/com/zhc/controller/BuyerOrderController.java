package com.zhc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhc.converter.OrderForm2OrderDTOConverter;
import com.zhc.dto.OrderDTO;
import com.zhc.enums.ResultEnum;
import com.zhc.exception.SellException;
import com.zhc.form.OrderForm;
import com.zhc.service.OrderService;
import com.zhc.utils.ResultVOUtil;
import com.zhc.viewobject.ResultViewObject;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangchi02
 * @date 2018年10月16日
 */
@RestController
@RequestMapping("buyer/order")
@Slf4j
public class BuyerOrderController {

	@Autowired
	private OrderService orderService;

	// 创建订单
	@PostMapping("/create")
	public ResultViewObject<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("【创建订单】参数不正确,orderForm={}", orderForm);
			throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		}
		OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("【创建订单】购物车不能为空");
			throw new SellException(ResultEnum.CART_EMPTY);
		}
		OrderDTO createResult = orderService.create(orderDTO);

		Map<String, String> map = new HashMap<>();
		map.put("orderId", createResult.getOrderId());
		return ResultVOUtil.success(map);
	}

	// 订单列表
	@GetMapping("/list")
	public ResultViewObject<List<OrderDTO>> list(@RequestParam("openid") String openid,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		if (StringUtils.isEmpty(openid)) {
			log.error("【查询订单列表】openid为空");
			throw new SellException(ResultEnum.PARAM_ERROR);
		}

		PageRequest request = new PageRequest(page,size);
		Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
		return ResultVOUtil.success(orderDTOPage.getContent());
	}

	// 订单详情

	// 取消订单

}
