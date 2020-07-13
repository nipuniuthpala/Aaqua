package test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;



public class carousal extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public carousal() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();
    TouchAction y =new TouchAction(driver);

    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();

    }

    @Test(description = "verify select carousal and check link", alwaysRun = true, priority = 1)
    public void selectCarousal() {

        driver.findElementByAndroidUIAutomator(btnCarousal()).click();
        driver.findElementByAndroidUIAutomator(btnMoreDetails()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        y.press( 1249, 1388).moveTo( 305, 1399).release().perform();
        driver.findElementByAndroidUIAutomator(btnMoreDetails()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator(btnReserve()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        softAssert.assertAll();

    }


    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
