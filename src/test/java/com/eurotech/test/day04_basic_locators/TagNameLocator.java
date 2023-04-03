package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {

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

            //verify that Experience Credentials is here/displayed
            WebElement verifyExperienceCredentials = driver.findElement(By.tagName("h2"));
            System.out.println("verifyExperienceCredentials.getText() = " + verifyExperienceCredentials.getText());

            Thread.sleep(4000);

            driver.get("http://the-internet.herokuapp.com/inputs");

            System.out.println("driver.findElement(By.tagName(\"h3\")) = " + driver.findElement(By.tagName("h3")).getText());
            System.out.println("driver.findElement(By.tagName(\"p\")) = " + driver.findElement(By.tagName("p")).getText());

            driver.close();

        }
}
