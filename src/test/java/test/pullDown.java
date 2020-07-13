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

public class pullDown extends base {

    AndroidDriver<AndroidElement> driver= capabilities();

    public pullDown() throws MalformedURLException {
    }
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById(login()).click();
        driver.findElementById(getPermission()).click();
    }

    @Test(description = "verify PullDown", alwaysRun = true, priority = 1)
    public void selectPullDown() {

        driver.findElementByAndroidUIAutomator(btnPullDown()).click();
        driver.findElementByClassName(dropDown()).click();
        driver.findElementByAndroidUIAutomator(btnOption()).click();
        driver.findElementByAndroidUIAutomator(btnSubmit()).click();
        String value=driver.findElementByAndroidUIAutomator(btnOption()).getText();
        softAssert.assertEquals(value,dataProvider.option());
        driver.findElementByAndroidUIAutomator(backToTop()).click();
        boolean markdown=driver.findElementByAndroidUIAutomator(markdown()).isDisplayed();
        softAssert.assertTrue(markdown);
        softAssert.assertAll();


    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }
}
