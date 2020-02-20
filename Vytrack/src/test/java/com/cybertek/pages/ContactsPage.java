package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ContactsPage extends BasePage {

    //if you are trying to come up with dynamic xpath, you cannot reach with findby

    //@FindBy(xpath= "//*[@data-column-label='Email'][contains(text(),'mbrackstone9@example.com')]")
    //public WebElement email;

    public WebElement getContactEmail(String email){

        String emailXpath= "//*[@data-column-label='Email'][contains(text(),'"+email+"')]";
        return Driver.get().findElement(By.xpath(emailXpath));

    }
}
