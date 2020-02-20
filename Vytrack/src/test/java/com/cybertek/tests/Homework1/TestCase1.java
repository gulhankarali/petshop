package com.cybertek.tests.Homework1;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1 extends TestBase {

    @Test
    public void Test1() {

        extentLogger=report.createTest("Test Case 1");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Options is displayed");
        Assert.assertTrue(calendarEventsPage.options.isDisplayed());

    }

    @Test
    public void Test2(){

        extentLogger=report.createTest("Test Case 2");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that number displayed is 1");
        Assert.assertEquals(calendarEventsPage.firstNumber.getAttribute("value"), "2", "verify that 1 is displayed");

    }


    @Test
    public void Test3(){
        extentLogger=report.createTest("Test Case 3");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that view per page is 25");
        Assert.assertEquals(calendarEventsPage.viewPerPage.getText(),"25","verify that number is 25");
    }

    @Test
    public void Test4(){
        extentLogger=report.createTest("Test Case 4");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that number of rows in the table equals to the one in the label");
        String[] array= calendarEventsPage.label.getText().split(" ");
        int actualSize= Integer.parseInt(array[2].trim());
        int expectedSize= calendarEventsPage.getRowSizeOfTable();
        Assert.assertEquals(actualSize, expectedSize, "Verify that numbers are equal");

    }
    @Test
    public void Test5(){
        extentLogger=report.createTest("Test Case 5");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on the top checkbox to select all");
        calendarEventsPage.checkbox1.click();

        extentLogger.info("Verify that all calendar events are selected");
        Assert.assertTrue(calendarEventsPage.allChecked(), "Verify that all is checked");

    }

    @Test
    public void Test6(){
        extentLogger=report.createTest("Test Case 6");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on the 'Testers Meeting' link and verify the table");
        List<WebElement> STable= calendarEventsPage.verification("Testers meeting");
        Assert.assertTrue(STable.get(0).getText().equals("Testers meeting"));
        Assert.assertTrue(STable.get(1).getText().equals("This is a a weekly testers meeting"));
        Assert.assertTrue(STable.get(2).getText().equals("Dec 8, 2019, 11:20 AM"));
        Assert.assertTrue(STable.get(3).getText().equals("Dec 8, 2019, 12:20 PM"));
        Assert.assertTrue(STable.get(4).getText().equals("No"));
        Assert.assertTrue(STable.get(5).getText().equals("Stephan Haley"));
        Assert.assertTrue(STable.get(6).getText().equals("Tom Smith - Required"));
    }

    @Test
    public void Test7(){
        extentLogger=report.createTest("Test Case 1");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on the 3 dots link");
        calendarEventsPage.testersMeetingLink("Testers meeting");

        extentLogger.info("Verify that view, edit and delete options are available");


        WebElement link = calendarEventsPage.testersMeetingLink("Testers meeting");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].click();", link);

        extentLogger.info("Verifty that view, edit and delete displayed");
        Assert.assertTrue(calendarEventsPage.delete.isDisplayed());
        Assert.assertTrue(calendarEventsPage.edit.isDisplayed());
        Assert.assertTrue(calendarEventsPage.view.isDisplayed());


    }
    @Test
    public void Test8() throws InterruptedException {
        extentLogger=report.createTest("Test Case 2");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that On the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();


        extentLogger.info("Click the grid button");

        calendarEventsPage.gridButton.click();

      //  BrowserUtils.waitFor(5);

        calendarEventsPage.uncheck();

      //  BrowserUtils.waitForStaleElement(rowsOfTable.get(0));

        Assert.assertTrue(calendarEventsPage.Title.isDisplayed(),"Verify that Title coloumn is displayed");
    }

    @Test
    public void Test9(){
        extentLogger=report.createTest("Test Case 3");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Save and Close is expanded");
        createCalendarEventsPage.saveAndClose.click();

        extentLogger.info("Verify that Save and Close Button is displayed");
        Assert.assertTrue(createCalendarEventsPage.saveAndCloseButton.isDisplayed());

        extentLogger.info("Verify that Save and New Button is displayed");
        Assert.assertTrue(createCalendarEventsPage.saveAndNewButton.isDisplayed());

        extentLogger.info("Verify that Save Button is displayed");
        Assert.assertTrue(createCalendarEventsPage.saveButton.isDisplayed());


    }
    @Test
    public void Test10(){
        extentLogger=report.createTest("Test Case 4 ");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Cancel button is clickable");
        createCalendarEventsPage.cancelButton.click();

        extentLogger.info("Verify that All Calendar Events subtitle is displayed");
        Assert.assertTrue(calendarEventsPage.subTitle.isDisplayed());

    }

    @Test
    public void Test11(){
        extentLogger=report.createTest("Test Case 5");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that we get the value attribute of the fields");
        String FHString= createCalendarEventsPage.firstHour.getAttribute("value");
        String SHString=createCalendarEventsPage.secondHour.getAttribute("value");

        String[] FHArray= FHString.split(":");
        String[] SHArray= SHString.split(":");

        int FH=Integer.parseInt(FHArray[0]);
        int SH=Integer.parseInt(SHArray[0]);

        extentLogger.info("Verify that there is one hour difference between the hours");
        Assert.assertEquals(SH-FH, 1, "Verify that difference between the hours is one");

    }

    @Test
    public void Test12(){
        extentLogger=report.createTest("Test Case 6");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that we get 9:00 PM on the screen");

        createCalendarEventsPage.firstHour.click();
        createCalendarEventsPage.dropDown.click();

        extentLogger.info("Verify that next hour is 10:00 PM");
        String SHString=createCalendarEventsPage.secondHour.getAttribute("value");
        Assert.assertEquals("10:00 PM", SHString, "Verify that next hour is 10:00 PM");
    }

    @Test
    public void Test13() throws InterruptedException {
        extentLogger=report.createTest("Test Case 7");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that All Day Event is checked");
        createCalendarEventsPage.allDayEvent.click();

        extentLogger.info("Verify that All Day Event is displayed");
        Assert.assertTrue(createCalendarEventsPage.allDayEvent.isSelected());

        Thread.sleep(1000);

        extentLogger.info("Verify that Start Date is displayed");
        Assert.assertTrue(createCalendarEventsPage.startDate.isDisplayed());

        extentLogger.info("Verify that End Date is displayed");
        Assert.assertTrue(createCalendarEventsPage.endDate.isDisplayed());

        extentLogger.info("Verify that Start Hour is not displayed");
        Assert.assertFalse(createCalendarEventsPage.firstHour.isDisplayed());

        extentLogger.info("Verify that End Hour is not displayed");
        Assert.assertFalse(createCalendarEventsPage.secondHour.isDisplayed());

    }

    @Test
    public void Test14(){
        extentLogger=report.createTest("Test Case 8");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Repeat is checked");
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());

        extentLogger.info("Verify that the repeat option is clicked");
        createCalendarEventsPage.repeatOptions.click();

        extentLogger.info("Verify that first option selected is Daily");
        Assert.assertEquals(createCalendarEventsPage.repeatOptionsList().getFirstSelectedOption().getText(),"Daily","Verify that the first seleceted is Daily");

        extentLogger.info("Verify that all the options are displayed as usual");

        Assert.assertEquals(createCalendarEventsPage.repeatOptionsList().getOptions().get(1).getText(), "Weekly");
        Assert.assertEquals(createCalendarEventsPage.repeatOptionsList().getOptions().get(2).getText(), "Monthly");
        Assert.assertEquals(createCalendarEventsPage.repeatOptionsList().getOptions().get(3).getText(), "Yearly");


    }

    @Test
    public void Test15(){
        extentLogger=report.createTest("Test Case 9");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Repeat is checked");
        createCalendarEventsPage.repeat.click();

        extentLogger.info("Verify that repeat option is selected and displayed");
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());

        extentLogger.info("Verify that Repeat Every Day radio button is selected");
        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

        extentLogger.info("Verify that Ends Never radio button is selected");
        Assert.assertTrue(createCalendarEventsPage.never.isSelected());

        extentLogger.info("Verify that summary is displayed as such");
        Assert.assertEquals(createCalendarEventsPage.summary.getText(), "Daily every 1 day");
    }

    @Test
    public void Test16(){
        extentLogger=report.createTest("Test Case 10");
        LoginPage loginPage= new LoginPage();
        String username= ConfigurationReader.get("storemanager_username");
        String password= ConfigurationReader.get("storemanager_password");

        extentLogger.info("username "+username);
        extentLogger.info("password "+password);
        loginPage.login(username, password);

        extentLogger.info("Verifty that on the dashboard Click on Activites and navigate to Calendar Events");
        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that Calendar Events Page is opened");
        CalendarEventsPage calendarEventsPage= new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Verify that Create Calender Event button is clicked");
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage= new CreateCalendarEventsPage();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

    }

}
