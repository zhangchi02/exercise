package com.zhc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhc.dataobject.ProductInfo;

/**  
 * @author   zhangchi02  
 * @version    
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

	List<ProductInfo> findByProductStatus(Integer productStatus);
}
  
