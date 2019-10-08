package com.zhc.commonjava.annotation;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        AnnotationProcessor.init(user);
        System.out.println(user.toString());
    }
}
