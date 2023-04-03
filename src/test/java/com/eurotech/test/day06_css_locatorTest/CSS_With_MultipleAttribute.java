package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_MultipleAttribute {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();
        //multiple attribute with xpath
        String xpathText = driver.findElement(By.xpath("//p[@class='lead'][@id='loginpage-p1']")).getText();
        System.out.println("xpathText = " + xpathText);

        //multiple attribute with css => (with tagName "p[class='lead'][id='loginpage-p1']")
        String cssText = driver.findElement(By.cssSelector("[class='lead'][id='loginpage-p1']")).getText();
        System.out.println("cssText = " + cssText);

        //We can NOT go child to parent with CSS

        Thread.sleep(2000);
        driver.close();
    }
}
