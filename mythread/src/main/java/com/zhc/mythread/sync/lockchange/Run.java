package com.zhc.mythread.sync.lockchange;

public class Run extends Thread {
	private MyService service;

	public Run(MyService service) {
		super();
		this.service = service;
	}

	public void run() {
		service.testMethod();
	}

	public static void main(String[] args){
		MyService myservice = new MyService();
		Run run1 = new Run(myservice);
		run1.setName("run1");
		Run run2 = new Run(myservice);
		run2.setName("run2");
		
		run1.start();
		/*try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		run2.start();
	}
}
