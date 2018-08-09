package com.zhc.mythread.threadname;

public class ThreadName extends Thread {
	public ThreadName() {
		System.out.println("构造方法Thread.currentThread().getName(): " + Thread.currentThread().getName());
		System.out.println("构造方法this.getName(): " + this.getName());
	}

	public void run() {
		System.out.println("run方法Thread.currentThread().getName(): " + Thread.currentThread().getName());
		System.out.println("run方法this.getName(): " + this.getName());

	}
	
	public static void main(String[] args){
		/*ThreadName tn1 = new ThreadName();
		tn1.setName("tn1");
		tn1.start();*/
		
		ThreadName tn2 = new ThreadName();
		tn2.setName("target");
		Thread t2 = new Thread(tn2);
		t2.setName("tn2");
		t2.start();
		
	}
}
