package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://eurotech.study/");

        Thread.sleep(2000);
        driver.close();     // sadece acik olan tabi kapatir

        // close() ile browser kapatildigi icin yeni bir browser object olusturmak lazim.
        // yoksa exception hatasi veriyor
        driver = new ChromeDriver();
        driver.get("https://de-de.facebook.com/");
        Thread.sleep(2000);

         driver.quit();   // tüm tablari kapatir


    }
}
