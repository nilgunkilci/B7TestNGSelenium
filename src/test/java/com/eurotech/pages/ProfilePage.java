package com.eurotech.pages;

import com.eurotech.test.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends TestBase {

    @FindBy( id = "editprofile-from-github-input")
    public WebElement githubusername;

    @FindBy(linkText = "Go Back")
    public WebElement goBackBnt;
}
