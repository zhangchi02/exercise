package com.zhc.commonjava.returntest;

public class ReturnTest {

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			if (i == 4) {
				return;
			}
			System.out.println("i = " + i);
			for (int j = 0; j < 5; j++) {
				System.out.println(" j = " + j);
			}
		}
	}

}
