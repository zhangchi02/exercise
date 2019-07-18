package com.zhc.commonjava.continuetest;

public class ContinueTest {

	public static void main(String[] args) {
		ContinueTest.test2();
	}
	
	public static void test1(){
		for (int i = 0; i < 50; i++) {
			if (i < 5) {
				continue;
			}
			System.out.println("i = " + i);
			for (int j = 0; j < 5; j++) {
				System.out.println(" j = " + j);
			}
		}
	}
	
	public static void test2(){
		for(int x=1; x<=10; x++) {
			if(x%3 == 0) {
				continue;
			}
			System.out.println("Java");
		}
	}

}
