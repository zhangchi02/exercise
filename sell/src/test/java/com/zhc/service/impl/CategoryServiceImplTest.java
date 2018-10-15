/**  
 * Project Name:sell  
 * File Name:CategoryServiceImplTest.java  
 * Package Name:com.zhc.service.impl  
 * Date:2018年1月6日下午4:59:01  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.dataobject.ProductCategory;

import junit.framework.Assert;

/**  
 * ClassName:CategoryServiceImplTest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年1月6日 下午4:59:01 <br/>  
 * @author   l00228291  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Test
	public void testFindOne() {
		ProductCategory productCategory = categoryService.findOne(1);
		Assert.assertEquals(new Integer(4), productCategory.getCategoryType());
	}

	@Test
	public void testFindAll() {
		List<ProductCategory> productCategoryList = categoryService.findAll();
		Assert.assertNotSame(0, productCategoryList.size());
	}

	@Test
	public void testFindByCategoryTypeIn() {
		List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(2,3,4));
		Assert.assertNotSame(0, productCategoryList.size());
	}

	@Test
	@Transactional
	public void testSave() {
		ProductCategory productCategory = new ProductCategory("经典榜",5);
		ProductCategory result= categoryService.save(productCategory);
		Assert.assertNotNull(result);
	}

}
  
