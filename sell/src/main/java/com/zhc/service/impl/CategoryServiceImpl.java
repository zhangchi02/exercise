/**  
 * Project Name:sell  
 * File Name:CategoryServiceImpl.java  
 * Package Name:com.zhc.service.impl  
 * Date:2018年1月6日下午4:53:39  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.zhc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhc.dataobject.ProductCategory;
import com.zhc.repository.ProductCategoryRepository;
import com.zhc.service.CategoryService;

/**
 * ClassName:CategoryServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年1月6日 下午4:53:39 <br/>
 * 
 * @author l00228291
 * @version
 * @since JDK 1.6
 * @see
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository repository;

	@Override
	public ProductCategory findOne(Integer categoryId) {
		return repository.findOne(categoryId);
	}

	@Override
	public List<ProductCategory> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return repository.findByCategoryTypeIn(categoryTypeList);
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		return repository.save(productCategory);
	}

}
