package com.page.po;

import org.openqa.selenium.By;

public class MenuPage {
        //门店主菜单
        public static By EenuBotto =By.xpath("//*[@id=\"app\"]/section/section/aside/ul/li[2]/div/span");
        //门店子菜单
        public  static By EenuShopBotto=By.xpath("//*[@id=\"app\"]/section/section/aside/ul/li[2]/ul/li");
        //创建门店
        public  static  By shop=By.xpath("//*[@id=\"app\"]/section/section/main/div/div[3]/section/div[2]/div[1]/span[2]");
}
