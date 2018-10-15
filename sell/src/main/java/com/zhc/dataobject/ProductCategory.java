package com.zhc.dataobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.Getter;

/**
 * 类目
 * @author zhangchi02
 *
 */
//@Table(name="s_product_category")
@Entity
@DynamicUpdate 
//@Getter
@Data
public class ProductCategory {

	/** 类目Id. */
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	/** 类目名字. */
	private String categoryName;
	
	/** 类目编号. */
	private Integer categoryType;

	/*public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}*/
	
    
	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + "]";
	}

	public ProductCategory(String categoryName, Integer categoryType) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}

	public ProductCategory() {
	}

}
