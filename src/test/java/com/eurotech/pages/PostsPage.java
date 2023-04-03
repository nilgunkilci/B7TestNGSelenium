package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostsPage extends BasePage {
    @FindBy(id = "post-form-btn")
    public WebElement submitButton;


}
