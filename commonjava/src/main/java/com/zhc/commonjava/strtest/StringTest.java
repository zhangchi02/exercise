/**
 * Project Name:mysql-connection  
 * File Name:StringTest.java  
 * Package Name:com.zhc.mysql.connection  
 * Date:2018年3月21日上午9:33:10  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *
 */

package com.zhc.commonjava.strtest;

import com.google.common.base.Strings;

/**
 * ClassName:StringTest <br/>  
 * Date:     2018年3月21日 上午9:33:10 <br/>  
 * @author l00228291
 * @version
 * @since JDK 1.6
 * @see
 */
public class StringTest {

  public static void main(String[] args) {
//		parseIntTest();
    String version = "2019.1024.1511.56";
    String[] versions = version.split("\\.", -1);
    System.out.println(versions.length);

    System.out.println(StringTest.class.getName());

    String url = "cse://simple/simple/v0/%s?name=%s";
    String longUri = String.format(url, "sayHi", "zhangsan");
    System.out.println(longUri);
  }

  public static void parseIntTest() {
    String studentId = "201804001";
    System.out.println((Integer.parseInt(studentId) + 1 + "--"));
  }
}
  
