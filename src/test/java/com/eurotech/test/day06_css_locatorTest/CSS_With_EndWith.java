package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_EndWith {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();

        driver.findElement(By.cssSelector("input[id$='email']"))
                .sendKeys("gulgunfeyman@gmail.com");

        driver.findElement(By.cssSelector("input[id$='pw-input']"))
                .sendKeys("gulgun_11");

        driver.findElement(By.cssSelector("input[class$='primary']")).click();

        Thread.sleep(2000);
        driver.close();
    }
}
