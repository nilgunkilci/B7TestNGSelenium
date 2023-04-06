package com.eurotech.test.day19_reviewAnd_xmlRunner;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElement extends TestBase {

    @Test
    public void staleProblem(){
        driver.get("https://freecrm.com/");
        BrowserUtils.waitFor(2);
        WebElement loginBtn = driver.findElement(By.xpath("//span[.='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Email@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345");

        driver.navigate().refresh();
        BrowserUtils.waitFor(2);
        emailInput.sendKeys("Email@gmail.com");
        //StaleElementReferenceException:
        // stale element reference: element is not attached to the page document

    }

    @Test
    public void staleFix(){
        driver.get("https://freecrm.com/");
        BrowserUtils.waitFor(2);
        WebElement loginBtn = driver.findElement(By.xpath("//span[.='Log In']"));
        loginBtn.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Email@gmail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("12345");

        driver.navigate().refresh();
        BrowserUtils.waitFor(2);

        try {
            emailInput.sendKeys("Email@gmail.com");
        }catch (StaleElementReferenceException e){
            emailInput=driver.findElement(By.name("email"));
            emailInput.sendKeys("Email@gmail.com");
            passwordInput = driver.findElement(By.name("password"));
            passwordInput.sendKeys("12345");
        }
    }

}
