package com.eurotech.test.day10_typeOfWebElement_3;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PopUpAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=37ab5");

        // Click the Confirm Button
        driver.findElement(By.xpath("//span[.='Confirm']")).click();

    }

    @Test
    public void testjsAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();  // accept ok anlamindadir. click to ok.
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        alert.dismiss();    // click to cancel. yani iptal etme tusu

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.sendKeys("B7 is here");
        Thread.sleep(2000);
        alert.accept();

        // homework : verify all result above JS alerts
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
}
