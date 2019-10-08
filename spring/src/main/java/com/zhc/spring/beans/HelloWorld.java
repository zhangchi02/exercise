package com.zhc.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
  private String str;

  public String getStr() {
    return str;
  }

  public void setStr2(String str) {
    System.out.println("HelloWorld set方法");
    this.str = str;
  }

  public void show() {
    System.out.println("HelloWorld show方法！！");
    System.out.println("HelloWorld : " + str);
  }

  public HelloWorld() {
    System.out.println("HelloWorld 无参构造器~~~");
  }

  public static void main(String[] args) {

    /*
      //创建对象
      HelloWorld hw = new HelloWorld();
      //为属性赋值
      hw.setStr2("tom");
    */

    //1、创建Spring的IOC容器
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

    //2、从IOC容器中获取Bean实例
    //根据id获取
    HelloWorld hw = (HelloWorld) ctx.getBean("hello");
    //根据类型获取（要求类型是唯一的，否则抛出异常）
    //    HelloWorld hw = ctx.getBean(HelloWorld.class);

    //3、调用方法
    hw.show();
  }

}
