package com.zhc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zhc.dataobject.OrderMaster;

/**
* @author zhangchi02
* @date 2018年9月30日
*/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String>{

	Page<OrderMaster> findByBuyerOpenid(String buyerOpenid,Pageable pageable);
}
