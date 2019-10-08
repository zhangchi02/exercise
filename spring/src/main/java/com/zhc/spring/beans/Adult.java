package com.zhc.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Adult {
  private Integer id;

  private String name;

  private Integer age;

  private String address;

  private Car car;

  private HelloWorld hw;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public HelloWorld getHw() {
    return hw;
  }

  public void setHw(HelloWorld hw) {
    this.hw = hw;
  }

  public Adult() {
    super();
  }

  public Adult(Integer id, String name, Integer age, String address,
      Car car, HelloWorld hw) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
    this.car = car;
    this.hw = hw;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", age=" + age
        + ", address=" + address + ", car=" + car + ", hw=" + hw + "]";
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    //		Student stu = (Student) ctx.getBean("student");
    //		System.out.println(stu);
    Adult adult = (Adult) ctx.getBean("adult");
    Adult adult2 = (Adult) ctx.getBean("adult2");
    System.out.println(adult);
    System.out.println(adult2);
  }
}
