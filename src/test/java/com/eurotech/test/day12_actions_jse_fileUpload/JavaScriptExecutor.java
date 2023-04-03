package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void germany() {
        driver.get("https://www.amazon.co.uk/");
        //WebDriverFactory acceptCookies = driver.findElement()
        driver.findElement(By.id("sp-cc-accept"));

        WebElement germany = driver.findElement(By.linkText("Germany"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", germany);
    }

    @Test
    public void typeWithJS() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        String text= "EuroTech Batch_7";

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

        Thread.sleep(2000);
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}
