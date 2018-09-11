package com.zhc.mythread.chapter2.sync.block;

public class SyncBlockThread extends Thread {

	private SyncBlock object;

	public SyncBlockThread(SyncBlock object) {
		super();
		this.object = object;
	}

	public void run() {
		object.doLongTimeTask();
	}

	public static void main(String[] args) {

		SyncBlock sb = new SyncBlock();
		SyncBlockThread thread1 = new SyncBlockThread(sb);
		thread1.start();
		SyncBlockThread thread2 = new SyncBlockThread(sb);
		thread2.start();
	}

}
