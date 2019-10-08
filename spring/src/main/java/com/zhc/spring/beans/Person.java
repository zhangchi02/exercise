package com.zhc.spring.beans;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Person {
  private String name;

  private Integer age;

  private String address;

  private List<Car> cars;

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

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public Person() {
    super();
  }

  public Person(String name, Integer age, String address, List<Car> cars) {
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
    Person stu = (Person) ctx.getBean("person");
    System.out.println(stu);
  }
}
