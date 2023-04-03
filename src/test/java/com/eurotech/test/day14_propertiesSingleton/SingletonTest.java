package com.eurotech.test.day14_propertiesSingleton;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1() {

        // Singleton singleton = new Singleton();   Singleton class dan object olusturulamaz

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

    }

    @Test
    public void test2() {
       // WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();

        // driver.get("https://www.amazon.co.uk/");
        driver.get(ConfigurationReader.get("url"));
        driver.close();

    }

    @Test
    public void test3() {
       // WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        // driver.get("https://www.google.com/");
        // lazy way
        Driver.get().get("https://www.google.com/");

    }

    @Test
    public void test4() {
        // WebDriver driver = WebDriverFactory.getDriver("chrome");
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.co.uk/");

    }
}
