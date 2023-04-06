package com.eurotech.test.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {
    LoginPage loginPage;
    @Test
    public void wrongUsername(){
        loginPage=new LoginPage();
        extentLogger =report.createTest("Wrong Username Test");
        extentLogger.info("Navigate to url");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();
        extentLogger.info("Enter wrong user Email");
        loginPage.usernameInput.sendKeys("eurotechb7@gmail.netttt");
        //loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter correct password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        String actualMessage=loginPage.warningMessage.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Invalid Credentials!");
       //Assert.assertEquals(actualMessage,"Invalid Credentials!!!!!!!!");  // Bunu testin gecmemesi icin bu satiri kullan

        extentLogger.pass("PASSED");
    }

    @Test
    public void wrongPassword(){
        loginPage=new LoginPage();
        extentLogger =report.createTest("Wrong Password Test");
        extentLogger.info("Navigate to url");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();
        extentLogger.info("Enter correct user Email");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter wrong password");
        loginPage.passwordInput.sendKeys("wrong password");
        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        String actualMessage=loginPage.warningMessage.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Invalid Credentials!");
        //Assert.assertEquals(actualMessage,"Invalid Credentials!!!!!!!!");  // Bunu testin gecmemesi icin bu satiri kullan

        extentLogger.pass("PASSED");
    }

}
