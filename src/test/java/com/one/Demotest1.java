package com.one;

import org.testng.annotations.*;

public class Demotest1 {

    @Test  //根据阿克斯码来排序，abcd和数字，来执行test顺序
    public  void testCase1(){
        System.out.println("这是testCase1注解");
    }

    @Test
    public void  testCase2(){
        System.out.println("这是testCase2注解");
    }

    @BeforeTest   //class运行前，先运行这个
    public void beforetest01(){
        System.out.println("这是一个beforetest注解");
    }

    @BeforeMethod  //每个test运行前，先运行这个
    public  void beforeMethod(){
        System.out.println("这是一个beforeMethod注解");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("这是一个aftertest注解");
    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("这是一个aftermethod注解");
    }

    @Test
    public void atest(){
        System.out.println("这是atest注解");
    }



}
