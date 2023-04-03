package com.eurotech.test.day09_typeOfElement_2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;   // class basinda tanimlama yapiyoruz ki tekrar tekrar yazmak zorunda olmuyoruz
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
       // driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> menuList = driver.findElements(By.xpath("//a[text()='A/B Testing']/../../li"));

        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize = 44;
        int actualSize = menuList.size();

        Assert.assertEquals(actualSize,expectedSize, "Verify that the size is 44");
        //Assert.assertEquals(menuList.size(),44, "Verify that the size is 44");

        System.out.println("menuList.get(0) = " + menuList.get(0).getText()); // menuList.get(0) => o. index ile 1. elementi alir. fakat getText() ile elementi yazdiririz.
        Thread.sleep(2000);

        //print all elements of the list tüm elementler icin foreach kullaniyoruz
        //iter + ENTER --> Shortcut of For Each Loop
        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void test2() {
        driver.get("https://demoqa.com/elements");
        //Task--> go to this url, verify that 6 elements are there
        List<WebElement> menuList = driver.findElements(By.cssSelector(".header-text"));
        System.out.println("menuList.size() = " + menuList.size());
        int expectedSize = 6;
        int actualSize = menuList.size();

        Assert.assertEquals(actualSize,expectedSize, "Verify that menu list size is 6");

        for (WebElement element : menuList) {
            System.out.println("element.getText() = " + element.getText());
            Assert.assertTrue(element.isDisplayed());// Selenium will check all elements in the list
        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // driver.close();
    }
}
