package com.zhc.commonjava.array;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author zhangchi02
 * @date 2018年10月25日
 */
public class ArraySort {

	public ArrayList<Integer> getArray(Integer num) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			Integer random = new Random().nextInt(10);
			System.out.println("random" + i + ":" + random);
			array.add(random);
		}
		return array;
	}

	public ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
		Integer length = array.size();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				Integer num1 = array.get(i);
				Integer num2 = array.get(j);
				if (num1 < num2) {
					array.set(i, num2);
					array.set(j, num1);
					System.out.println("array" + array.toString());
				}
			}
		}
		return array;
	}

	public ArrayList<Integer> selectedSort(ArrayList<Integer> array) {
		Integer length = array.size();
		for (int i = 0; i < length; i++) {
			Integer min = i;
			for (int j = i; j < length; j++) {
				if (array.get(j) < array.get(min)) {
					min = j;
				}
			}
			Integer num1 = array.get(min);
			Integer num2 = array.get(i);
			array.set(i, num1);
			array.set(min, num2);
		}
		return array;
	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArraySort().getArray(6);
		System.out.println("初始化array:" + array.toString());
		// System.out.println("排序后array:" + new
		// ArraySort().bubbleSort(array).toString());
		System.out.println("排序后array:" + new ArraySort().selectedSort(array).toString());

		System.out.println("PrivilegeTest i=" + new PrivilegeTest().getI());
		System.out.println("PrivilegeTest j=" + new PrivilegeTest().getJ());
	}
}
