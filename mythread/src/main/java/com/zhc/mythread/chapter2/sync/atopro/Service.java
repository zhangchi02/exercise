package com.zhc.mythread.chapter2.sync.atopro;

public class Service {
	private boolean isContinuRun = true;

	public void runMethod() {
		String anyString = new String();
		while (isContinuRun == true) {
			synchronized(anyString){
				
			}
		}
		System.out.println("ͣ�����ˣ�");
	}

	public void stopMethod() {
		isContinuRun = false;
	}
}
