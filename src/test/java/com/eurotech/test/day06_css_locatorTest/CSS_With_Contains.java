package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_Contains {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();
        // contains with xpath
        String xpathText = driver.findElement(By.xpath("//p[contains(@id,'warn')]")).getText();
        System.out.println("xpathText = " + xpathText);

        //contains with css
        String cssText = driver.findElement(By.cssSelector("p[id*='warn']")).getText();
        System.out.println("cssText = " + cssText);


        Thread.sleep(2000);
        driver.close();
    }
}
