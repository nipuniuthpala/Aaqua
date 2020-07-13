package test;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import static io.appium.java_client.touch.offset.ElementOption.element;

public class markdown extends base {
      AndroidDriver driver= capabilities();

      public markdown() throws MalformedURLException {
       }
        SoftAssert softAssert = new SoftAssert();
        TouchAction y =new TouchAction(driver);

        @BeforeClass(description = "Load the Device", alwaysRun = true)
        public void Login () {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElementById(login()).click();
            driver.findElementById(getPermission()).click();

        }

         @Test(description = "verify select Markdown and check link", alwaysRun = true, priority = 1)
         public void selectMarkDownAndClickOnLink() {

            WebElement expandList=	 driver.findElementByAndroidUIAutomator(markdown());
             y.tap(tapOptions().withElement(element(expandList))).perform();
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
             y.press( 1089, 728).moveTo( 1032, 2059).release().perform();
             y.tap( 325, 769).perform();
             boolean web=driver.findElementByAndroidUIAutomator(fashionText()).isDisplayed();
             softAssert.assertTrue(web);
             driver.pressKeyCode(AndroidKeyCode.BACK);
             softAssert.assertAll();

         }

     @Test(description = "verify select Markdown and verify Image", alwaysRun = true, priority = 2)
         public void selectMarkDownAndVerifyOnImage() {
            y.press( 1306,  2152).moveTo( 1270, 1265).release().perform();
            driver.findElementByAndroidUIAutomator(getImageText());
            boolean image=driver.findElementByAndroidUIAutomator(imageText()).isDisplayed();
            softAssert.assertTrue(image);
            y.press( 1151, 2080).moveTo( 1172,625).release().perform();
            y.press( 1146,  2182).moveTo(  1256, 530).release().perform();
            driver.findElementByAndroidUIAutomator(btnBackToTop());
            softAssert.assertAll();
        }

    @Test(description = "verify click back to the top", alwaysRun = true, priority = 3)
    public void clickBackToTheTop() {

        driver.findElementByAndroidUIAutomator(btnBackToTop()).click();
        boolean markdown=driver.findElementByAndroidUIAutomator(markdown()).isDisplayed();
        softAssert.assertTrue(markdown);
        y.press( 1337,  485).moveTo(  1306, 1425).release().perform();
        boolean back=driver.findElementByAndroidUIAutomator(txtBackToTop()).isDisplayed();
        softAssert.assertTrue(back);
        boolean BACK=driver.findElementByAndroidUIAutomator(txtBtnBackToTop()).isEnabled();
        softAssert.assertFalse(BACK);
        softAssert.assertAll();
    }

    @Test(description = "verify type top command and verify the list", alwaysRun = true, priority = 4)
    public void typeTopCommand() {

        driver.findElementById(textArea()).sendKeys("top");
        driver.findElementById(btnEnter()).click();
        boolean markdown=driver.findElementByAndroidUIAutomator(markdown()).isDisplayed();
        softAssert.assertTrue(markdown);
        softAssert.assertAll();
    }

    @Test(description = "verify minimize the app and maximizes the app shows previous text is disabled", alwaysRun = true, priority = 5)
    public void minimizeMaximize() {

        driver.findElementById(btnMinimize()).click();
        driver.findElementById(login()).click();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        y.press( 1306,  516).moveTo(  1300, 1120).release().perform();
        boolean login=driver.findElementByAndroidUIAutomator(btnLogin()).isEnabled();
        softAssert.assertTrue(login);
        softAssert.assertAll();

    }

    @Test(description = "verify close the app and opens the app", alwaysRun = true, priority = 6)
    public void closeApp() {

        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean Markdown=driver.findElementByAndroidUIAutomator(markdown()).isEnabled();
        softAssert.assertTrue(Markdown);
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
            driver.quit();
    }

}
