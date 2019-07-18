package com.zhc.commonjava.lambda;

/**
 * @author zhangchi02
 * @date 2019年3月20日
 */
public class WorkerInterfaceTest {

	public static void execute(WorkerInterface worker) {
		worker.doSomeWork();
	}

	public static void main(String[] args) {

		// invoke doSomeWork using Annonymous class
		execute(new WorkerInterface() {
			@Override
			public void doSomeWork() {
				System.out.println("Worker invoked using Anonymous class");
			}
		});

		// invoke doSomeWork using Lambda expression
		execute(() -> System.out.println("Worker invoked using Lambda expression"));
	}
}
