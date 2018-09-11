package com.zhc.mythread.chapter2.sync.statictest.twolock;

public class TwoLockThread extends Thread {
	private TwoLockService myservice;

	public TwoLockThread(TwoLockService myservice) {
		super();
		this.myservice = myservice;
	}

	public void run() {
		if (Thread.currentThread().getName().equals("a")) {
			myservice.printA();
		} else if (Thread.currentThread().getName().equals("b")) {
			myservice.printB();
		} else {
			myservice.printC();
		}
	}

	public static void main(String[] args) {
		TwoLockService service = new TwoLockService();
		TwoLockThread thread1 = new TwoLockThread(service);
		thread1.setName("a");
		thread1.start();
		TwoLockThread thread2 = new TwoLockThread(service);
		thread2.setName("b");
		thread2.start();
		TwoLockThread thread3 = new TwoLockThread(service);
		thread3.setName("c");
		thread3.start();
	}
}
