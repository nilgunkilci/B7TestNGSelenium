package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(id = "dashboard-h1")
    public WebElement dashboardText;

    @FindBy(xpath = "//p[contains(text(),'Welcome')]")
    public WebElement welcomeMessage;
}
