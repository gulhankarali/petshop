package com.automation.tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudTesting {

    public static String userName = "feradje1";
    public static String accessKey = "gwRzUxPe7HC7ZPjep9gb";
    public static String URL ="https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
    public static String email="gulhankarali@hotmail.com";
    public static String password="gulhan1234";
    private AppiumDriver driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability("device", "Google Pixel 3 XL");
        desiredCapabilities.setCapability("os_version", "9.0");
        desiredCapabilities.setCapability("project", "Etsy");
        desiredCapabilities.setCapability("build", "My First Build");
        desiredCapabilities.setCapability("name", "Etsy Test");
        desiredCapabilities.setCapability("app", "bs://bf1f6a80c5020a9bcb88e066035bfe00e66f11bb");
        driver= new AndroidDriver(new URL(URL), desiredCapabilities);

        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.etsy.android:id/btn_link")));
        WebElement getStarted = driver.findElement(By.id("com.etsy.android:id/btn_link"));
        getStarted.click();

        WebElement usernameElement = driver.findElementById("com.etsy.android:id/edit_username");

        WebElement passwordElement = driver.findElementById("com.etsy.android:id/edit_password");

        WebElement signinElement = driver.findElementById("com.etsy.android:id/button_signin");

        usernameElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signinElement.click();

        Thread.sleep(5000);
        driver.closeApp();
        driver.quit();

    }

}
