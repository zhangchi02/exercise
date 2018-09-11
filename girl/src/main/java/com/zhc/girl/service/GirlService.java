package com.zhc.girl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhc.girl.domain.Girl;
import com.zhc.girl.enums.ResultEnum;
import com.zhc.girl.exception.GirlException;
import com.zhc.girl.repository.GirlRepository;

@Service
public class GirlService {

	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo(){
		Girl girlA = new Girl();
		girlA.setCupSize("A");
		girlA.setAge(18);
		
		girlRepository.save(girlA);
		
		Girl girlB = new Girl();
		girlB.setCupSize("A");
		girlB.setAge(18);
		
		girlRepository.save(girlB);
	}
	
	public void getAge(Integer id) throws Exception{
		Girl girl = girlRepository.findOne(id);
		Integer age = girl.getAge();
		if(age<10){
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age>10 &&age<16){
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
	
	public Girl findOne(Integer id){
		return girlRepository.findOne(id);
	}
}
