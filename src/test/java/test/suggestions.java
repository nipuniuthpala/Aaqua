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

public class suggestions extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public suggestions() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();
    }

    @Test(description = "verify suggestions", alwaysRun = true, priority = 1)
    public void verifySuggestions() {
        driver.findElementById(textArea()).sendKeys(dataProvider.input());
        driver.findElementById(btnSuggestion()).click();
        driver.findElementById(btnEnter()).click();
        String text=  driver.findElementByAndroidUIAutomator(txtSuggestion()).getText();
        softAssert.assertEquals(text,dataProvider.outputTxt());
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }

}
