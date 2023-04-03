package com.eurotech.test.day08_typeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("#start>button")); // ccs ile locaed edildi

        WebElement hello = driver.findElement(By.xpath("//*[.='Hello World!']")); // * -> tüm taglari temsil ediyor-  . -> text i temsil eder
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());

        Assert.assertFalse(hello.isDisplayed(),"Verify that Hello World! is NOT displayed");

        startButton.click();
        Thread.sleep(5000);
        System.out.println("----------------------------");
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());

        Assert.assertTrue(hello.isDisplayed());
        System.out.println("hello.getText() = " + hello.getText()); // getText() text i almak icin

        driver.close();

    }
    @Test
    public void testTask(){

        /**
         * Class Task
         * go to https://the-internet.herokuapp.com/dynamic_loading/2
         * see Example 2: Element rendered after the fact -->click
         * Then do this task;
         *    verify that hello world is not displayed
         *    click start button
         *    verify that hello element is displayed
         *    and verify that "Hello World!" text is present
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.cssSelector("#star>button"));
        WebElement hello = driver.findElement(By.cssSelector("#finish>h4"));
        System.out.println("hello.isDisplayed() = " + hello.isDisplayed());


    }
}
