package com.zhc.mythread.interrupt;

public class ReturnInterrupt extends Thread{

	public void run(){
		while(true){
			if(this.isInterrupted()){
				System.out.println("ֹͣ�ˣ�����");
				return;
			}
			System.out.println("timer:"+System.currentTimeMillis());
		}
	}
	public static void main(String[] args) {
		try {
			ReturnInterrupt thread = new ReturnInterrupt();
			thread.start();
			Thread.sleep(500);
			thread.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
