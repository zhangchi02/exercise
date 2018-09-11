package com.zhc.mythread.chapter2.vola.pubstack;

public class VolaProperThread extends Thread {
	//private boolean isRunning = true;
	volatile private boolean isRunning = true;
	public boolean isRunning(){
		return isRunning;
	}
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	public void run(){
		System.out.println("进入run了");
		while(isRunning == true){
			
		}
		System.out.println("线程被停止了！");
	}
	public static void main(String[] args) {
		try {
			VolaProperThread thread = new VolaProperThread();
			thread.start();
			Thread.sleep(1000);
			thread.setRunning(false);
			System.out.println("已经赋值为false");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
