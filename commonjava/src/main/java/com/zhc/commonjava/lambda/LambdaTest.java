package com.zhc.commonjava.lambda;

//import java.awt.Button;
//import java.awt.Frame;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhangchi02
 * @date 2019年3月20日
 */
public class LambdaTest {

	public static void main(String[] args) {
		// // 旧方法:
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// System.out.println("Hello from thread");
		// }
		// }).start();
		//
		// // 新方法:
		// new Thread(() -> System.out.println("Hello from thread")).start();

		// Button button = new Button("lambda");
		// // Old way:
		// button.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("The button was clicked using old fashion code!");
		// }
		// });
		//
		// // New way:
		// button.addActionListener((e) -> {
		// System.out.println("The button was clicked. From Lambda expressions
		// !");
		// });

		// //Old way:
		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		// for(Integer n: list) {
		// System.out.println(n);
		// }
		//
		// //New way:
		// list.forEach(n -> System.out.println(n));
		//
		//
		// //or we can use :: double colon operator in Java 8
		// list.forEach(System.out::println);

//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//
//		System.out.println("Print all numbers:");
//		evaluate(list, (x) -> true);
//
//		System.out.println("Print no numbers:");
//		evaluate(list, (y) -> false);
//
//		System.out.println("Print even numbers:");
//		evaluate(list, (z) -> z % 2 == 0);
//
//		System.out.println("Print odd numbers:");
//		evaluate(list, (a) -> a % 2 == 1);
//
//		System.out.println("Print numbers greater than 5:");
//		evaluate(list, (b) -> b > 5);

		//Old way:
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		for(Integer n : list) {
		    int x = n * n;
		    System.out.println(x);
		}

		//New way:
		list.stream().map((x) -> x*x).forEach(System.out::println);
	}

	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(n + " ");
			}
		}
	}

}
