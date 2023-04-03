package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "rcc-confirm-button")
    public WebElement understandBtn;
    @FindBy(className = "nav__menu-item")
    public List<WebElement> menuList;

    @FindBy(xpath = "//a[text()='Developers']")
    public WebElement developers;
    @FindBy(xpath = "//a[text()='All Posts']")
    public WebElement allPost;
    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccount;

    public void navigateToMenu(String menuName){
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }
    public void navigateToSubmenu(String name){
        Driver.get().findElement(By.xpath(" //span[text() ='"+name+"']")).click();
    }

}
