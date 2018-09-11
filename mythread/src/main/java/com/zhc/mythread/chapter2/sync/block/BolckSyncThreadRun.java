package com.zhc.mythread.chapter2.sync.block;

public class BolckSyncThreadRun extends Thread {

	private BlockSync object;

	public BolckSyncThreadRun(BlockSync object) {
		super();
		this.object = object;
	}

	public void run() {
		super.run();
		object.serviceMethodB();
	}
	
	public static void main(String[] args){
		BlockSync service = new BlockSync();
		BolckSyncThread threadA = new BolckSyncThread(service);
		threadA.setName("A");
		threadA.start();
		BolckSyncThreadRun threadB = new BolckSyncThreadRun(service);
		threadB.setName("B");
		threadB.start();
		
	}
}
