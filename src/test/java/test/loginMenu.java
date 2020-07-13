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

public class loginMenu extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public loginMenu() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();
    }

    @Test(description = "verify login", alwaysRun = true, priority = 1)
    public void verifyLogin() {

        driver.findElementByAndroidUIAutomator(btnLogin()).click();
        driver.findElementByAndroidUIAutomator(btnRIDLogin()).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath(username()).click();
        driver.findElementByXPath(username()).sendKeys(dataProvider.email());
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByXPath(password()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByXPath(password()).sendKeys(dataProvider.password());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElementByXPath(webLogin()).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String text3=driver.findElementById(popUp()).getText();
        softAssert.assertEquals(text3,dataProvider.msgWelcome());
        driver.findElementById(hamburgMenu()).click();
        boolean logout1=driver.findElementByXPath(txtLogOut()).isEnabled();
        softAssert.assertTrue(logout1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath(txtLogOut()).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String logout=driver.findElementById(popUp()).getText();
        softAssert.assertEquals(logout,dataProvider.msgLogOut());
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }

}
