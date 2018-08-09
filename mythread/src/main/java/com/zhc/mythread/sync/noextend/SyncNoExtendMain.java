package com.zhc.mythread.sync.noextend;

public class SyncNoExtendMain {

	synchronized public void serviceMethod() {
		try {
			System.out.println("int main 下一步 sleep begin threadName =  " + Thread.currentThread().getName() + " time = "
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("ini main 下一步 sleep   end threadName = " + Thread.currentThread().getName() + " time = "
					+ System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
