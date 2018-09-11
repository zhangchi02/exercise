package com.zhc.mythread.chapter2.sync.noextend;

public class SyncNoExtend extends Thread {
	private SyncNoExtendSub sub;
	
	public SyncNoExtend(SyncNoExtendSub sub) {
		super();
		this.sub = sub;
	}

	public void run() {
		sub.serviceMethod();
	}

	public static void main(String[] args) {
		SyncNoExtendSub sub = new SyncNoExtendSub();
		SyncNoExtend thread1 = new SyncNoExtend(sub);
		SyncNoExtend thread2 = new SyncNoExtend(sub);
		thread1.setName("A");
		thread1.start();
		thread2.setName("B");
		thread2.start();
	}
}
