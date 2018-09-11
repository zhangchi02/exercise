package com.zhc.mythread.chapter2.sync.block;

public class TwoSyncBlockThread extends Thread {

	private TwoSyncBlock object;

	public TwoSyncBlockThread(TwoSyncBlock object) {
		super();
		this.object = object;
	}

	public void run() {
		if(Thread.currentThread().getName().equals("A")){
			object.a();;
		}else{
			object.b();;
		}
	}

	public static void main(String[] args) {

		TwoSyncBlock sb = new TwoSyncBlock();
		TwoSyncBlockThread thread1 = new TwoSyncBlockThread(sb);
		thread1.setName("A");
		thread1.start();
		TwoSyncBlockThread thread2 = new TwoSyncBlockThread(sb);
		thread2.setName("B");
		thread2.start();
	}

}
