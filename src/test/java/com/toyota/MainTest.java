package com.toyota;

import com.page.po.MenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {

    WebDriver webDriver;

    @BeforeMethod
    public void OpenBrowsers(){
        System.setProperty("webdriver.chrome.driver","/Users/ahao/Downloads/idea/drivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://test.icheyou.net/talk-table-admin/#/login");
    }



    @DataProvider(name="userlist")  //使用等价类来划分，数据驱动
    public Object[][]test(){
        return new Object[][]{
                {"32323232","h23h"},
                {"admin2","fhih"}
        };
    }






    @Test  //利用PO方法封装定位元素
    public void MenuShop() throws InterruptedException {
        LoginTest.login(webDriver,"yqtoyota_admin","admin123");
        webDriver.findElement(MenuPage.EenuBotto).click();
        webDriver.findElement(MenuPage.EenuShopBotto).click();
        webDriver.findElement(MenuPage.shop).click();
        Thread.sleep(5000);
    }



    @Test(dataProvider="userlist")  //使用等价类来划分，数据驱动
    public void MenuShop2(String  username,String pwd) throws InterruptedException {
        LoginTest.login(webDriver,username,pwd);
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section/section/aside/ul/li[2]/div/span")).click();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section/section/aside/ul/li[2]/ul/li")).click();
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/section/section/main/div/div[3]/section/div[2]/div[1]/span[2]")).click();
        Thread.sleep(5000);
    }









    @AfterMethod
    public void Closed(){
        webDriver.quit();
    }

}
