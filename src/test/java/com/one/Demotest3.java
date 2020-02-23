package com.one;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class Demotest3 {
    WebDriver webDriver;

    @BeforeMethod  //在运行test前，会运行这个
    public  void  open(){
        System.setProperty("webdriver.chrome.driver","/Users/ahao/Downloads/idea/drivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize(); //窗口最大化
    }



    @Test //打开浏览器
    public  void openChorme() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(5000);
        webDriver.navigate().back(); //网页后退
        Thread.sleep(3000);
        webDriver.navigate().forward();//网页前进
        Thread.sleep(3000);
        webDriver.navigate().refresh();//刷新
        Thread.sleep(2000);

    }


    @Test
    public void  openChomre02(){
        webDriver.get("https://www.baidu.com");
        String url=webDriver.getCurrentUrl();//获取当前url
        System.out.println("获取到的url是："+url);
        Assert.assertEquals(url,"https://www.baidu.com");
    }


    @Test  //判断volo单选框被选中  判断选择框是否选取
    public void isSelectTest() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        WebElement keys=webDriver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        keys.click();
        Thread.sleep(5000);
        Boolean b=keys.isDisplayed();
        Assert.assertTrue(b);
    }



    @Test  //判断sumbit按钮处于未激活状态
    public void isEnabled(){
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        Boolean c=webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(c);
    }

    @Test
    public void shottest(){
        webDriver.get("https://www.baidu.com");
        File file=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("/Users/ahao/Desktop/a.jpeg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    @AfterMethod   //每个test运行后，会关闭这个
    public void closed(){
        webDriver.quit();
    }

}