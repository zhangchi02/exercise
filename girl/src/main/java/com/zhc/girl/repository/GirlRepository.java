package com.zhc.girl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhc.girl.domain.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

	//通过年龄查询
	public List<Girl> findByAge(Integer age);
}
