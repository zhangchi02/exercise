package com.zhc.mythread.sync.innerclass;

import com.zhc.mythread.sync.innerclass.OutClass.InnerClass1;
import com.zhc.mythread.sync.innerclass.OutClass.InnerClass2;

public class Run {

	public static void main(String[] args) {
		final InnerClass1 in1 = new InnerClass1();
		final InnerClass2 in2 = new InnerClass2();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				in1.method1(in2);
			}
		}, "T1");
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				in1.method2();
			}
		}, "T2");
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				in2.method1();
			}
		}, "T3");
		Thread t4 = new Thread(new Runnable() {
			public void run() {
				InnerClass2.method2();
			}
		}, "T4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
