package com.eurotech.test.day16_POM2;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBoardTest extends TestBase {

    LoginPage loginPage= new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void dashboardMenu() {
        /** Class Task
         *  Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Get the text of the welcome message
         *  Then verify following menu
         *                      Developers
         *                       All Posts
         *                       My Account
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        String expectedText= "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in is successful");
        //1st way
//        List<WebElement> dashboardMenu= dashboardPage.menuList;
//        for (WebElement menu : dashboardMenu) {
//            System.out.println("menu.getText() = " + menu.getText());
//        }

        //2nd way
        for (WebElement menu : dashboardPage.menuList) {
            System.out.println("menu.getText() = " + menu.getText());
            Assert.assertTrue(menu.isDisplayed());
        }
    }

    @Test
    public void navigateMenu() {
        /** Class Task
         *  Go to http://eurotech.study/login
         *  Login with teacher credentials
         *  Navigate to All Posts menu and verify url is http://eurotech.study/posts
         *  Navigate to Developers menu and verify url is http://eurotech.study/profiles
         */
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        String expectedText= "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in is successful");
        dashboardPage.allPost.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");
        dashboardPage.developers.click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
    }

    @Test
    public void navigateMenu2() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        String expectedText= "Welcome Teacher";
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(),expectedText,"Verify that log in is successful");
        dashboardPage.navigateToMenu("All Posts");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/posts");
        dashboardPage.navigateToMenu("Developers");
        Assert.assertEquals(driver.getCurrentUrl(),"http://eurotech.study/profiles");
    }
}
