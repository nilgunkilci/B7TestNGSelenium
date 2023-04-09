package com.eurotech.test.day15_POM;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    @Test
    public void wrongPassword() {


         driver.get(ConfigurationReader.get("url"));
       /* WebElement usernameInput = driver.findElement(By.id("loginpage-input-email"));
        WebElement passwordInput = driver.findElement(By.id("loginpage-form-pw-input"));
        usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        passwordInput.sendKeys("invalid password");

        driver.findElement(By.id("rcc-confirm-button")).click();;
        driver.findElement(By.id("loginpage-form-btn")).click();
        WebElement warningMessage = driver.findElement(By.xpath("//*[.='Invalid Credentials!']"));
        Assert.assertEquals(warningMessage.getText(),"Invalid Credentials!");

        */



       // LoginPage loginPage = new LoginPage();  Yukariya class düzeyinde yaziyoruz

        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys("invalid password") ;
        loginPage.loginBtn.click();
        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials!");
    }


    @Test
    public void wrongUsername() {

        loginPage = new LoginPage(); // bir önceki test ile loginPage tekrar atama yapilmali
        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys("eurotechB7@gmail.com");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();

        String actualMessage = loginPage.warningMessage.getText();
        Assert.assertEquals(actualMessage, "Invalid Credentials!");
    }

}
