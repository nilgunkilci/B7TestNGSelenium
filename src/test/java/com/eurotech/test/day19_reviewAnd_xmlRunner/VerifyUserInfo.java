package com.eurotech.test.day19_reviewAnd_xmlRunner;

import com.eurotech.pages.LoginPage;
import com.eurotech.test.TestBase;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /** Class Task
     *  Login as a teacher
     *  Verify that login is successful
     *  click on Edit profile button
     *  Verify that github username is eurotech2022
     *  Click on go back button
     *  Verify that user's title is Director
     */

    @Test
    public void userInfo(){
        LoginPage loginPage= new LoginPage();
        extentLogger = report.createTest("User info verification");
        extentLogger.info("Navigate to DevEx website");





    }





}
