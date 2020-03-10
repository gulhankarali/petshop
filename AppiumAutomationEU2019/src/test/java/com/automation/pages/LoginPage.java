package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.etsy.android:id/edit_username")
    public MobileElement emailElement;

    @AndroidFindBy(id = "com.etsy.android:id/edit_password")
    public MobileElement passwordElement;

    @AndroidFindBy(id = "com.etsy.android:id/button_signin")
    public MobileElement signInElement;


    public void login(){
        String email= ConfigurationReader.get("email");
        String password= ConfigurationReader.get("password");
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signInElement.click();
    }


}
