package com.toyota;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



public class newtest {


    @Test  //gird分布跑
    public  void gird() throws MalformedURLException, InterruptedException {

        DesiredCapabilities dc=DesiredCapabilities.chrome();
        WebDriver webDriver=new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),dc);
        Thread.sleep(10000);
        webDriver.get("http://www.baidu.com");
        Thread.sleep(10000);
        webDriver.quit();
    }









}
