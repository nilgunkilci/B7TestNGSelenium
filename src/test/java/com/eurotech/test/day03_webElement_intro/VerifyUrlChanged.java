package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task 2
         * open chrome browser
         * go to the http://eurotech.study/login
         * enter email as eurotech@gmail.com
         * enter password as Test12345!
         * click on login button
         * verify that url has changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();


        String email = "eurotech@gmail.com";
        String password = "Test12345!";

        //enter email
        WebElement emailInputBox = driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);

        //enter password
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);

        //click on login button
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);

        //verify that url has changed
        String expectedUrl = "http://eurotech.study/dashboard";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
