package com.zhc.commonjava.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateTest {

  public static void main(String[] args) {
    // 当前时间
    Date d1 = new Date();
    System.out.println("当前时间：" + d1);
    System.out.println("时间戳：" + d1.getTime());

    // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
    Date d2 = new Date(5000);
    System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间：" + d2);

    long l1 = System.currentTimeMillis();
    Date d3 = new Date(l1);
    System.out.println("时间戳：" + l1);
    System.out.println(d3);

    Date date = new Date(1503544630000L);  // 对应的北京时间是2017-08-24 11:17:10

    SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
    bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区

    SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
    tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

    SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
    londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));  // 设置伦敦时区

    System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
    System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
    System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));

    System.out.println(TimeUnit.SECONDS.toMillis(30));
  }
}
