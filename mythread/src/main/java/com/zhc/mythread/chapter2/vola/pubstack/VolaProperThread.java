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
		System.out.println("����run��");
		while(isRunning == true){
			
		}
		System.out.println("�̱߳�ֹͣ�ˣ�");
	}
	public static void main(String[] args) {
		try {
			VolaProperThread thread = new VolaProperThread();
			thread.start();
			Thread.sleep(1000);
			thread.setRunning(false);
			System.out.println("�Ѿ���ֵΪfalse");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
