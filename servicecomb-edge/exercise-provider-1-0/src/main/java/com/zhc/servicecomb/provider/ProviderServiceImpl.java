package com.zhc.servicecomb.provider;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhc.servicecomb.demo.ResultPOJO;

@RestSchema(schemaId = "provider-v1")
@RequestMapping(path = "/exercise-provider/v1")
public class ProviderServiceImpl {
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ResultPOJO add(int x, int y) {
		return ResultPOJO.create(x + y);
	}
}
