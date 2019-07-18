/**  
 * Project Name:sell  
 * File Name:ProductServiceImplTest.java  
 * Package Name:com.zhc.service.impl  
 * Date:2018年1月6日下午6:24:14  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.dataobject.ProductInfo;
import com.zhc.enums.ProductStatus;
import com.zhc.service.ProductService;

import junit.framework.Assert;

/**  
 * Date:     2018年1月6日 下午6:24:14 <br/>
 * @author   zhangchi02
 * @version    
 * @since    JDK 1.8
 * @see        
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

	@Autowired
	private ProductServiceImpl productService;
	
	@Test
	public void testFindOne() {
		ProductInfo productInfo = productService.findOne("123456");
		Assert.assertEquals("123456", productInfo.getProductId());
	}

	@Test
	public void testFindUpAll() {
		List<ProductInfo> productInfoList = productService.findUpAll();
		Assert.assertNotSame(0, productInfoList.size());
	}

	@Test
	public void testFindAll() {
		PageRequest pageRequest = new PageRequest(0,2);
		Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
		//System.out.println(productInfoPage.getTotalElements());
		Assert.assertNotSame(0, productInfoPage.getTotalElements());
	}

	@Test
	@Transactional
	public void testSave() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("123459");
		productInfo.setProductName("麻辣烫");
		productInfo.setProductPrice(new BigDecimal(52));
		productInfo.setProductStock(100);
		productInfo.setProductDescription("很好吃的麻辣烫");
		productInfo.setProductIcon("http://xxxx.jpg");
		productInfo.setProductStatus(ProductStatus.DOWN.getCode());
		productInfo.setCategoryType(3);
		
		ProductInfo result = productService.save(productInfo);
		Assert.assertNotNull(result);
	}

}
  
