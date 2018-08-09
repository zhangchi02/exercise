package com.zhc.mythread.threadname;

public class ThreadName extends Thread {
	public ThreadName() {
		System.out.println("���췽��Thread.currentThread().getName(): " + Thread.currentThread().getName());
		System.out.println("���췽��this.getName(): " + this.getName());
	}

	public void run() {
		System.out.println("run����Thread.currentThread().getName(): " + Thread.currentThread().getName());
		System.out.println("run����this.getName(): " + this.getName());

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
