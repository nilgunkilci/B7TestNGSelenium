package com.eurotech.test.day21_TestNgReview;

import com.eurotech.pages_swagLabs.LoginPage_Swag;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest extends TestBase{



    @DataProvider
    public Object [][] userData(){
        ExcelUtil testData = new ExcelUtil("src/test/resources/SwagLab.xlsx","Credentials");
        return testData.getDataArrayWithoutFirstRow();
    }
    @Test(dataProvider = "userData")
    public void testLogin(String Username,String Password, String Page) {
        LoginPage_Swag pagesSwagLabs = new LoginPage_Swag();
        driver.get("https://www.saucedemo.com/");

        extentLogger = report.createTest(Username+"'s Login Test");
        pagesSwagLabs.usernameInput.sendKeys(Username);
        pagesSwagLabs.passwordInput.sendKeys(Password);
        pagesSwagLabs.loginBtn.click();

    }
}
