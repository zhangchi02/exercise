package com.zhc.servicecomb.edge.handler;

import javax.ws.rs.core.Response.Status;

import org.apache.servicecomb.core.Handler;
import org.apache.servicecomb.core.Invocation;
import org.apache.servicecomb.provider.pojo.Invoker;
import org.apache.servicecomb.swagger.invocation.AsyncResponse;
import org.apache.servicecomb.swagger.invocation.exception.InvocationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthHandler implements Handler {
	private static Logger LOGGER = LoggerFactory.getLogger(AuthHandler.class);

	private Auth auth;

	public AuthHandler() {
		auth = Invoker.createProxy("exercise-auth", "auth", Auth.class);
	}

	@Override
	public void handle(Invocation invocation, AsyncResponse asyncResp) throws Exception {
		if (!auth.auth("")) {
			asyncResp.consumerFail(new InvocationException(Status.UNAUTHORIZED, "auth failed"));
			return;
		}
		LOGGER.debug("auth success");
		invocation.next(asyncResp);
	}
}
