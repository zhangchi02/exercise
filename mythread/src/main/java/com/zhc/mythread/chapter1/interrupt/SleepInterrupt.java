package com.zhc.mythread.chapter1.interrupt;

public class SleepInterrupt extends Thread{
	public void run(){
		super.run();
		try{
			System.out.println("run begin!");
			Thread.sleep(2000000);
			System.out.println("run end!");
		}catch(InterruptedException e){
			System.out.println("在沉睡中被停止！进入catch！" + this.interrupted());
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try {
			SleepInterrupt si = new SleepInterrupt();
			si.start();
			Thread.sleep(200);
			si.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		
	}

}
