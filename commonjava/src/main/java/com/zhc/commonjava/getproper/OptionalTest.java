package com.zhc.commonjava.getproper;

import java.util.Optional;

public class OptionalTest {
	private static final String FROM_CLASS = "class";

	public static void main(String[] args) {
		String commentsHost = Optional.ofNullable(System.getenv("FROM_ENV"))
				.orElse(Optional.ofNullable(System.getProperty("FROM_PROPERTY")).orElse(FROM_CLASS));
		System.out.println(commentsHost);
	}
}
