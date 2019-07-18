/**  
 * Project Name:sell  
 * File Name:ProductInfo.java  
 * Package Name:com.zhc.dataobject  
 * Date:2018年1月6日下午5:32:13  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.zhc.dataobject;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**  
 * Date:     2018年1月6日 下午5:32:13 <br/>  
 * @author   zhangchi02  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Entity
@Data
public class ProductInfo {

	@Id
	private String productId;
	
	/** 名字. **/
	private String productName;
	
	/** 单价. **/
	private BigDecimal productPrice;
	
	/** 库存. **/
	private Integer productStock;
	
	/** 描述. **/
	private String productDescription;
	
	/** 小图. **/
	private String productIcon;
	
	/** 商品状态，0正常1下架. **/
	private Integer productStatus;
	
	/** 类目编号. **/
	private Integer categoryType;
}
  
