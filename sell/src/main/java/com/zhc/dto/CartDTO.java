package com.zhc.dto;

import lombok.Data;

/**
* @author zhangchi02
* @date 2018年10月15日
*/
@Data
public class CartDTO {

	/** 商品Id. */
	private String productId;
	
	/** 商品数量. */
	private Integer productQuantity;

	public CartDTO(String productId, Integer productQuantity) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
	}
	
	
}
