package com.zhc.mythread.chapter1.daemon;

public class DaemonTest extends Thread{
	private int i = 0;
	public void run(){
		try{
			while(true){
				i++;
				System.out.println("i = "+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			DaemonTest thread = new DaemonTest();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("���뿪thread����Ҳ���ٴ�ӡ�ˣ�Ҳ����ֹͣ�ˣ�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
