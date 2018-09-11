package com.zhc.girl.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhc.girl.aspect.HttpAspect;
import com.zhc.girl.domain.Girl;
import com.zhc.girl.domain.Result;
import com.zhc.girl.repository.GirlRepository;
import com.zhc.girl.service.GirlService;
import com.zhc.girl.utils.ResultUtil;

@RestController
public class GirlController {
	
	private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

	@Autowired
	private GirlRepository girlRepository;

	@Autowired
	private GirlService girlService;

	/**
	 * 查询所有女生
	 * 
	 * @return
	 */
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		logger.info("girlList method");
		return girlRepository.findAll();
	}

	/**
	 * 添加一个女生
	 * 
	 * @return
	 */
	@PostMapping(value = "/girls")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		return ResultUtil.success(girlRepository.save(girl));
	}

	/**
	 * 查询一个女生
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping(value = "/girls/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findOne(id);
	}

	/**
	 * 更新一个女生
	 * 
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PutMapping(value = "/girls/{id")
	public Girl girlUpdate(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Girl girl = new Girl();
		girl.setId(id);
		girl.setAge(age);
		girl.setCupSize(cupSize);

		return girlRepository.save(girl);
	}

	/**
	 * 删除一个女生
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}

	/**
	 * 根据年龄查询女生
	 * 
	 * @param age
	 * @return
	 */
	@GetMapping(value = "/girls/age/{age}")
	public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
		return girlRepository.findByAge(age);
	}

	@PostMapping(value = "/girls/two")
	public void girlTwo() {
		girlService.insertTwo();
	}
	
	@GetMapping(value ="/girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception{
		girlService.getAge(id);
	}
}
