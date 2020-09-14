package functions;



import dataProvider.dataProvider;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import page.base;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class login extends base {

    AndroidDriver<AndroidElement> driver= capabilities();
    TouchAction y =new TouchAction(driver);


    public login() throws MalformedURLException {
    }

    public void login(){
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElementById(clickLogin()).click();

        }

        public  void logout(){
            driver.quit();
        }

    public void clickLoginBtn(){
        driver.findElementById(clickLogin()).click();
    }

    public boolean loginEnabled(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     return   driver.findElementByAndroidUIAutomator(btnLogin()).isEnabled();
    }

    public void sleep10() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void btnCloseOpen(){
        driver.findElementById(btnClose()).click();
        driver.findElementById(clickLogin()).click();
    }

    public void selectAdaptiveCard(){
        driver.findElementByAndroidUIAutomator(btnAdaptiveCard()).click();
        driver.findElementByClassName(dropDown()).click();
        driver.findElementByAndroidUIAutomator(txtDropDown()).click();
        driver.findElementByAndroidUIAutomator(value()).click();
        driver.pressKeyCode(AndroidKeyCode.DEL);
        driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);
        driver.findElementByAndroidUIAutomator(btnCalculate()).click();
    }

    public String getAdaptiveCardValue(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.findElementByAndroidUIAutomator( valueText()).getText();
    }

    public  void selectCarousal(){
        driver.findElementByAndroidUIAutomator(btnCarousal()).click();
        driver.findElementByAndroidUIAutomator(btnMoreDetails()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        y.press( 1249, 1388).moveTo( 305, 1399).release().perform();
        driver.findElementByAndroidUIAutomator(btnMoreDetails()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.findElementByAndroidUIAutomator(btnReserve()).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public boolean displayCarousal(){
        return  driver.findElementByAndroidUIAutomator(btnCarousal()).isEnabled();
    }

    public void clickCSAT(){
        driver.findElementByAndroidUIAutomator(btnCSAT()).click();
    }

    public String getCSATText(){
        return  driver.findElementByAndroidUIAutomator(btnCSAT()).getText();
    }


    public void clickImage(){
        driver.findElementByAndroidUIAutomator(btnImage()).click();
    }

    public boolean verifyImage(){
        return driver.findElementByClassName(viewImage()).isDisplayed();
    }


    public void clickInputDisable(){
        driver.findElementByAndroidUIAutomator(btnInputDisable()).click();
    }

    public boolean TextIsEnabled(){
        return driver.findElementById(textArea()).isEnabled();
    }

    public void minimize(){
        driver.findElementById(btnMinimize()).click();
    }

    public void clickBtnLoginIcon(){
        driver.findElementById(clickLogin()).click();
    }

    public String getInputDisableText(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.findElementByAndroidUIAutomator(txtInputDisable()).getText();
    }

    public void clickRIDLogin(){

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
    }

    public String getPopUpMessage(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return  driver.findElementById(popUp()).getText();
    }

    public void clickHambergMenu(){
        driver.findElementById(hamburgMenu()).click();
    }

    public boolean getLogoutEnabled(){
        return  driver.findElementByXPath(txtLogOut()).isEnabled();
    }

    public void sleep5() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void clickLogOut(){
        driver.findElementByXPath(txtLogOut()).click();
    }

public void navigateToMarkdown(){
    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    y.press(1301, 547).moveTo(1290,779).release().perform();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

}

    public void clickMarkdownLink(){
        WebElement expandList=	 driver.findElementByAndroidUIAutomator(markdown());
        y.tap(tapOptions().withElement(element(expandList))).perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        y.press( 1089, 728).moveTo( 1032, 2059).release().perform();
        y.tap( 325, 769).perform();
    }


    public boolean LinkTextDisplayed(){
        return driver.findElementByAndroidUIAutomator(fashionText()).isDisplayed();
    }

    public void BackKEY(){
        driver.pressKeyCode(AndroidKeyCode.BACK);
    }

    public void moveToImage(){
        y.press( 1306,  2152).moveTo( 1270, 1265).release().perform();
    }

    public void getImage(){
        driver.findElementByAndroidUIAutomator(getImageText());
    }

    public boolean imageTextValue() {
        return driver.findElementByAndroidUIAutomator(imageText()).isDisplayed();
    }

    public void goToBackToTheTopLocation(){
        y.press( 1151, 2080).moveTo( 1172,625).release().perform();
        y.press( 1146,  2182).moveTo(  1256, 530).release().perform();
    }
    public void goBackToTheTop(){
        driver.findElementByAndroidUIAutomator(btnBackToTop()).click();
    }


    public boolean markdownDisplayed(){
        return   driver.findElementByAndroidUIAutomator(markdown()).isDisplayed();
    }


    public void backToTheTopLocation(){
        y.press( 1337,  485).moveTo(  1306, 1425).release().perform();
    }

    public boolean textBackToTheTop(){
        return driver.findElementByAndroidUIAutomator(txtBackToTop()).isDisplayed();
    }

    public boolean btnBackToTheTop(){
        return driver.findElementByAndroidUIAutomator(txtBtnBackToTop()).isEnabled();
    }

    public void inputTextTop(){
        driver.findElementById(textArea()).sendKeys("top");
    }

    public void clickBtnMinimize(){
        driver.findElementById(btnMinimize()).click();
    }



    public void navigateToLogin(){
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        y.press( 1306,  516).moveTo(  1300, 1120).release().perform();
    }

    public void clickBtnClose(){
        driver.findElementById(btnClose()).click();
    }

    public boolean markdownIsEnabled() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return  driver.findElementByAndroidUIAutomator(markdown()).isEnabled();
    }

    public void clickBtnEnter(){
        driver.findElementById(btnEnter()).click();
    }

    public void clickPullDown(){
        driver.findElementByAndroidUIAutomator(btnPullDown()).click();
        driver.findElementByClassName(dropDown()).click();
        driver.findElementByAndroidUIAutomator(btnOption()).click();
        driver.findElementByAndroidUIAutomator(btnSubmit()).click();
    }

    public String getBtnOptionText(){
        return driver.findElementByAndroidUIAutomator(btnOption()).getText();
    }

    public void clickBackToTop(){
        driver.findElementByAndroidUIAutomator(backToTop()).click();
    }


    public void enterSuggestions(){
        driver.findElementById(textArea()).sendKeys(dataProvider.input());
        driver.findElementById(btnSuggestion()).click();
        driver.findElementById(btnEnter()).click();
    }


    public String getSuggestionsText(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return   driver.findElementByAndroidUIAutomator(txtSuggestion()).getText();
    }

    public void selectVideo(){
        driver.findElementByAndroidUIAutomator(btnVideo()).click();
    }

    public boolean viewVideoLocation(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver.findElementByClassName(viewVideo()).isDisplayed();
    }

    public void selectIconMessage(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        y.tap( 666, 1822).perform();

    }

}




