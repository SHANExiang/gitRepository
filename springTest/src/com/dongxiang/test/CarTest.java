package com.dongxiang.test;

import com.dongxiang.beans.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        Car car1 = (Car) classPathXmlApplicationContext.getBean("car1");
        System.out.println(car1);

        //关闭IOC容器
        classPathXmlApplicationContext.close();
    }
}
