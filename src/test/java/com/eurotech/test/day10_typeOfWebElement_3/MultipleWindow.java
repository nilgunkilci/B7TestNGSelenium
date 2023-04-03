package com.eurotech.test.day10_typeOfWebElement_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindow {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);
        driver.findElement(By.linkText("Click Here")).click();
        String titleAfterclick = driver.getTitle();
        System.out.println("titleAfterclick = " + titleAfterclick);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
        driver.quit(); // burada iki pencere acildigi icin quit ile tüm pencereleri kapatiyoruz

    }
}
