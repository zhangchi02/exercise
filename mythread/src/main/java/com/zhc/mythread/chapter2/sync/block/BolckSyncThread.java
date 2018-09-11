package com.zhc.mythread.chapter2.sync.block;

public class BolckSyncThread extends Thread {

	private BlockSync object;

	public BolckSyncThread(BlockSync object) {
		super();
		this.object = object;
	}

	public void run() {
		super.run();
		object.serviceMethodA();
	}
}
