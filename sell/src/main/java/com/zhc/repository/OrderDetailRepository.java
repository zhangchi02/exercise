package com.zhc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhc.dataobject.OrderDetail;

/**
* @author zhangchi02
* @date 2018年9月30日
*/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{

	List<OrderDetail> findByOrderId(String orderId);
}
