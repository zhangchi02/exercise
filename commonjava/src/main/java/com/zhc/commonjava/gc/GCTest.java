package com.zhc.commonjava.gc;

public class GCTest {

  public static void main(String[] args) {
    System.out.println("我还存在。。。。");
    System.gc();
    System.out.println("我要被回收了。。");
  }

}
