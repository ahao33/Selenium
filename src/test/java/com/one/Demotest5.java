package com.one;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demotest5 {

    WebDriver webDriver;

    @BeforeMethod
    public void OpenBrowers(){
        System.setProperty("webdriver.chrome.driver","/Users/ahao/Downloads/idea/drivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Test  //在alert警告框点击确定按钮
    public void Alert() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = webDriver.switchTo().alert();//把控制权转换到alert弹窗
        String text=alert.getText(); //获取警告框文本值
        alert.accept();   //点击"确定"按钮
        Assert.assertEquals(text,"请点击确定"); //校验文本
    }

    @Test   //在confirm警告框点击取消按钮，再点击确定按钮
    public void Confirm() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert=webDriver.switchTo().alert();
        alert.dismiss();//点击"取消"按钮
        Thread.sleep(2000);
        alert.accept();//点击"确定"按钮
    }

    @Test //谷歌浏览器有bug，无法输入内容，但是火狐浏览器可以
    public void PromptTest() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(2000);
        Alert alert=webDriver.switchTo().alert();
        alert.sendKeys("哈哈哈");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        alert.accept();
    }


    @Test
    public void iframe() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        //webDriver.switchTo().frame("aa");  //通过ID或者NAME方式转交控制权
        WebElement iframe=webDriver.findElement(By.tagName("iframe")); //也可以通过webelement来转交控制权
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.linkText("baidu")).click();
        Thread.sleep(2000);
        webDriver.switchTo().defaultContent();//控制权转交给原来页面
        webDriver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(2000);
    }

    @Test   //下拉选择框
    public  void SelectTest() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        WebElement selectEl =webDriver.findElement(By.id("moreSelect"));
        Select select=new Select(selectEl);
        select.selectByIndex(2); //通过索引来选择下拉框
        Thread.sleep(2000);
        select.selectByValue("huawei");//通过Value来选择下拉框
        Thread.sleep(2000);
        select.selectByVisibleText("iphone");//通过文本值来选择下拉框
        Thread.sleep(2000);
    }


    @Test     //多窗口处理
    public void WinTest() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(2000);
        String handle1=webDriver.getWindowHandle(); //当前driver所在页面的句柄值
        for (String handles: webDriver.getWindowHandles()){
            if (handles.equals(handle1)){  //判断获取到的handles是否等于handle1
                continue;
            }else {
                webDriver.switchTo().window(handles);
            }
        }
        webDriver.findElement(By.linkText("baidu")).click();
        webDriver.switchTo().window(handle1); //返回到第一个页面
    }




    @AfterMethod
    public void ClosedBrowser(){
        webDriver.quit();
    }


}
