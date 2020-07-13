package test;

import static io.appium.java_client.touch.TapOptions.tapOptions;

import dataProvider.dataProvider;
import io.appium.java_client.TouchAction;
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

public class regression  extends base{

    AndroidDriver driver= capabilities();

    public regression() throws MalformedURLException {
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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        boolean login=driver.findElementByAndroidUIAutomator(btnLogin()).isEnabled();
        softAssert.assertTrue(login);
        softAssert.assertAll();

    }

    @Test(description = "verify close the app and opens the app", alwaysRun = true, priority = 6)
    public void closeApp() {

        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean Markdown=driver.findElementByAndroidUIAutomator(markdown()).isEnabled();
        softAssert.assertTrue(Markdown);
        softAssert.assertAll();

    }

    @Test(description = "verify adaptiveCard", alwaysRun = true, priority = 7)
    public void selectAdaptiveCard() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnAdaptiveCard()).click();
        driver.findElementByClassName(dropDown()).click();
        driver.findElementByAndroidUIAutomator(txtDropDown()).click();
        driver.findElementByAndroidUIAutomator(value()).click();
        driver.pressKeyCode(AndroidKeyCode.DEL);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
        driver.findElementByAndroidUIAutomator(btnCalculate()).click();
        String value=driver.findElementByAndroidUIAutomator( valueText()).getText();
        softAssert.assertEquals(value, dataProvider.card_Value());
        softAssert.assertAll();

    }

    @Test(description = "verify select carousal and check link", alwaysRun = true, priority = 8)
    public void selectCarousal() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnCarousal()).click();
        driver.findElementByAndroidUIAutomator(btnMoreDetails()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        y.press( 1249, 1388).moveTo( 305, 1399).release().perform();
        driver.findElementByAndroidUIAutomator(btnMoreDetails()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator(btnReserve()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        softAssert.assertAll();

    }


    @Test(description = "verify csat", alwaysRun = true, priority = 9)
    public void selectCSAT() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnCSAT()).click();
        String value=driver.findElementByAndroidUIAutomator(btnCSAT()).getText();
        softAssert.assertEquals(value,dataProvider.CSAT());
        softAssert.assertAll();


    }

    @Test(description = "verify image", alwaysRun = true, priority = 10)
    public void selectImage() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnImage()).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean image=driver.findElementByClassName(viewImage()).isDisplayed();
        softAssert.assertTrue(image);
        softAssert.assertAll();

    }

    @Test(description = "verify inputDisable", alwaysRun = true, priority = 11)
    public void selectInputDisable() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnInputDisable()).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean text=driver.findElementById(textArea()).isEnabled();
        softAssert.assertFalse(text);
        driver.findElementById(btnMinimize()).click();
        driver.findElementById(login()).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean text1=driver.findElementById(textArea()).isEnabled();
        softAssert.assertFalse(text1);
        String text3=driver.findElementByAndroidUIAutomator(txtInputDisable()).getText();
        softAssert.assertEquals(text3,dataProvider.inputText());
        softAssert.assertAll();

    }


    @Test(description = "verify login", alwaysRun = true, priority = 12)
    public void verifyLogin() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnLogin()).click();
        driver.findElementByAndroidUIAutomator(btnRIDLogin()).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath(username()).click();
        driver.findElementByXPath(username()).sendKeys(dataProvider.email());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean logout1=driver.findElementByXPath(txtLogOut()).isEnabled();
        softAssert.assertTrue(logout1);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath(txtLogOut()).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String logout=driver.findElementById(popUp()).getText();
        softAssert.assertEquals(logout,dataProvider.msgLogOut());
        softAssert.assertAll();

    }

    @Test(description = "verify PullDown", alwaysRun = true, priority = 13)
    public void selectPullDown() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnPullDown()).click();
        driver.findElementByClassName(dropDown()).click();
        driver.findElementByAndroidUIAutomator(btnOption()).click();
        driver.findElementByAndroidUIAutomator(btnSubmit()).click();
        String value=driver.findElementByAndroidUIAutomator(btnOption()).getText();
        softAssert.assertEquals(value,dataProvider.option());
        driver.findElementByAndroidUIAutomator(backToTop()).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean markdown=driver.findElementByAndroidUIAutomator(markdown()).isDisplayed();
        softAssert.assertTrue(markdown);
        softAssert.assertAll();


    }

    @Test(description = "verify suggestions", alwaysRun = true, priority = 14)
    public void verifySuggestions() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementById(textArea()).sendKeys(dataProvider.input());
        driver.findElementById(btnSuggestion()).click();
        driver.findElementById(btnEnter()).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String text=  driver.findElementByAndroidUIAutomator(txtSuggestion()).getText();
        softAssert.assertEquals(text,dataProvider.outputTxt());
        softAssert.assertAll();

    }

    @Test(description = "verify select video ", alwaysRun = true, priority = 15)
    public void selectVideo() {
        driver.findElementById(btnClose()).click();
        driver.findElementById(login()).click();
        driver.findElementByAndroidUIAutomator(btnVideo()).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean video=driver.findElementByClassName(viewVideo()).isDisplayed();
        softAssert.assertTrue(video);
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        driver.quit();
    }



}
