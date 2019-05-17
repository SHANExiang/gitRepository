package com.dongxiang.test;

import com.dongxiang.beans.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    public static void main(String[] args) {
        //创建HelloWorld的一个对象
//        HelloWorld helloWorld1 = new HelloWorld();
        //为name属性赋值
//        helloWorld1.setName("shane");
        //调用方法
//        System.out.println("name: " + helloWorld1.getName());

        //创建Spring的IOC容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        //从IOC容器中获取bean实例
//        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        //调用方法
//        System.out.println("name: " + helloWorld.getName());

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld helloWorld1 = (HelloWorld) ac.getBean("helloWorld1");
        System.out.println(helloWorld1.getName());

        HelloWorld helloWorld2 = (HelloWorld) ac.getBean("helloWorld2");
        System.out.println(helloWorld2.getName());
        HelloWorld helloWorld3 = (HelloWorld) ac.getBean("helloWorld2");
        System.out.println(helloWorld2 == helloWorld3);

        HelloWorld helloWorld4 = (HelloWorld) ac.getBean("helloWorld1");
        System.out.println(helloWorld1 == helloWorld4);
    }
}
