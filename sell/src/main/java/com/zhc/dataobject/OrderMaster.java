package com.zhc.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import com.zhc.enums.OrderStatusEnum;
import com.zhc.enums.PayStatusEnum;

import lombok.Data;

/**
* @author zhangchi02
* @date 2018年9月30日
*/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

	/** 订单id. */
	@Id
	private String orderId;
	
	/** 买家名字. */
	private String buyerName;
	
	/** 买家手机号. */
	private String buyerPhone;
	
	/** 买家地址. */
	private String buyerAddress;
	
	/** 买家微信Openid. */
	private String buyerOpenid;
	
	/** 订单总金额. */
	private BigDecimal orderAmount;
	
	/** 订单状态，默认为0新下单. */
	private Integer orderStatus = OrderStatusEnum.NEW.getCode();
	
	/** 支付状态，默认为0未支付. */
	private Integer payStatus = PayStatusEnum.WAIT.getCode();
	
	/** 创建时间. */
	/*private Date createTime;*/
	
	/** 更新时间. */
	/*private Date updateTime;*/
	
	//对应数据库时忽略该属性
	/*@Transient
	private List<OrderDetail> orderDetailList;*/
}
