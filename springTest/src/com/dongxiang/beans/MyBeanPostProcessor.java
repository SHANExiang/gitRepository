package com.dongxiang.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + o + ", " + s);
        return o;
    }

    //o为bean，s为beanName

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization " + o + ", " + s);
        Car car = new Car();
        car.setBrand("baoma");
        o = car;
        return o;
    }
}
