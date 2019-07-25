package com.zhc.commonjava.compare;

import java.util.Comparator;

public class CompareTest {

	public static void main(String[] args) {
		Comparator comparator = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return 0;
			}
		};
		int value = comparator.compare("nihao", "world");
		System.out.println(value);
	}

}
