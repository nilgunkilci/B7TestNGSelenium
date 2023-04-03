package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        // WebDriver dan driver object olustur. metodumuz oldugu icin metodu cagirarak yapiyoruz.
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");   // siteye git

        // understand button u gecmek icin webelement olusturuyoruz
        WebElement understandButton = driver.findElement(By.id("rcc-confirm-button"));
        understandButton.click();

        // email  a girmek icin webelement olusturulur
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("nlgn@gmail.com");
        // 2. yol
       // driver.findElement(By.name("email")).sendKeys("nlgn@gmail.com");

        // password  a girmek icin webelement olusturulur.
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("glgn1234");
        // 2. yol
       // driver.findElement(By.name("password")).sendKeys("glgn1234");

        // login button a click yapmak icin webelement olusturulur.
        WebElement loginButton = driver.findElement(By.id("loginpage-form-btn"));
        loginButton.click();

        Thread.sleep(3000); // bekletme süresi
        //driver.close(); // webpage kapatmak icin


    }
}
