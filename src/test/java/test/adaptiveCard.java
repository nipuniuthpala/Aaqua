package test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base;
import dataProvider.dataProvider;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class adaptiveCard extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public adaptiveCard() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();

    }

    @Test(description = "verify adaptiveCard", alwaysRun = true, priority = 1)
    public void selectAdaptiveCard() {

        driver.findElementByAndroidUIAutomator(btnAdaptiveCard()).click();
        driver.findElementByClassName(dropDown()).click();
        driver.findElementByAndroidUIAutomator(txtDropDown()).click();
        driver.findElementByAndroidUIAutomator(value()).click();
        driver.pressKeyCode(AndroidKeyCode.DEL);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
        driver.findElementByAndroidUIAutomator(btnCalculate()).click();
        String value=driver.findElementByAndroidUIAutomator( valueText()).getText();
        softAssert.assertEquals(value,dataProvider.card_Value());
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
