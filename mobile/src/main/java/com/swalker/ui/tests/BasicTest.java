package com.swalker.ui.tests;

import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicTest {

    private IOSDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
//Setting Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "14.2");
        capabilities.setCapability("deviceName", "iPhone 11");
        capabilities.setCapability("identifier", "4AE4B386-C46B-4586-A135-9EF847EC2243");
        capabilities.setCapability("app", "/Users/dk670466/Library/Developer/Xcode/DerivedData/SmoothWalker-ddzyfedayoteqzgbwxelddttnzwg/Build/Products/Debug-iphonesimulator/SmoothWalker.app");
        capabilities.setCapability("xcodeSigningId", "daman_811@yahoo.com");

        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.removeApp("ccom.example-samplecode.SmoothWalker");
            driver.quit();
        }
    }

    @Test
    public void basicTest() throws InterruptedException {
        driver.launchApp();
    }

    @Test
    public void testHealthAccessPermission() {
        driver.findElementByAccessibilityId("More").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Don't Allow").isDisplayed(),
                "Health Access Permission has been selected");
    }


}
