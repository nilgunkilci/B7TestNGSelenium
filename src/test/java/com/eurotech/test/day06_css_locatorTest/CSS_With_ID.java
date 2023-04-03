package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_ID {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        //css locator with ID
        WebElement userEmail = driver.findElement(By.cssSelector("input#loginpage-input-email"));
        userEmail.sendKeys("CSS with ID with TagName");

        //css locator with ID with tagName
        WebElement userPassword = driver.findElement(By.cssSelector("#loginpage-form-pw-input"));
        userPassword.sendKeys("CSS with ID");

        Thread.sleep(2000);
        driver.close();
    }
}
