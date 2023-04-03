package com.eurotech.test.day08_typeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {
    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox2= driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        WebElement checkBox1= driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        Assert.assertTrue(checkBox2.isSelected(),"Verify that the checkbox2 ist selected");
        Assert.assertFalse(checkBox1.isSelected(), " Verify that the checkbox1 is NOT selected");

        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);

        checkBox2.click();
        Thread.sleep(2000);

        Assert.assertFalse(checkBox2.isSelected());
        Assert.assertTrue(checkBox1.isSelected());


        driver.close();


        }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebElement sports = driver.findElement(By.id("hobbies-checkbox-1"));
        Assert.assertFalse(sports.isSelected());
        WebElement reading = driver.findElement(By.id("hobbies-checkbox-2"));
        Assert.assertFalse(reading.isSelected());
        WebElement music = driver.findElement(By.id("hobbies-checkbox-3"));
        Assert.assertFalse(music.isSelected());

        // Class Task
        // complete the task
        // click all the checkboxes
        // then assert that is selected or not
        Thread.sleep(2000);
        WebElement sportsCheck= driver.findElement(By.cssSelector("[for='hobbies-checkbox-1']"));

        sportsCheck.click();
        Thread.sleep(2000);
        Assert.assertTrue(sports.isSelected(),"Verify that sport is selected");

       /*  WebElement sports2 =driver.findElement(By.cssSelector("[for='hobbies-checkbox-1']"));
         sports2.click();

        Thread.sleep(3000);
       // Assert.assertTrue(sports2.isSelected());

        */

       /* WebElement reading2 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        Thread.sleep(2000);
        reading2.click();
        Thread.sleep(2000);
        Assert.assertTrue(reading2.isSelected());

        WebElement music2 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        Thread.sleep(2000);
        music2.click();
        Thread.sleep(2000);
        Assert.assertTrue(music2.isSelected());

        */


        driver.close();


    }
}
