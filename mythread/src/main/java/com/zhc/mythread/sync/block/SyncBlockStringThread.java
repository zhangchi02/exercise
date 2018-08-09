package com.zhc.mythread.sync.block;

public class SyncBlockStringThread extends Thread {

	private SyncBlockString object;

	public SyncBlockStringThread(SyncBlockString object) {
		super();
		this.object = object;
	}

	public void run() {
		if(Thread.currentThread().getName().equals("A")){
			object.setUsernamePassword("a", "aa");;
		}else{
			object.setUsernamePassword("b", "bb");;
		}
	}

	public static void main(String[] args) {

		SyncBlockString sb = new SyncBlockString();
		SyncBlockStringThread thread1 = new SyncBlockStringThread(sb);
		thread1.setName("A");
		thread1.start();
		SyncBlockStringThread thread2 = new SyncBlockStringThread(sb);
		thread2.setName("B");
		thread2.start();
	}

}
