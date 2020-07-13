package test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class video extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public video() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();
    }

    @Test(description = "verify select video ", alwaysRun = true, priority = 1)
    public void selectVideo() {

        driver.findElementByAndroidUIAutomator(btnVideo()).click();
        boolean video=driver.findElementByClassName(viewVideo()).isDisplayed();
        softAssert.assertTrue(video);
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
