package com.zhc.spring.beans;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Person2 {
  private String name;

  private Integer age;

  private String address;

  private Map<String, Car> cars;

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

  public Map<String, Car> getCars() {
    return cars;
  }

  public void setCars(Map<String, Car> cars) {
    this.cars = cars;
  }

  public Person2() {
    super();
  }

  public Person2(String name, Integer age, String address, Map<String, Car> cars) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.cars = cars;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", address=" + address
        + ", cars=" + cars + "]";
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Person2 stu = (Person2) ctx.getBean("person2");
    System.out.println(stu);
  }
}
