package com.zhc.mythread.chapter2.vola.atosync;

import java.util.concurrent.atomic.AtomicLong;

public class AtoService {
	public static AtomicLong aiRef = new AtomicLong();

	synchronized public void addNum() {
		System.out.println(Thread.currentThread().getName() + "����100֮���ֵ�ǣ�" + aiRef.addAndGet(100));
		aiRef.addAndGet(1);
	}
}
