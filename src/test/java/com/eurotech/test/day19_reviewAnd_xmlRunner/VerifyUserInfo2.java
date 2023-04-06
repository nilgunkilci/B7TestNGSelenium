package com.eurotech.test.day19_reviewAnd_xmlRunner;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.ProfilePage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
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
        ProfilePage profilePage = new ProfilePage();

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
        String expectedMessage = "Welcome Teacher";
        extentLogger.info("Verify that login is successful from dashboard Page and message is " + expectedMessage);
        String actualMessage = dashboardPage.welcomeMessage.getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

        extentLogger.info("Click on Edit profile button");
        dashboardPage.navigateToMenu("Edit Profile");

        String expectedGithubUsername="eurotech2023";
        extentLogger.info("Verify that github username is " + expectedGithubUsername);
        Assert.assertEquals(profilePage.githubusername.getAttribute("value"),expectedGithubUsername);

        extentLogger.info("Click on go back button");
        profilePage.goBackBnt.click();

        String expectedJobTitle = "Test Automation Engineer";
        extentLogger.info("Verify that user's title is " + expectedJobTitle);
        String actuelJobTitle = dashboardPage.jobTitle.getText();
        System.out.println("expectedJobTitle = " + expectedJobTitle);
        System.out.println("actuelJobTitle = " + actuelJobTitle);
        Assert.assertEquals(actuelJobTitle, expectedJobTitle);

        extentLogger.info("Passed");

    }


}
