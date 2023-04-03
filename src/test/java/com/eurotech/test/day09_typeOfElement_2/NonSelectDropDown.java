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

public class NonSelectDropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demo.aspnetawesome.com/");
        WebElement bananaDropdown = driver.findElement(By.xpath("(//div[text()='Banana'])[1]"));

        //Click dropdown to see available options
        Thread.sleep(2000);
        bananaDropdown.click();

        //get the options with findElements method and find a common locator
        List<WebElement> bananaList = driver.findElements(By.xpath("(//ul[@class='o-mnits'])[11]/li"));

        System.out.println("bananaList.size() = " + bananaList.size());
        Assert.assertEquals(bananaList.size(),5);// --> Short way

        for (WebElement banana : bananaList) {
            System.out.println("banana.getText() = " + banana.getText());
        }

        Assert.assertEquals(bananaList.get(3).getText(),"Nuts");

        bananaList.get(2).click();
        Thread.sleep(3000);


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[3]")).click();


        driver.findElement(By.xpath("//div[text()='Blue']")).click();
        driver.findElement(By.xpath("//div[text()='Black']")).click();
        driver.findElement(By.xpath("//div[text()='Green']")).click();
        driver.findElement(By.xpath("//div[text()='Red']")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
