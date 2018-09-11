package com.zhc.mythread.chapter1.priority;

public class PriorityExtend extends Thread{
	public void run(){
		System.out.println("PriorityExtend run priority="+this.getPriority());
	}

	public static void main(String[] args) {
		System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		System.out.println("main thread end priority="+Thread.currentThread().getPriority());
		PriorityExtend thread = new PriorityExtend();
		thread.start();
	}

}
