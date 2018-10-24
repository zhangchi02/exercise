/**  
 * Project Name:sell  
 * File Name:ProductServiceImpl.java  
 * Package Name:com.zhc.service.impl  
 * Date:2018年1月6日下午6:13:16  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.zhc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.dataobject.ProductInfo;
import com.zhc.dto.CartDTO;
import com.zhc.enums.ProductStatus;
import com.zhc.enums.ResultEnum;
import com.zhc.exception.SellException;
import com.zhc.repository.ProductInfoRepository;
import com.zhc.service.ProductService;

/**
 * ClassName:ProductServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年1月6日 下午6:13:16 <br/>
 * 
 * @author l00228291
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository repository;

	@Override
	public ProductInfo findOne(String productInfo) {

		return repository.findOne(productInfo);
	}

	@Override
	public List<ProductInfo> findUpAll() {

		return repository.findByProductStatus(ProductStatus.UP.getCode());
	}

	@Override
	public Page<ProductInfo> findAll(Pageable pageable) {

		return repository.findAll(pageable);
	}

	@Override
	public ProductInfo save(ProductInfo productInfo) {

		return repository.save(productInfo);
	}

	@Override
	@Transactional
	public void increaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO : cartDTOList) {
			ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}

			Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
			productInfo.setProductStock(result);

			repository.save(productInfo);
		}
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cartDTO : cartDTOList) {
			ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
			if (productInfo == null) {
				throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
			}

			Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
			if (result < 0) {
				throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			productInfo.setProductStock(result);

			repository.save(productInfo);
		}
	}

}
