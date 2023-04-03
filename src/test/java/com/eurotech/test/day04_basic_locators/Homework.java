package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework {
    public static void main(String[] args) throws InterruptedException {

/** Class Task
 * go to the url - "https://www.browserstack.com/users/sign_up"
 * maximize the window
 * accept cookies if any,
 * fill in the blanks with the faker class
 * click "Term of service" checkbox
 * and close the window
 *
 * hint: u can use any locator you want
 *
 */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();
        WebElement acceptAll = driver.findElement(By.id("accept-cookie-notification"));
        acceptAll.click();

        WebElement inputUserName = driver.findElement( By.id("user_full_name"));
        Faker faker  = new Faker();
        String name =faker.name().firstName();
         inputUserName.sendKeys(name);

         Thread.sleep(2000);

        WebElement inputUserEmail = driver.findElement( By.id("user_email_login"));
        String eMail = faker.internet().emailAddress();
        inputUserEmail.sendKeys( eMail);

        Thread.sleep(2000);

        WebElement inputPassword = driver.findElement( By.id("user_password"));
        String password = faker.internet().emailAddress();
         inputPassword.sendKeys( eMail);

        Thread.sleep(2000);

        WebElement checkbox = driver.findElement(By.id("tnc_checkbox"));
        checkbox.click();

        Thread.sleep(2000);

        WebElement signMeUp = driver.findElement(By.name("commit"));
        signMeUp.click();

        Thread.sleep(2000);

        driver.close();






    }
}
