/**  
 * Project Name:sell  
 * File Name:BuyerProductController.java  
 * Package Name:com.zhc.controller  
 * Date:2018年1月6日下午6:47:53  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/

package com.zhc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhc.dataobject.ProductCategory;
import com.zhc.dataobject.ProductInfo;
import com.zhc.service.CategoryService;
import com.zhc.service.ProductService;
import com.zhc.utils.ResultVOUtil;
import com.zhc.viewobject.ProductInfoViewObject;
import com.zhc.viewobject.ProductViewObject;
import com.zhc.viewobject.ResultViewObject;

/**
 * @author zhangchi02
 * @date
 */
@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public ResultViewObject list() {
		// 1.查询所有的上架商品
		List<ProductInfo> productInfoList = productService.findUpAll();

		// 2.查询类目（一次性查询）
		// List<Integer> categoryTypeList = new ArrayList<>();
//      传统方法
//		for (ProductInfo productInfo : productInfoList) {
//			categoryTypeList.add(productInfo.getCategoryType());
//		}

		// 精简方法（Java8, lambda）
		List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType())
				.collect(Collectors.toList());
		List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

		// 3.数据拼装
		List<ProductViewObject> productVOList = new ArrayList<>();
		for (ProductCategory productCategory : productCategoryList) {
			ProductViewObject productVO = new ProductViewObject();
			productVO.setCategoryType(productCategory.getCategoryType());
			productVO.setCategoryName(productCategory.getCategoryName());

			List<ProductInfoViewObject> productInfoVOList = new ArrayList<>();
			for (ProductInfo productInfo : productInfoList) {
				if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
					ProductInfoViewObject productInfoVO = new ProductInfoViewObject();
					BeanUtils.copyProperties(productInfo, productInfoVO);
					productInfoVOList.add(productInfoVO);
				}
			}
			productVO.setProductInfoVOList(productInfoVOList);
			productVOList.add(productVO);
		}

		return ResultVOUtil.success(productVOList);
	}
}
