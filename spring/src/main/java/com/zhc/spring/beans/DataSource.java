package com.zhc.spring.beans;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSource {
  private Properties properties;

  public Properties getProperties() {
    return properties;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  public DataSource() {
    super();
  }

  public DataSource(Properties properties) {
    this.properties = properties;
  }

  @Override
  public String toString() {
    return "DataSource [properties=" + properties + "]";
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    DataSource ds = (DataSource) ctx.getBean("dataSource");
    System.out.println(ds);
  }
}
