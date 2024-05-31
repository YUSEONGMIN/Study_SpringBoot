package com.example.demo;

public class OverrideDemo {

    void test() {
        Child child = new Child();
        child.method();
    }
    
}

class Parent {
    void method() {

    }
}

class Child extends Parent {

    void method() {

    }
}