/**  
 * Project Name:sell  
 * File Name:ProductService.java  
 * Package Name:com.zhc.service  
 * Date:2018年1月6日下午6:07:26  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zhc.dataobject.ProductInfo;
import com.zhc.dto.CartDTO;

/**  
 * @author   zhangchi02  
 * @date   
 */
public interface ProductService {

	ProductInfo findOne(String productInfo);
	
	/**
	 * findUpAll:查询所有在架商品. 
	 * @return  
	 */
	List<ProductInfo> findUpAll();
	
	Page<ProductInfo> findAll(Pageable pageable);
	
	ProductInfo save(ProductInfo productInfo);
	
	//加库存
	void increaseStock(List<CartDTO> cartDTOList);
	
	//减库存
	void decreaseStock(List<CartDTO> cartDTOList);
}
  
