package com.dongxiang.beans;

public class HelloWorld {
    private String name;

    public void setName(String name) {
        System.out.println("为属性赋值");
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public HelloWorld(){
        System.out.println("构造器");
    }

}

