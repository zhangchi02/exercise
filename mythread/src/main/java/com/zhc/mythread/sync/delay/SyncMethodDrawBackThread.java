package com.zhc.mythread.sync.delay;

public class SyncMethodDrawBackThread extends Thread{
	private SyncMethodDrawBackMethod method;
	
	public SyncMethodDrawBackThread(SyncMethodDrawBackMethod method) {
		super();
		this.method = method;
	}
	public void run(){
		super.run();
		SyncMethodDrawBackCommonUtils.beginTime1 = System.currentTimeMillis();
		method.doLongTimeTask();
		SyncMethodDrawBackCommonUtils.endTime1 = System.currentTimeMillis();
	}
	public static void main(String[] args){
		try{
			SyncMethodDrawBackMethod drawback = new SyncMethodDrawBackMethod();
			SyncMethodDrawBackThread thread1 = new SyncMethodDrawBackThread(drawback);
			thread1.start();
			SyncMethodDrawBackThread2 thread2 = new SyncMethodDrawBackThread2(drawback);
			thread2.start();
			
			Thread.sleep(10000);
			long beginTime = SyncMethodDrawBackCommonUtils.beginTime1;
			if(SyncMethodDrawBackCommonUtils.beginTime2 < SyncMethodDrawBackCommonUtils.beginTime1){
				beginTime = SyncMethodDrawBackCommonUtils.beginTime2;
			}
			long endTime = SyncMethodDrawBackCommonUtils.endTime1;
			if(SyncMethodDrawBackCommonUtils.endTime1 < SyncMethodDrawBackCommonUtils.endTime2){
				beginTime = SyncMethodDrawBackCommonUtils.endTime2;
			}
			System.out.println("ºÄÊ±: "+(endTime-beginTime)/1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
