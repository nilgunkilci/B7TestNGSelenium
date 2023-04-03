package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS_LocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        // css ile
        driver.findElement(By.cssSelector("#loginpage-input-email")).sendKeys("eurotech");

        // id ile
        // driver.findElement(By.id("loginpage-input-email")).sendKeys("eurotech");
        Thread.sleep(2000);

        driver.close();
    }
}
