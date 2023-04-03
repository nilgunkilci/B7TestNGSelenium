package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLacotarTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        WebElement inputUserName = driver.findElement( By.id("userName"));
       // Faker faker  = new Faker();
        //String name =faker.name().firstName();
       // inputUserName.sendKeys(name);
        inputUserName.sendKeys("Nilgun");

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
        //String eMail = faker.internet().emailAddress();
        //inputUserEmail.sendKeys( eMail);
       inputUserEmail.sendKeys( "nlgn@gmail.com");
       Thread.sleep(2000);
       driver.close();




    }
}
