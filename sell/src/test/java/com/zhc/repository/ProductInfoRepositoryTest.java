/**  
 * Project Name:sell  
 * File Name:ProductInfoRepositoryTest.java  
 * Package Name:com.zhc.repository  
 * Date:2018年1月6日下午5:53:57  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.dataobject.ProductInfo;

/**  
 * ClassName:ProductInfoRepositoryTest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年1月6日 下午5:53:57 <br/>  
 * @author   l00228291  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

	@Autowired
	private ProductInfoRepository repository;
	
	@Test
	@Transactional
	public void testSave(){
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("123458");
		productInfo.setProductName("大力丸");
		productInfo.setProductPrice(new BigDecimal(32.0));
		productInfo.setProductStock(100);
		productInfo.setProductDescription("很好吃的丸");
		productInfo.setProductIcon("http://xxxx.jpg");
		productInfo.setProductStatus(0);
		productInfo.setCategoryType(4);
		
		ProductInfo result = repository.save(productInfo);
		Assert.assertNotNull(result);
	}
	@Test
	public void testFindByProductStatus() {
		List<ProductInfo> productInfoList = repository.findByProductStatus(0);
		Assert.assertNotEquals(0, productInfoList.size());
	}

}
  
