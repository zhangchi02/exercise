package com.zhc.mythread.sync.twonostop;

public class Run extends Thread {
	private Service service;

	public Run(Service service) {
		super();
		this.service = service;
	}
public void run(){
	if(Thread.currentThread().getName().equals("A")){
		service.methodA();
	}else{
		service.methodB();
	}
}
	public static void main(String[] args) {
		Service myService = new Service();
		Run threadA = new Run(myService);
		threadA.setName("A");
		threadA.start();
		Run threadB = new Run(myService);
		threadB.setName("B");
		threadB.start();

	}

}
