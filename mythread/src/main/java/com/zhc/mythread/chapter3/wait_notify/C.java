package com.zhc.mythread.chapter3.wait_notify;

public class C {
	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					System.out.println("c wait begin:" + Thread.currentThread().getName());
					lock.wait();
					System.out.println("c wait   end:" + Thread.currentThread().getName());
				}
				System.out.println("get value: " + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
