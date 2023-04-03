package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getAttribute {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();

        String email="eurotech@gmail.com";

        Thread.sleep(2000);

        WebElement  emailInputBox= driver.findElement(By.id("loginpage-input-email"));
        emailInputBox.sendKeys(email);

        Thread.sleep(2000);

        //getAttribute() --> give me attribute key I will give you attribute value


        String value = emailInputBox.getAttribute("placeholder");
        System.out.println("value = " + value);

        String requiredValue=emailInputBox.getAttribute("value");
        System.out.println("requiredValue = " + requiredValue);

        driver.close();


    }
}
