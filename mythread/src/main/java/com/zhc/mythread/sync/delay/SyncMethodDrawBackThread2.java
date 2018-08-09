package com.zhc.mythread.sync.delay;

public class SyncMethodDrawBackThread2 extends Thread{
	private SyncMethodDrawBackMethod method;
	
	public SyncMethodDrawBackThread2(SyncMethodDrawBackMethod method) {
		super();
		this.method = method;
	}
	public void run(){
		SyncMethodDrawBackCommonUtils.beginTime2 = System.currentTimeMillis();
		method.doLongTimeTask();
		SyncMethodDrawBackCommonUtils.endTime2 = System.currentTimeMillis();
	}
}
