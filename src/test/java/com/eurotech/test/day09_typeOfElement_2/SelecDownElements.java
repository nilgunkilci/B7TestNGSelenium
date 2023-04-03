package com.eurotech.test.day09_typeOfElement_2;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelecDownElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");

       // driver.manage().window().maximize();


    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        // !. Step
        WebElement colorDropDown = driver.findElement(By.id("oldSelectMenu"));

        // 2. Step
        Select color = new Select(colorDropDown);

        // 3.Step
        List<WebElement> colorList  = color.getOptions();

        // 4. Step
        System.out.println("colorList.size() = " + colorList.size());

        // 5. Step
        Assert.assertEquals(colorList.size(),11);

        // 6.Step = Tüm elementleri for each ile yazdirmak
        for (WebElement element  : colorList) {
            System.out.println("element.getText() = " + element.getText());

        }

        // default olan ilk secenegi dogrulamak icin getFirstSelectedOption()

        String expectedColor = "Red";
        String actualColor = color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor, " Verify that default color is red");


        // *** How to Select optipn from dropdown ? ****
        // 3 yöntem var

        // 1. yöntem =>  Select with by visible text ---> selectByVisibleText("")
        Thread.sleep(1000);
        color.selectByVisibleText("Yellow");
        expectedColor ="Yellow";
        actualColor= color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor);

        // 2 .yöntem   Select using Index ---> selectByIndex

        Thread.sleep(2000);
        color.selectByIndex(0);
        Thread.sleep(2000);
        color.selectByIndex(2);
        Thread.sleep(2000);
        color.selectByIndex(5);


        expectedColor ="Black";
        actualColor= color.getFirstSelectedOption().getText();
        Assert.assertEquals(actualColor,expectedColor);

        // 3. yöntem  Select using Value --> selectByValue


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }
}
