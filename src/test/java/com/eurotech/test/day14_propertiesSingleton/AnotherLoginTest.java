package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {


    /**
     * Class Task
     * go to url
     * enter username         usernameInput.sendKeys()
     * enter password         passwordInput.sendKeys()
     * click login button     loginBtn.click().
     */
    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("url"));
        WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));

        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher") + Keys.ENTER);
        //  Keys.ENTER metodu ile klavye de enter tusu görevini yapar.


    }

    @Test
    public void test2() {
        //WebDriver driver1 = WebDriverFactory.getDriver("chrome");
        //WebDriver driver2 = WebDriverFactory.getDriver("Chrome");
        // bu sekilde ayri ayri browser acmis oluyoruz.
        // tek browser acmak icin singleton esign pattern kullaniyoruz.
        // bunun icin utilities package da Driver classi actik

        WebDriver driver1 = Driver.get();
        WebDriver driver2 = Driver.get();

        driver1.get("http://eurotech.study/login");
        driver2.findElement(By.id("loginpage-input-email")).sendKeys("B7  is here");

    }
}
