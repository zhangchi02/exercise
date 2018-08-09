package com.zhc.commonjava.continuetest;

public class ContinueTest {

	public static void main(String[] args) {
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

}
