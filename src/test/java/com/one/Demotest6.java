package com.one;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demotest6 {
    WebDriver webDriver;


    @BeforeMethod
    public void OpenBrowers(){
        System.setProperty("webdriver.chrome.driver","/Users/ahao/Downloads/idea/drivers/chromedriver");
        webDriver = new ChromeDriver();
       // webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //全局等待，又叫隐示等待，每一个findelement都会等
        webDriver.manage().window().maximize();
    }



    @Test
    public void WaitTest(){
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        WebDriverWait wait = new WebDriverWait(webDriver,10); //显示等待，优先使用这个
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));
        String text=webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText(); //获取文本
        Assert.assertEquals(text,"wait for display");
    }


    @Test  //右击 百度一下按钮
    public void RightClick(){
        webDriver.get("http://www.baidu.com");
        WebElement Button=webDriver.findElement(By.id("su"));
        Actions actions = new Actions(webDriver); //实例化actions类
        actions.contextClick(Button).perform();
    }



    @Test  //鼠标双点 百度一下按钮
    public void DoubleClick(){
        webDriver.get("http://www.baidu.com");
        WebElement Button=webDriver.findElement(By.id("su"));
        Actions actions = new Actions(webDriver);
        actions.doubleClick(Button).perform();
    }

    @Test  //鼠标悬停在元素上
    public void move() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        WebElement element=webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
        String helloworld=webDriver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Assert.assertEquals(helloworld,"Hello World!");
        Thread.sleep(3000);
    }



    @Test  //拖拽元素
    public void Drop() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/dragAndDrop.html");
        WebElement drag=webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        actions.dragAndDropBy(drag,500,500).perform();
        Thread.sleep(5000);
    }


    @Test
    public void DragTest() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/dragAndDrop.html");
        WebElement el1=webDriver.findElement(By.id("drag"));
        WebElement el2=webDriver.findElement(By.xpath("/html/body/h1"));
        Actions actions =new Actions(webDriver);
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform(); //点击按住，移动，放下，执行
        Thread.sleep(3000);
    }


    @Test  //多选下拉框，选择第一个到第三个
    public  void MoreSelect() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        WebElement element=webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list=webDriver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions =new Actions(webDriver);
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(5000);
    }



    @Test   //使用ctrl+S保存页面，但是mac上不能使用
    public  void SaveHtml() throws AWTException, InterruptedException {
        webDriver.get("http://www.baidu.com");
        Robot robot =new Robot(); //实例化Robot类，比Actions更好
        Thread.sleep(2000);
        int keyS=(int) new Character('c');//在mac电脑上没反应，等解决
        robot.keyPress(157);
        System.out.println(keyS);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
    }



    @Test   //上传文件
    public void uploadTest() throws InterruptedException {
        webDriver.get("http://47.98.132.9:19089/selenium_html/selenium_html/index.html");
        webDriver.findElement(By.id("load")).sendKeys("/Users/ahao/Desktop/WechatIMG1.jpeg");
        Thread.sleep(3000);
    }


    @Test  //获取时间戳
    public  void timeTest(){
        long time =System.currentTimeMillis()/100;
        System.out.println(time);

    }



    @AfterMethod
    public void ClosedBrowser(){
        webDriver.quit();
    }



}
