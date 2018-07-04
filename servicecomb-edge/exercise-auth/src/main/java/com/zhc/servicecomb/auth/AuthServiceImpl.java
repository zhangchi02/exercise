package com.zhc.servicecomb.auth;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "auth")
@RequestMapping(path = "exercise-auth/v1")
public class AuthServiceImpl {
	@PostMapping(path = "/auth")
	public boolean auth(@RequestHeader(name = "info") String info) {
		return true;
	}
}
