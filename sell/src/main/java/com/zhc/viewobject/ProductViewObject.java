package com.zhc.viewobject;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品（包含类目）
* @author zhangchi02
* @date 2018年9月30日
*/
@Data
public class ProductViewObject {

	@JsonProperty("name")
	private String categoryName;
	
	@JsonProperty("type")
	private Integer categoryType;
	
	@JsonProperty("foods")
	private List<ProductInfoViewObject> productInfoVOList;
}
