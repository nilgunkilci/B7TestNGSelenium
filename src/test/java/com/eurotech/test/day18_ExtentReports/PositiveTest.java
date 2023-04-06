package com.eurotech.test.day18_ExtentReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {
    // login as a Teacher with method


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Login Test");
        extentLogger.info("Navigate to url");
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
    }
}
