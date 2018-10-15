package com.zhc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhc.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
