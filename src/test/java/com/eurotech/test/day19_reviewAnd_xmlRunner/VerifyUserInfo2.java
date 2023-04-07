package com.eurotech.test.day19_reviewAnd_xmlRunner;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo2 extends TestBase {

    /**
     * Class Task
     * Login as a teacher
     * Verify that login is successful
     * click on Edit profile button
     * Verify that github username is eurotech2022
     * Click on go back button
     * Verify that user's title is Director
     */

    @Test
    public void userInfo() {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage=new ProfilePage();

        extentLogger = report.createTest("User info verification");

        extentLogger.info("Navigate to DevEx website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();
        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        //1 way to verify log in successfully
        extentLogger.info("Verify that login is successful");
        //BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(dashboardPage.welcomeMessage, 5);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");

        //2 way t verify log in successfully
        String expectedMessage="Welcome Teacher";
        extentLogger.info("Verify that login is successful from dashboard Page and message is " + expectedMessage);
        String actualMessage=dashboardPage.welcomeMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Click on Edit profile button");
        dashboardPage.navigateToMenu("Edit Profile");
        System.out.println("edit-profil page = " + driver.getCurrentUrl());
        System.out.println(driver.findElement(By.id("editprofile-heading")).getText());
       // BrowserUtils.waitForVisibility(profilePage.goBackBnt,5);
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/edit-profile");

        String expectedGithubUsername="eurotech2023"; //eurotech2023
        extentLogger.info("Verify that github username is " + expectedGithubUsername);
        BrowserUtils.waitFor(3);
        Assert.assertEquals(profilePage.getGithubusername.getAttribute("value"),expectedGithubUsername);

        extentLogger.info("Click on go back button");
        profilePage.goBackBnt.click();

        String expectedJobTitle="Teacher";//Test Automation Engineer
        extentLogger.info("Verify that user's title is " + expectedJobTitle);
        Assert.assertEquals(dashboardPage.jobTitle.getText(),expectedJobTitle);

        extentLogger.info("Passed");

    }

    @Test
    public void test2() {

        // BU TEST YUKARIDAKI TESTIMIN HATASINI BULMAK ICIN YAPTIM:
        // VE HATAM SUDUR KI, pROFILEpAGE CLASSINI YANLIS YERE EXTENDS ETMISIM:
        // BASEPAGE YERINE TESTPABE E EXTENDS YAPMISIM
        // locator bulmak icin iyi bir alistirma oldu.

        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage=new ProfilePage();

        extentLogger = report.createTest("User info verification");

        extentLogger.info("Navigate to DevEx website");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();
        extentLogger.info("Enter username");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        //1 way to verify log in successfully
        extentLogger.info("Verify that login is successful");
        //BrowserUtils.waitFor(2);
        BrowserUtils.waitForVisibility(dashboardPage.welcomeMessage, 5);
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");

        //2 way t verify log in successfully
        String expectedMessage="Welcome Teacher";
        extentLogger.info("Verify that login is successful from dashboard Page and message is " + expectedMessage);
        String actualMessage=dashboardPage.welcomeMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.info("Click on Edit profile button");
        dashboardPage.navigateToMenu("Edit Profile");
        System.out.println("edit-profil page = " + driver.getCurrentUrl());
        System.out.println(driver.findElement(By.id("editprofile-heading")).getText());
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/edit-profile");
        WebElement letsgo= driver.findElement(By.id("editprofile-intro-text"));
        System.out.println("letsgo.getText() = " + letsgo.getText());
        System.out.println("letsgo.getAttribute(\"class\") = " + letsgo.getAttribute("class"));
        WebElement requird = driver.findElement(By.xpath(" //*[text()='* = required field']"));
        System.out.println("requird.getText() = " + requird.getText());
        WebElement howmany =driver.findElement(By.xpath(" //*[text()='How many years of work experience you have?']"));
        System.out.println("howmany.getText() = " + howmany.getText());
        WebElement couldbe = driver.findElement(By.xpath(" //*[text()='Could be your own company or one you work for']"));
        System.out.println("couldbe.getText() = " + couldbe.getText());
        WebElement please = driver.findElement(By.xpath(" //*[text()='Please use comma separated values (eg. HTML,CSS,JavaScript,PHP)']"));
        System.out.println("please.getText() = " + please.getText());
        WebElement ifyouwant =driver.findElement(By.xpath(" //*[text()='If you want your latest repos and a Github link, include your username']"));
        System.out.println("ifyouwant.getText() = " + ifyouwant.getText());
        System.out.println("ifyouwant.getAttribute(\"class\") = " + ifyouwant.getAttribute("class"));
        WebElement gitgub = driver.findElement(By.xpath("//*[@placeholder='Github Username']"));
        //System.out.println("gitgub.getText() = " + gitgub.getText());
          String actualgithub=gitgub.getAttribute("value");
          String expectedgithub = "eurotech2023";
          Assert.assertEquals(actualgithub,expectedgithub);
        //profilePage.goBackBnt.click();
        driver.findElement(By.linkText("Go Back")).click();


    }
}
