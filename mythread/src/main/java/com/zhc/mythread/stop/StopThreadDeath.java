package com.zhc.mythread.stop;

public class StopThreadDeath extends Thread {
	public void run() {
		try {
			this.stop();
		} catch (ThreadDeath e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		StopThreadDeath st = new StopThreadDeath();
		st.start();
	}
}