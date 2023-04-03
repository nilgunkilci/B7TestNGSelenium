package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void fileUploadTest1() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

    }

    @Test
    public void fileUploadTest2() {
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        driver.get("https://the-internet.herokuapp.com/upload");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}
