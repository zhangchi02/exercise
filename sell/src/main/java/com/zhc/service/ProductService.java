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

/**  
 * ClassName:ProductService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年1月6日 下午6:07:26 <br/>  
 * @author   l00228291  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
public interface ProductService {

	ProductInfo findOne(String productInfo);
	
	/**
	 * 
	 * findUpAll:查询所有在架商品. <br/>  
	 *  
	 * @author l00228291  
	 * @return  
	 * @since JDK 1.6
	 */
	List<ProductInfo> findUpAll();
	
	Page<ProductInfo> findAll(Pageable pageable);
	
	ProductInfo save(ProductInfo productInfo);
	
}
  
