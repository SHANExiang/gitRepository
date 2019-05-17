package com.dongxiang.beans;

public class Car {
    public void setBrand(String brand) {
        System.out.println("set brand...");
        this.brand = brand;
    }

    private String brand;

    public void init(){
        System.out.println("init...");
    }

    Car(){
        System.out.println("car is constructor...");
    }

    public void destroy(){
        System.out.println("destroy...");
    }

    @Override
    public String toString() {
        return "car [ brand = " + brand + "]";
    }
}
