package com.example.yongqi.demo.testkt;

public class A implements AIntentface {

    public static final A a = new A();

    @Override
    public void putNum(int num) {
        System.out.print("int");
    }

    @Override
    public void putNum(Integer num) {
        System.out.print("Integer");

    }
}
