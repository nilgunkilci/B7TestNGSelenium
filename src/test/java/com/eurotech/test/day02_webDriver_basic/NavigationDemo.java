package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        Class Task
        *go to google
        * go to facebook
        * back
        *

         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); // empty browser

        driver.get("https://www.google.com/");

        Thread.sleep(2000); // wait  icin gerekli. add  exception  metod yapmak gerekli

        // navigate().to() methodu another website with different selenium
        driver.navigate().to("https://de-de.facebook.com/");
        Thread.sleep(2000);

        // goes back to previous page
        driver.navigate().back();

        Thread.sleep(2000);

        //goes back to back
        driver.navigate().forward();

        Thread.sleep(2000);

        //refresh to webpage
        driver.navigate().refresh();

    }
}
