package com.zhc.mythread.chapter3.wait_notify;

public class P {
	private String lock;

	public P(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals("")) {
					System.out.println("p wait begin:" + Thread.currentThread().getName());
					lock.wait();
					System.out.println("p wait   end:" + Thread.currentThread().getName());
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("set value: " + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
