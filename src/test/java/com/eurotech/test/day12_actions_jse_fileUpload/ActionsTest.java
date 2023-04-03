package com.eurotech.test.day12_actions_jse_fileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement img1 = driver.findElement(By.xpath("(//img)[2]"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);

        actions.moveToElement(img1).perform();

        WebElement viewProfil1= driver.findElement(By.linkText("View profile")) ;
        System.out.println("viewProfil1 = " + viewProfil1);
        Assert.assertTrue(viewProfil1.isDisplayed(),"verify that the element is displayed");
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
        WebElement verifyMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        //first way
        // Assert.assertEquals(verifyMessage.getText(),"Dropped!", "Verify that the element has been dropped");

        //second way
        Assert.assertTrue(verifyMessage.isDisplayed());

    }
    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        //actions.moveToElement(source).clickAndHold() .moveToElement(target).perform();
        // source gitti. source tuttu. target a gitti. birak demedik.
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(3000).release().perform();
        //source gitti. source tuttu. target a gitti.pause verdi.sonra birakti.

        WebElement verifyMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());


        Assert.assertTrue(verifyMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       driver.close();

    }
}
