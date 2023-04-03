package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_ParentToChild {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://eurotech.study/login");
        WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        understandBtn.click();

        //parent to child with xpath  ' / '
        String xpathText = driver.findElement(By.xpath("//section/p")).getText();
        System.out.println("xpathText = " + xpathText);

        //parent to child with CSS ' > '=> we can NOT use index with CSS
        String cssText = driver.findElement(By.cssSelector("section>p")).getText();
        System.out.println("cssText = " + cssText);
        // css parent to child 2 way
        String cssText2 = driver.findElement(By.cssSelector("body section p")).getText();
        System.out.println("cssText2 = " + cssText2);


        Thread.sleep(2000);
        driver.close();
    }
}
