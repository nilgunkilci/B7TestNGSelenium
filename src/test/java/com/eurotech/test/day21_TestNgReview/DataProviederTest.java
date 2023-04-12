package com.eurotech.test.day21_TestNgReview;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviederTest extends TestBase {
    DashboardPage dashboardPage  ;
    /** Class Task
     * create four test data with Dev-Ex user credentials by using DataProvider
     * and execute this data set with extendReports
     * jackbauer@gmail.com  Admin123
     * eurotech@gmail.com   Test12345!
     * EurotechB4@gmail.com Test1234
     *  your personal user
     */

    @DataProvider
    public Object[][] login() {
        String[][] data = {
                {"jackbauer@gmail.com ", "Admin123"},
                {"eurotech@gmail.com", "Test12345!"},
                {"EurotechB4@gmail.com", "Test1234"},
                {"glgn_feyman2@gmail.com","glgnfymn"}


        };
        return data;
    }

    @Test(dataProvider= "login")
    public void  testTvShows(String username,String password) {
        dashboardPage =new DashboardPage();
        System.out.println("username= " + username + ",   passworde= " + password);
        LoginPage loginPage =new LoginPage();
        extentLogger = report.createTest(username+"'s Login Test");
        extentLogger.info("Click understand button");
        loginPage.understandBtn.click();
        extentLogger.info("Enter UserEmail");
        loginPage.usernameInput.sendKeys(username);
        extentLogger.info("Enter password");
        loginPage.passwordInput.sendKeys(password);
        extentLogger.info("Click submit button");
        loginPage.loginBtn.click();
        String expectedPage = "Dashboard";
        BrowserUtils.waitForVisibility(dashboardPage.dashboardText,5);
        String actualPage = dashboardPage.dashboardText.getText();
        Assert.assertEquals(actualPage,expectedPage);
    }
}
