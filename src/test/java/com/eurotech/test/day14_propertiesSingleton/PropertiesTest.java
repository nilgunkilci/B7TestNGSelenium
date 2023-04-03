package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.security.Key;

public class PropertiesTest {
    @Test
    public void test1() {
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);

        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);
    }

    @Test
    public void openBrowserUsingConfigurationReader() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("loginpage-input-email")).sendKeys(ConfigurationReader.get("usernameTeacher"));
        driver.findElement(By.id("loginpage-form-pw-input")).sendKeys(ConfigurationReader.get("passwordTeacher")+ Keys.ENTER); // Keys.Enter i , klavye de enter tusuna basmak icin kullaniyoruz



        driver.close();Thread.sleep(2000);
    }
    @Test
    public void testname(){

        WebDriver driver1 = WebDriverFactory.getDriver("chroma");
        driver1.get("https://www.amazon.co.uk/");

        WebDriver driver2 = WebDriverFactory.getDriver("chroma");
        driver2.findElement(By.id("ss-cc-pp")).click();


    }
}
