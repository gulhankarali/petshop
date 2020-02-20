package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage<Webelement> extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css="div.btn-group.actions-group")
    public WebElement options;

    @FindBy(css= "input.input-widget")
    public WebElement firstNumber;

    @FindBy(css="button.btn.dropdown-toggle")
    public WebElement viewPerPage;

    @FindBy(xpath="//label[contains(text(),'Total')]")
    public WebElement label;

    @FindBy(css="button.btn.btn-default.btn-small.dropdown-toggle>input")
    public WebElement checkbox1;

    @FindBy(css= "i.fa-cog.hide-text")
    public WebElement gridButton;

    @FindBy(xpath = "//a[@href='/calendar/event/update/273']/../..//li[3]/a")
    public WebElement delete;

    @FindBy(xpath = "//a[@href='/calendar/event/view/273']")
    public WebElement view;

    @FindBy(xpath = "//a[@href='/calendar/event/update/273']")
    public WebElement edit;

    @FindBy(xpath = "(//span[@class = 'grid-header-cell__label'])[1]")
    public WebElement Title;

    @FindBy (css= "h1.oro-subtitle")
    public WebElement subTitle;

    public int getRowSizeOfTable(){

        String tableRowSizeXpath= "//table/tbody/tr";
        List<WebElement> rows= Driver.get().findElements(By.xpath(tableRowSizeXpath));
        return rows.size();
    }

    public void uncheck(){

        List<WebElement> rowsOfTable= Driver.get().findElements(By.xpath("//tr//td[3]"));
        int l= rowsOfTable.size();
        for (int i =1; i<l; i++) {
            rowsOfTable.get(i).click();
        }
    }

    public boolean allChecked(){

        boolean checked= false;

        List<WebElement> rowsOfFirstColumn= Driver.get().findElements(By.xpath("//table/tbody/tr/td[1]/input"));

        for (WebElement r: rowsOfFirstColumn) {
            if(r.isSelected()) {
                checked = true;
            }
        }
        return checked;
    }

    public List<WebElement> verification(String message){

        List<WebElement> smallTable = null;

        List<WebElement> liste= Driver.get().findElements(By.xpath("//table/tbody/tr/td[2]"));
        for (WebElement l: liste){
            if (l.getText().equals(message)) {
                l.click();
                smallTable= Driver.get().findElements(By.cssSelector("div.control-label"));
                break;
            }
        }
        return smallTable;
    }

    public WebElement testersMeetingLink(String message){
        WebElement link = null;
        int i=-1;
        List<WebElement> liste= Driver.get().findElements(By.xpath("//table/tbody/tr/td[2]"));
        for (WebElement l: liste){

            if (l.getText().equals(message)) {
                break;
            }
            i=i+1;
        }
        link= Driver.get().findElement(By.xpath("//table/tbody/tr["+i+"]/td[9]"));
        return link;
    }
}
