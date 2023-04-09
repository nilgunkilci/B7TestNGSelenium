package com.eurotech.test.day15_POM;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();

    // buradaki tüm testler LoginPage class daki login metedlari ile yapildi.

    @Test
    public void loginTest() {
       // As a Teacher olarak giris yap.
        // dashboard un url sini al

        driver.get(ConfigurationReader.get("url"));
        loginPage.understandBtn.click();
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("usernameTeacher"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("passwordTeacher"));
        loginPage.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void loginTestWithParameter() {
        driver.get(ConfigurationReader.get("url"));

        String username=ConfigurationReader.get("usernameTeacher");
        String password=ConfigurationReader.get("passwordTeacher");

        // yukaridaki testi  parametreli login metod ile yapiyoruz
        loginPage.login(username,password);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void loginAsTeacher() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.login();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void loginAsStudent() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsStudent();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }

    @Test
    public void loginAsDeveloper() {
        driver.get(ConfigurationReader.get("url"));
        loginPage.loginAsDeveloper();
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.dashboardText));
        Assert.assertEquals(driver.getCurrentUrl(), "http://eurotech.study/dashboard");
    }


}
