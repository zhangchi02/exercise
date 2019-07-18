package com.zhc.commonjava.code;

/**
 * @author zhangchi02
 * @date 2018年11月27日
 */
public class CodeBlock {
	private int i = 1;
	private static String j = "abc";

	{
		System.out.println("code block");
		i = 3;
	}

	static {
		System.out.println("static code block");
		j = "123";
	}
	public CodeBlock(){
		System.out.println("constructor");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("j:" + j);
		System.out.println("i:" + new CodeBlock().i);
	}

}
