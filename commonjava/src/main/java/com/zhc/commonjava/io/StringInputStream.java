package com.zhc.commonjava.io;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import com.google.common.collect.Lists;

/**
 * @author zhangchi02
 * @date 2019年4月16日
 */
public class StringInputStream {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(123);
		list.add(456);
		System.out.println(list);

		// 使用Apache Common Lang直接初始化List数组
		List<Integer> integers = Lists.newArrayList(123, 456);
		System.out.println(integers);

		// 构造字符串列表
		List<String> names = new LinkedList<String>();
		names.add("Xiaohong");
		names.add("Xiaoming");
		names.add("Daming");
		names.add("Xiaohei");

		// 合并为一个字符串，以逗号相连（JDK 8新特性）
		String nameStr = String.join(",", names);

		// 将字符串作为默认的输入流
		InputStream in = IOUtils.toInputStream(nameStr, Charsets.toCharset("UTF-8"));
		// 重置系统的输入流
		System.setIn(in);

		// 模拟键盘输入 这也是OJ(Online Judge)平台测试用例输入的原理
		// 此处也可以换成一个文件输入流
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(",");
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}

}
