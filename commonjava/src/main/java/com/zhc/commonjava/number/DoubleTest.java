package com.zhc.commonjava.number;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleTest {

	public static void main(String[] args) {
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
