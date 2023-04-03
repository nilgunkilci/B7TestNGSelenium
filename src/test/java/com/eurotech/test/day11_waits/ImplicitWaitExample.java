package com.eurotech.test.day11_waits;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example>button"));

        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // implicitWait , findElement ile birlikte calisr.
        // BeforeMethod a eklenirse tüm test icin gecerli olur
        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();

    }
}
