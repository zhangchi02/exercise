package com.zhc.servicecomb.edge;

import java.util.Map;

import org.apache.servicecomb.edge.core.AbstractEdgeDispatcher;
import org.apache.servicecomb.edge.core.CompatiblePathVersionMapper;
import org.apache.servicecomb.edge.core.EdgeInvocation;

import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.CookieHandler;

public class EdgeDispatcher extends AbstractEdgeDispatcher {
	private CompatiblePathVersionMapper versionMapper = new CompatiblePathVersionMapper();

	public int getOrder() {
		// TODO Auto-generated method stub
		return 10;
	}

	public void init(Router router) {
		// TODO Auto-generated method stub
		String regex = "/api/([^\\\\/]+)/([^\\\\/]+)/(.*)";
		router.routeWithRegex(regex).handler(CookieHandler.create());
		router.routeWithRegex(regex).handler(createBodyHandler());
		router.routeWithRegex(regex).failureHandler(this::onFailure).handler(this::onRequest);
	}

	protected void onRequest(RoutingContext context) {
		Map<String, String> pathParams = context.pathParams();
		String microserviceName = pathParams.get("param0");
		String pathVersion = pathParams.get("param1");
		String path = context.request().path().substring(4);
		
		System.out.println("microserviceName: "+microserviceName);
		System.out.println("pathVersion: "+pathVersion);
		System.out.println("path: "+path);

		EdgeInvocation edgeInvocation = new EdgeInvocation();
		//edgeInvocation.setVersionRule(versionMapper.getOrCreate(pathVersion).getVersionRule());
		edgeInvocation.setVersionRule("0.0.0+");
		edgeInvocation.init(microserviceName, context, path, httpServerFilters);
		edgeInvocation.edgeInvoke();
	}
}
