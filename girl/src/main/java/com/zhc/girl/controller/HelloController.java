package com.zhc.girl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhc.girl.properties.GirlProperties;

@RestController
// @Controller
// @ResponseBody
@RequestMapping("/hello")
public class HelloController {

	/*
	 * @Value("${cupSize}") private String cupSize;
	 * 
	 * @Value("${age}") private Integer age;
	 * 
	 * @Value("${content}") private String content;
	 */

	@Autowired
	private GirlProperties girlProperties;

	@RequestMapping(value = { "/say/{id}", "{id}/speak" }, method = RequestMethod.GET)
	public String say(@PathVariable("id") Integer id) {
		return "id:" + id;
		// return girlProperties.getCupSize();
	}

	@RequestMapping(value = { "/sing" }, method = RequestMethod.GET)
	public String sing(@RequestParam(value = "song", required = false, defaultValue = "ABC") String mySong) {
		return "sing " + mySong;
		// return girlProperties.getCupSize();
	}
	
	@GetMapping(value="/cry")
	public String cry(@RequestParam(value = "num", required = false, defaultValue = "1")Integer myNum){
		return "has cried "+ myNum +" hours.";
	}
}
