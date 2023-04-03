package com.eurotech.test.day03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         *  open the chrome browser
         *  go to the http://eurotech.study/login
         *  click on login button
         *  verify that url did NOT changed
         */

        // open the chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //go to the http://eurotech.study/login
        driver.get("http://eurotech.study/login");
        //driver.get("http://92.205.106.232/login");

        WebElement understandBtn = driver.findElement(By.id("rcc-confirm-button"));
        understandBtn.click();
        //lazy way
        //driver.findElement(By.id("rcc-confirm-button")).click();

        String expectedUrl=driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);

        //There is no difference between String, int or webElement
        //String name="Max";
        //int age= 51;

        //click on login button
        WebElement loginBtn = driver.findElement(By.id("loginpage-form-btn"));
        loginBtn.click();

        //verify that url did NOT changed

        // String expectedUrl="http://eurotech.study/login";

        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        // login button a tiklamadan sonra sayfasnin Url si degisip degismedigini kontrol etmek icin
        // if condition kullaniyoruz

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        Thread.sleep(3000);

        driver.close();
    }
}
