package com.zhc.mythread.chapter2.sync.noextend;

public class SyncNoExtendSub extends SyncNoExtendMain {

	synchronized public void serviceMethod() {
		try {
			System.out.println("int sub 下一步 sleep begin threadName =  " + Thread.currentThread().getName() + " time = "
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("ini sub 下一步 sleep   end threadName = " + Thread.currentThread().getName() + " time = "
					+ System.currentTimeMillis());
			super.serviceMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
