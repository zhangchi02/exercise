package com.zhc.commonjava.functionencode;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Assert;

public class Java8FuncEncodeTest {

	public static void main(String[] args) {
		predicateTest();
	}
	/**
	 * Consumer测试
	 */
	public static void consumerTest() {
	    Consumer f = System.out::println;
	    Consumer f2 = n -> System.out.println(n + "-F2");

	    //执行完F后再执行F2的Accept方法
	    f.andThen(f2).accept("test");

	    //连续执行F的Accept方法
	    f.andThen(f).andThen(f).andThen(f).accept("test1");
	}
	/**
	 * Function测试
	 */
	public static void functionTest() {
//		Function<Integer, Integer> f = s -> s++;
		Function<Integer, Integer> f = s -> {
			return s++;
		};
//	    Function<Integer, Integer> g = s -> s * 2;
		Function<Integer, Integer> g = s -> {
			return s * 2 ;
		};

	    /**
	     * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
	     * 相当于以下代码：
	     * Integer a = g.apply(1);
	     * System.out.println(f.apply(a));
	     */
	    System.out.println(f.compose(g).apply(3));

	    /**
	     * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
	     * 相当于以下代码
	     * Integer a = f.apply(1);
	     * System.out.println(g.apply(a));
	     */
	    System.out.println(f.andThen(g).apply(3));

	    /**
	     * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等； 
	     */
	    System.out.println(Function.identity().apply("a"));
	}
	
	/**
	 * Predicate测试
	 */
	private static void predicateTest() {
	    Predicate<String> p = o -> o.equals("test");
	    Predicate<String> g = o -> o.startsWith("t");

	    /**
	     * negate: 用于对原来的Predicate做取反处理；
	     * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
	     */
	    Assert.assertFalse(p.negate().test("test"));

	    /**
	     * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
	     */
	    Assert.assertTrue(p.and(g).test("test"));

	    /**
	     * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
	     */
	    Assert.assertTrue(p.or(g).test("ta"));
	}
	
}
