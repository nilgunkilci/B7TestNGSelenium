package com.eurotech.test.day02_webDriver_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {
        // Task => open chrome and navigate to https://www.eurotechstudy.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // driver.navigate().to("https://www.eurotechstudy.com/");
        driver.get("https://de-de.facebook.com/");

        //String title = driver.getTitle();   // getTitle() metodu web sitesinin baslik ismini alir.
        // System.out.println("title = " + title);

        String expectedTitle = "Facebook – Anmelden oder Registrieren";

        String actualTitle = driver.getTitle();
        System.out.println("expectedTitle.equals(actualTitle) = " + expectedTitle.equals(actualTitle));
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        // get the url from browser =>
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // get the sourece of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
