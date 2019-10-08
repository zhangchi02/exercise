package com.zhc.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Child {
  private Integer id;

  private String name;

  private Integer age;

  private String address;

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

  public Child() {
    super();
  }

  public Child(Integer id, String name, Integer age, String address) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Child [id=" + id + ", name=" + name + ", age=" + age
        + ", address=" + address + "]";
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Child stu = (Child) ctx.getBean("child");
    System.out.println(stu);
  }
}
