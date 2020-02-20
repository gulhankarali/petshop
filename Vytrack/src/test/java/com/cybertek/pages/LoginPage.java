package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    // makes or among the locators
    @FindAll({
            @FindBy(id="prependedInput"),
            @FindBy(xpath = "_username")
    })
    public WebElement username2;

    //makes and among the locators
    @FindBys({
            @FindBy(id="prependedInput"),
            @FindBy(xpath = "_username")
    })
    public WebElement username3;


    @FindBy(id="prependedInput")
    public WebElement usernameInput;

    @FindBy(id= "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id ="_submit")
    public WebElement  loginBtn;

    public void login(String username1, String password1){
        usernameInput.sendKeys(username1);
        passwordInput.sendKeys(password1);
        loginBtn.click();
    }

}
