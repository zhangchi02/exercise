package com.zhc.commonjava.number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DoubleTest {

	public static void main(String[] args) {
		binaryConvert();
//		System.out.println(exchange(0.786, 3));
	}

	public static void binaryConvert() {
		Scanner c = new Scanner(System.in);

		double m = 0.0;
		int n = 0;
		do {
			String a = c.nextLine();
			m = Double.parseDouble(a.split(" ")[0]);
			n = Integer.parseInt(a.split(" ")[1]);
		} while (m < 0.0000009 || m > 1 || n < 1 || n > 10);
		System.out.println("m=" + m + " n=" + n);

		int x = 0;
		int y = 0;
		do {
			String b = c.nextLine();
			x = Integer.parseInt(b.split(" ")[0]);
			y = Integer.parseInt(b.split(" ")[1]);
		} while (x != 0 || y != 0);
		System.out.println("x=" + x + " y=" + y);

		if (x == 0 & y == 0) {
			c.close();
		}
		double num = 0.0;
		double value = 0.0;
		for (int i = 1; i < 11; i++) {
			num = Math.floor(m * n);
			m = m * n - num;
			value = value + num / Math.pow(10, i);
			System.out.println("num=" + num + " m=" + m + " value=" + value);
		}

		System.out.println(value);
	}

	public static String exchange(double m, int n) {
		double num = 0.0;
		double value = 0.0;
		DecimalFormat df = new DecimalFormat("0.00000000000000000000");
		String e = df.format(value);

		for (int i = 1; i < 20; i++) {
			num = Math.floor(m * n);
			m = m * n - num;
			value = value + num / Math.pow(10, i);
			e = df.format(value);
		}
		return e;
	}

	public void testBmi() {
		double height = 172.0;
		double weight = 78.0;
		if (height <= 0 || weight <= 0) {
			throw new IllegalArgumentException("Arguments must be above 0");
		}
		double heightInMeter = height / 100;
		double bmi = weight / (heightInMeter * heightInMeter);
		System.out.println(bmi);
		System.out.println(new BigDecimal(bmi).setScale(1, RoundingMode.HALF_UP).doubleValue());
	}
}
