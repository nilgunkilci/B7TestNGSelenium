package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
   /* WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    */

    @Test
    public void openBrowserUsingConfigurationReader() {

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER); // Keys.Enter i , klavye de enter tusuna basmak icin kullaniyoruz

    }

    /*
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

     */
}
