package com.zhc.mythread.sync;

public class ThrowExceptionNoLock extends Thread{

	synchronized public void testMethod(){
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("ThreadName = " + Thread.currentThread().getName() + " run beginTime = "+ System.currentTimeMillis());
			int i = 1;
			while( i == 1){
				if((""+Math.random()).substring(0,8).equals("0.123456")){
					System.out.println("ThreadName = " + Thread.currentThread().getName() + " run exceptionTime = "+ System.currentTimeMillis());
					Integer.parseInt("a");
				}
			}
		}else{
			System.out.println("ThreadName = " + Thread.currentThread().getName() + " run Time = "+ System.currentTimeMillis());
		}
	}
	public void run(){
		ThrowExceptionNoLock ten = new ThrowExceptionNoLock();
		ten.testMethod();
	}
	public static void main(String[] args) {
		try {
			ThrowExceptionNoLock thread1 = new ThrowExceptionNoLock();
			ThrowExceptionNoLock thread2 = new ThrowExceptionNoLock();
			thread1.setName("a");
			thread1.start();
			Thread.sleep(500);
			thread2.setName("b");
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
