package com.zhc.commonjava.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new MyTask(), 3000);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.cancel();
	}

}
class MyTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("我的任务");
	}
	
}