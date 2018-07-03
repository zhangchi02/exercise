package com.zhc.servicecomb.consumer;

import org.apache.servicecomb.foundation.common.net.URIEndpointObject;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.apache.servicecomb.serviceregistry.RegistryUtils;
import org.apache.servicecomb.serviceregistry.api.registry.Microservice;
import org.apache.servicecomb.serviceregistry.api.registry.MicroserviceInstance;
import org.apache.servicecomb.serviceregistry.definition.DefinitionConst;
import org.springframework.web.client.RestTemplate;

import com.zhc.servicecomb.demo.ResultPOJO;

public class Consumer {
	RestTemplate template = RestTemplateBuilder.create();
	String edgePrefix;

	public void run(String prefix){
		perpareEdge(prefix);
		invoke("/v1/add",1,2);
	}
	private URIEndpointObject perpareEdge(String prefix) {
		Microservice microservice = RegistryUtils.getMicroservice();
		MicroserviceInstance microserviceInstance = (MicroserviceInstance) RegistryUtils.getServiceRegistry()
				.getAppManager()
				.getOrCreateMicroserviceVersionRule(microservice.getAppId(), "exercise-edge",
						DefinitionConst.VERSION_RULE_ALL)
				.getVersionedCache().mapData().values().stream().findFirst().get();
		URIEndpointObject edgeAddress = new URIEndpointObject(microserviceInstance.getEndpoints().get(0));
		edgePrefix = String.format("http://%s:%d/%s/exercise-provider", edgeAddress.getHostOrIp(), edgeAddress.getPort(),
				prefix);
		return edgeAddress;
	}
	
	protected void invoke(String appendUrl,int x,int y){
		String url = edgePrefix + appendUrl + String.format("?x=%d&y=%d",x,y);
		System.out.println(url);
		ResultPOJO result = template.getForObject(url,ResultPOJO.class);
		System.out.println(result);
	}
}
