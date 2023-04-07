package com.eurotech.pages;

import com.eurotech.test.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(name = "githubusername")
    public WebElement githubusername;

    @FindBy(linkText = "Go Back")
    public WebElement goBackBnt;
    @FindBy(xpath ="//input[@name='githubusername']" )
    public WebElement getGithubusername;
}
