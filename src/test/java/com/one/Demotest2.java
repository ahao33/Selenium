package com.one;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demotest2 {

    @Test
    //java中判断相等
    public void assertEqualTest(){
        String a="220";
        String b="220";
        if(a.equals(b)){
            System.out.println("正确");
        }else {
            System.out.println("错误");
        }
    }

    @Test
    //testng判断相等
    public void assertEqual(){
        String a="9";
        String b="9";
        Assert.assertEquals(a,b,"A不等于B");
    }

    @Test
    //testng判断不相等
    public void  noequal(){
        int a=1;
        int b=1;
        Assert.assertNotEquals(a,b,"A和B相等");

    }

    @Test
    //testng判断为空
    public void assertnull(){
        String a =null;
        Assert.assertNull(a);
    }

    @Test
    //testng判断不为空
    public void assernotnull(){
        String a ="工地";
        Assert.assertNotNull(a);
    }

}