package com.zhc.commonjava.functionencode;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		flashMapTest();
	}

	private static void streamIterateTest() {
		/**
		 * 本示例表示从1开始组装一个序列，第一个是1，第二个是1+1即2，第三个是2+1即3..，直接10时中止； 也可简化成以下形式：
		 * Stream.iterate(1, n -> n <= 10, n -> n+1).forEach(System.out::println);
		 * 写成以下方式是为简化理解 jdk9
		 */
//		Stream.iterate(1,
//		        new Predicate<Integer>() {
//		            @Override
//		            public boolean test(Integer integer) {
//		                return integer <= 10;
//		            }
//		        },
//		    new UnaryOperator<Integer>() {
//		        @Override
//		        public Integer apply(Integer integer) {
//		            return integer+1;
//		        }
//		}).forEach(System.out::println);
	}

	private static void streamGenerateTest() {

		/**
		 * 随机生成10个Double元素的Stream并将其打印
		 */
		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		}).limit(10).forEach(System.out::println);

		// 上述写法可以简化成以下写法：
		Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
	}

	private static void iteratorTest() {
//		用于对Stream中的元素进行过滤，返回一个过滤后的Stream .
//		Stream<T> filter(Predicate<? super T> predicate);
		Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
		// 查找所有包含t的元素并进行打印
		s.filter(n -> n.contains("t")).forEach(System.out::println);
	}

	private static void mapTest() {
//		元素一对一转换。 
//		它接收一个Funcation参数，用其对Stream中的所有元素进行处理，返回的Stream对象中的元素为Function对原元素处理后的结果 
//		其方法定义如下：
//
//		<R> Stream<R> map(Function<? super T, ? extends R> mapper);
//		示例，假设我们要将一个String类型的Stream对象中的每个元素添加相同的后缀.txt，如a变成a.txt，其写法如下：
		Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
		s.map(n -> n.concat(".txt")).forEach(System.out::println);
	}

	private static void flashMapTest() {
//		元素一对多转换：
//		对原Stream中的所有元素使用传入的Function进行处理，每个元素经过处理后生成一个多个元素的Stream对象，
//		然后将返回的所有Stream对象中的所有元素组合成一个统一的Stream并返回； 
//		方法定义如下：
//
//		<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

//		示例，假设要对一个String类型的Stream进行处理，将每一个元素的拆分成单个字母，并打印：
		Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa");
		s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);
	}

	private static void takeWhileTest() {
//		如果Stream是有序的（Ordered），那么返回最长命中序列（符合传入的Predicate的最长命中序列）组成的Stream；
//		如果是无序的，那么返回的是所有符合传入的Predicate的元素序列组成的Stream。 
//		与Filter有点类似，不同的地方就在当Stream是有序时，返回的只是最长命中序列。 
//		jdk9
//		default Stream<T> takeWhile(Predicate<? super T> predicate);

//		如以下示例，通过takeWhile查找”test”, “t1”, “t2”, “teeeee”, “aaaa”, “taaa”这几个元素中包含t的最长命中序列：
		Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");
		// 以下结果将打印： "test", "t1", "t2", "teeeee"，最后的那个taaa不会进行打印
//		s.takeWhile(n -> n.contains("t")).forEach(System.out::println);
	}

	private static void dropWhileTest() {
//		与takeWhile相反，如果是有序的，返回除最长命中序列外的所有元素组成的Stream；
//		如果是无序的，返回所有未命中的元素组成的Stream;其定义如下：

//		default Stream<T> dropWhile(Predicate<? super T> predicate)

//		jdk9

//		通过dropWhile删除”test”, “t1”, “t2”, “teeeee”, “aaaa”, “taaa”这几个元素中包含t的最长命中序列：

		Stream<String> s = Stream.of("test", "t1", "t2", "teeeee", "aaaa", "taaa");
		// 以下结果将打印："aaaa", "taaa"
//		s.dropWhile(n -> n.contains("t")).forEach(System.out::println);
	}
}
