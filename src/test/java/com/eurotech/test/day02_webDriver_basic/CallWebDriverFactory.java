package com.eurotech.test.day02_webDriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        /*
        Class Task
        * go to devEx website
        * expected title == DevEx
        get title
         */

        driver.get("http://eurotech.study/");
        Thread.sleep(2000);
        System.out.println("driver.getTitle().equals(\"DevEx\") = " + driver.getTitle().equals("DevEx"));
        driver.close();

        driver = WebDriverFactory.getDriver("chrome");
        String  expectedTitle = "DevEx";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
    }
}
