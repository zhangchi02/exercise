package com.zhc.mythread.sync.block;

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
