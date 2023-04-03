package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /** Class TAsk 3
         * open chrome browser
         * go to http://eurotech.study/login
         * enter email as "eurotech@gmail.com"
         * enter password Test12345!
         * click login btn
         * verify that welcome message is "Welcome Teacher"
         * */

        String email="eurotech@gmail.com";
        String password="Test12345!";
        String expectedText="Welcome Teacher";

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        WebElement  emailInputBtn= driver.findElement(By.id("loginpage-input-email"));
        emailInputBtn.sendKeys(email);

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        Thread.sleep(2000);

        // verify that welcome message is "Welcome Teacher"

        // two ways to get text from web
        // 1. getText() => it will work %99 work and it will return string
        // 2 getAttribute("value ") => second way of getting text especially input box

        WebElement welcomeText = driver.findElement(By.id("dashboard-p1"));
        System.out.println("welcomeText = " + welcomeText.getText());

        String actualText=welcomeText.getText();

        if(expectedText.equals(actualText)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }


        driver.close();


    }
}
