package com.automation.tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;


public class CalculatorTests {
    private AndroidDriver<WebElement> driver;

    @Test
    public void test() throws InterruptedException, MalformedURLException {

        DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2_AP_24");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator" );
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        WebElement plus=driver.findElement(MobileBy.AccessibilityId("plus"));
        WebElement minus=driver.findElement(MobileBy.AccessibilityId("minus"));
        WebElement equals=driver.findElement(MobileBy.AccessibilityId("equals"));
        WebElement multiply=driver.findElement(MobileBy.AccessibilityId("multiply"));
        WebElement divide=driver.findElement(MobileBy.AccessibilityId("divide"));
        WebElement delete=driver.findElement(MobileBy.AccessibilityId("delete"));

        WebElement result = driver.findElementById("com.android.calculator2:id/result");

        WebElement digit1= getDigit(1);
        WebElement digit2= getDigit(2);
        WebElement digit3= getDigit(3);
        WebElement digit4= getDigit(4);
        WebElement digit5= getDigit(5);
        WebElement digit6= getDigit(6);
        WebElement digit7= getDigit(7);
        WebElement digit8= getDigit(8);
        WebElement digit9= getDigit(9);
        WebElement digit0= getDigit(0);

        digit1.click();
        plus.click();
        digit4.click();
        equals.click();

        Assert.assertEquals("5",result.getText());

        getDigit(5).click();
        plus.click();
        getDigit(6).click();

        boolean actualFormulaVisibilityStatus = Boolean.parseBoolean(driver.findElementById("com.android.calculator2:id/formula").getAttribute("displayed"));

        Assert.assertTrue("Formula is not visible!", actualFormulaVisibilityStatus);

        Assert.assertTrue("Result is not visible!", driver.findElementById("com.android.calculator2:id/result").isDisplayed());

        System.out.println(driver.findElementById("com.android.calculator2:id/formula").getAttribute("displayed"));


        Thread.sleep(3000);
        driver.closeApp();
    }

    public WebElement getDigit(int digit){
        return driver.findElement(By.id("com.android.calculator2:id/digit_"+ digit));
    }
}
