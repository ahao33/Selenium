package com.one;

import com.sun.xml.internal.fastinfoset.algorithm.BooleanEncodingAlgorithm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demotest4 {

    WebDriver webDriver;

    @BeforeMethod
    public  void OpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/ahao/Downloads/idea/drivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
    }


    @Test   //使用元素name定位,点击
    public void OpenId(){
       WebElement newsname = webDriver.findElement(By.name("tj_trnews"));
       newsname.click(); //点击
       String url=webDriver.getCurrentUrl();
       Assert.assertEquals(url,"http://news.baidu.com/"); //校验url
    }


    @Test   //输入和点击
    public void sendkeysTest() throws InterruptedException {
        WebElement sousuo=webDriver.findElement(By.name("wd"));
        sousuo.sendKeys("百度网盘");//输入
        WebElement button=webDriver.findElement(By.id("su"));
        button.click();
        Thread.sleep(3000);
        String title=webDriver.getTitle(); //获取title
        Assert.assertEquals(title,"百度网盘_百度搜索");//校验title
    }

    @Test   //标签名的值  tagname
    public void Tagname() throws InterruptedException {
        String text=webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(text,"input"); //校验tagname
        Thread.sleep(3000);
    }


    @Test //获取属性值
    public void  GetAtest(){
        String attrtibute=webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attrtibute,"百度一下");    //登陆页面，可以验证账号和密码中提示文字
    }


    @Test //查看页面元素是否存在  是否显示 百度一下按钮
    public void isDisplayedtest(){
        Boolean b=webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }



    @Test  //获取文本，只能是标签里面的文本
    public void GetText() throws InterruptedException {
        String news=webDriver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(news,"新闻"); //校验文本
        Thread.sleep(2000);
    }





    @Test   //清空文本
    public void Cleartext(){
        WebElement sousuo=webDriver.findElement(By.name("wd"));
        sousuo.sendKeys("哈哈哈");
        sousuo.clear();
    }





    @AfterMethod
    public  void CloseBrowser(){
        webDriver.quit();
    }


}
