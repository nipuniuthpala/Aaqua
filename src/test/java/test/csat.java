package test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base;
import dataProvider.dataProvider;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class csat extends base {
    AndroidDriver<AndroidElement> driver= capabilities();

    public csat() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();
    }

    @Test(description = "verify csat", alwaysRun = true, priority = 1)
    public void selectCSAT() {

        driver.findElementByAndroidUIAutomator(btnCSAT()).click();
        String value=driver.findElementByAndroidUIAutomator(btnCSAT()).getText();
        softAssert.assertEquals(value,dataProvider.CSAT());
        softAssert.assertAll();


    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
