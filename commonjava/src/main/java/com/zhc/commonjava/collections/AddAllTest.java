package com.zhc.commonjava.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddAllTest {

	public static void main(String[] args) {
		addAllTest();
	}
	public static void addAllTest() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] array = new String[3];
		array[0] = "d";
		array[1] = "e";
		array[2] = "f";
		
		list.addAll(Arrays.asList(array));
		
		for(String str:list) {
			System.out.println(str);
		}
	}
}
