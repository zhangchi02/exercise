package com.zhc.servicecomb.demo;

import org.apache.servicecomb.serviceregistry.RegistryUtils;

public class ResultPOJO {
	private int result;
	private String serviceId;
	private String instanceId;
	private String version;
	
	public static ResultPOJO create(int value) {
		ResultPOJO po = new ResultPOJO();
		po.setResult(value);
		po.setInstanceId(RegistryUtils.getMicroserviceInstance().getInstanceId());
		po.setVersion(RegistryUtils.getMicroservice().getServiceId());
		po.setVersion(RegistryUtils.getMicroservice().getVersion());
		return po;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ResultPOJO [result=" + result + ", serviceId=" + serviceId + ", instanceId=" + instanceId + ", version="
				+ version + "]";
	}
}
