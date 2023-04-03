package com.eurotech.test.day06_css_locatorTest;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS_With_Class {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver= WebDriverFactory.getDriver("chrome");
            driver.get("http://eurotech.study/login");

            // Cerezleri kabul etmek icin
            WebElement understandBtn = driver.findElement(By.cssSelector("#rcc-confirm-button"));
            understandBtn.click();

            WebElement userEmail = driver.findElement(By.cssSelector("input#loginpage-input-email"));
            userEmail.sendKeys("CSS with ID with TagName");
            WebElement userPassword = driver.findElement(By.cssSelector("#loginpage-form-pw-input"));
            userPassword.sendKeys("CSS with ID");

            //CSS with class almak icin locator in basina nokta eklenir.
            // eger class locatorda bosluklar varsa her bosluga nokta koymaliyiz.
            String loginPageWarnText = driver.findElement(By.cssSelector(".my-1")).getText();  // getText() ile string e ceviriyoruz
            System.out.println("loginPageWarnText = " + loginPageWarnText);

            //CSS with class (with space)
            driver.findElement(By.cssSelector(".btn.btn-primary")).click();

            Thread.sleep(2000);

            driver.close();
        }
}
