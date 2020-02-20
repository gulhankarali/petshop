
package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy (css= "a.btn-success.btn.dropdown-toggle")
    public WebElement saveAndClose;

    @FindBy (css= "button.action-button.dropdown-item")
    public WebElement saveAndCloseButton;

    @FindBy (xpath= "(//button[@class='main-group action-button dropdown-item'])[1]")
    public WebElement saveAndNewButton;

    @FindBy (xpath= "(//button[@class='main-group action-button dropdown-item'])[2]")
    public WebElement saveButton;

    @FindBy (xpath= "//a[@title='Cancel']")
    public WebElement cancelButton;

    @FindBy (xpath="//input[@class='input-small timepicker-input start ui-timepicker-input']")
    public WebElement firstHour;

    @FindBy (xpath="//input[@class='input-small timepicker-input end ui-timepicker-input']")
    public WebElement secondHour;

    @FindBy (xpath= "(//li[@class='ui-timepicker-pm'])[19]")
    public WebElement dropDown;

    @FindBy( name = "oro_calendar_event_form[allDay]")
    public WebElement allDayEvent;

    @FindBy (xpath = "//input[@class='input-small datepicker-input start hasDatepicker']")
    public WebElement starttDate;

    @FindBy(xpath="//span[text()='Daily every 1 day']")
    public WebElement summary;

    public Select repeatOptionsList(){
        return new Select(repeatOptions);
    }

}