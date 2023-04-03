package com.eurotech.test.day04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://the-internet.herokuapp.com/dynamic_loading");

        WebElement example1= driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        Thread.sleep(2000);
        example1.click();

        String actualText= driver.findElement(By.tagName("h4")).getText();
        String expectedText= "Example 1: Element on page that is hidden";

        if (actualText.equals(expectedText)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Example 2")).click();

        String actualText2= driver.findElement(By.tagName("h4")).getText();
        String expectedText2= "Example 2: Element rendered after the fact";

        if (actualText2.contains(expectedText2)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");

        }
        Thread.sleep(2000);
        driver.navigate().back();    // sayfada geri dönmek icin

        //driver.close();

    }
}
