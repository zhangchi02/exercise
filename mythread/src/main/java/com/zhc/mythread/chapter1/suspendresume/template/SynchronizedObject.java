package com.zhc.mythread.chapter1.suspendresume.template;

public class SynchronizedObject {
	public synchronized void printString() {
		System.out.println("begin");
		if (Thread.currentThread().getName().equals("a")) {
			System.out.println("aœﬂ≥Ã”¿‘∂suspend¡À£°");
			Thread.currentThread().suspend();
		}
		System.out.println("end");
	}
}
