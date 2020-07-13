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

public class inputDisable extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public inputDisable() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();
    }

    @Test(description = "verify inputDisable", alwaysRun = true, priority = 1)
    public void selectInputDisable() {

        driver.findElementByAndroidUIAutomator(btnInputDisable()).click();
        boolean text=driver.findElementById(textArea()).isEnabled();
        softAssert.assertFalse(text);
        driver.findElementById(btnMinimize()).click();
        driver.findElementById(login()).click();
        boolean text1=driver.findElementById(textArea()).isEnabled();
        softAssert.assertFalse(text1);
        String text3=driver.findElementByAndroidUIAutomator(txtInputDisable()).getText();
        softAssert.assertEquals(text3,dataProvider.inputText());
        softAssert.assertAll();

    }
    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }

    }
