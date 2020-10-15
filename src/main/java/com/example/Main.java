package com.example;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassLoader cl1 = new URLClassLoader(new URL[]{}, Main.class.getClassLoader());
        Thread.currentThread().setContextClassLoader(cl1);
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(RootConfiguration.class);
        SimpleService ss1 = context1.getBean(SimpleService.class);
        System.out.println(ss1.getClass());

        ClassLoader cl2 = new URLClassLoader(new URL[]{}, Main.class.getClassLoader());
        Thread.currentThread().setContextClassLoader(cl2);
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(RootConfiguration.class);
        SimpleService ss2 = context2.getBean(SimpleService.class);
        System.out.println(ss2.getClass());
    }

}
