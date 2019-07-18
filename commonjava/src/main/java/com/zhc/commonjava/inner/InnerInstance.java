package com.zhc.commonjava.inner;

public class InnerInstance {

	private String key = "123456";
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private static class Inner {
		private static InnerInstance instance = new InnerInstance();
	}

	public static void main(String[] args) {
		InnerInstance instance1 = InnerInstance.getInstance();
		instance1.setKey("abcdef");
		InnerInstance instance2 = InnerInstance.getInstance();

		System.out.println(instance1);
		System.out.println(instance2);

		System.out.println(instance1 == instance2);
	}

	private static InnerInstance getInstance() {
		return Inner.instance;
	}

}
