package com.eurotech.test.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        //
        WebDriverManager.chromedriver().setup();


        WebDriver  driver = new ChromeDriver();  // polymorphism

        //WebDriverManager.edgedriver().setup();
        //WebDriver driver = new EdgeDriver();
       // driver.get("https://www.google.com");
        driver.get("https://www.amazon.com.tr/");


    }
}
