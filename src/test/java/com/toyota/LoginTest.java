package com.toyota;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

    public static void login(WebDriver webDriver, String name, String pwd){
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[1]/div/div/input")).sendKeys(name);
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[2]/div/div/input")).sendKeys(pwd);
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/form/div[3]/div/button")).click();
    }


}
