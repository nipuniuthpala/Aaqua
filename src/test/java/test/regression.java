package test;


import dataProvider.dataProvider;
import functions.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.net.MalformedURLException;


public class regression  extends login {


    SoftAssert softAssert = new SoftAssert();



    public regression() throws MalformedURLException {
    }

    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

     login();

    }

    @Test(description = "verify select Markdown and check link", alwaysRun = true, priority = 1)
    public void selectMarkDownAndClickOnLink() {
        displayCarousal();
        navigateToMarkdown();
        clickMarkdownLink();
        boolean web=LinkTextDisplayed();
        softAssert.assertTrue(web);
        BackKEY();
        softAssert.assertAll();

    }

    @Test(description = "verify select Markdown and verify Image", alwaysRun = true, priority = 2)
    public void selectMarkDownAndVerifyOnImage() {
        moveToImage();
        getImage();
        boolean image = imageTextValue();
        softAssert.assertTrue(image);
        goToBackToTheTopLocation();
        goBackToTheTop();
        softAssert.assertAll();
    }

    @Test(description = "verify click back to the top", alwaysRun = true, priority = 3)
    public void clickBackToTheTop() {

        displayCarousal();
        navigateToMarkdown();
        boolean markdown=markdownDisplayed();
        softAssert.assertTrue(markdown);
        backToTheTopLocation();
        boolean back=textBackToTheTop();
        softAssert.assertTrue(back);
        boolean BACK=btnBackToTheTop();
        softAssert.assertFalse(BACK);
        softAssert.assertAll();
    }

    @Test(description = "verify type top command and verify the list", alwaysRun = true, priority = 4)
    public void typeTopCommand() {

        inputTextTop();
        clickBtnEnter();
        displayCarousal();
        navigateToMarkdown();
        boolean markdown=markdownDisplayed();
        softAssert.assertTrue(markdown);
        softAssert.assertAll();
    }

    @Test(description = "verify minimize the app and maximizes the app shows previous text is disabled", alwaysRun = true, priority = 5)
    public void minimizeMaximize() {
        clickBtnMinimize();
        clickLoginBtn();
        navigateToLogin();
        boolean login=loginEnabled();
        softAssert.assertTrue(login);
        softAssert.assertAll();

    }

    @Test(description = "verify close the app and opens the app", alwaysRun = true, priority = 6)
    public void closeApp() {


        clickBtnClose();
        clickLoginBtn();
        sleep10();
        displayCarousal();
        navigateToMarkdown();
        boolean Markdown=markdownIsEnabled();
        softAssert.assertTrue(Markdown);
        softAssert.assertAll();

    }

    @Test(description = "verify adaptiveCard", alwaysRun = true, priority = 7)
    public void verifySelectAdaptiveCard() {
        btnCloseOpen();
        selectAdaptiveCard();
        String value=getAdaptiveCardValue();
        softAssert.assertEquals(value,dataProvider.card_Value());
        softAssert.assertAll();

    }

    @Test(description = "verify select carousal and check link", alwaysRun = true, priority = 8)
    public void verifySelectCarousal() {
        btnCloseOpen();
        selectCarousal();
        softAssert.assertAll();

    }


    @Test(description = "verify csat", alwaysRun = true, priority = 9)
    public void selectCSAT() {
        btnCloseOpen();
        clickCSAT();
        String value=getCSATText();
        softAssert.assertEquals(value,dataProvider.CSAT());
        softAssert.assertAll();


    }

    @Test(description = "verify image", alwaysRun = true, priority = 10)
    public void verifySelectImage() {
        btnCloseOpen();
        clickImage();
        boolean image=verifyImage();
        softAssert.assertTrue(image);
        softAssert.assertAll();

    }

    @Test(description = "verify inputDisable", alwaysRun = true, priority = 11)
    public void selectInputDisable() {
        btnCloseOpen();
        clickInputDisable();
        boolean text=TextIsEnabled();
        softAssert.assertFalse(text);
        minimize();
        clickBtnLoginIcon();
        boolean text1=TextIsEnabled();
        softAssert.assertFalse(text1);
        String text3=getInputDisableText();
        softAssert.assertEquals(text3,dataProvider.inputText());
        softAssert.assertAll();

    }


    @Test(description = "verify login", alwaysRun = true, priority = 12)
    public void verifyLogin() {
        btnCloseOpen();
        clickRIDLogin();
        String text3=getPopUpMessage();
        softAssert.assertEquals(text3,dataProvider.msgWelcome());
        clickHambergMenu();
        boolean logout1=getLogoutEnabled();
        softAssert.assertTrue(logout1);
        sleep5();
        clickLogOut();
        sleep5();
        String logout=getPopUpMessage();
        softAssert.assertEquals(logout,dataProvider.msgLogOut());
        softAssert.assertAll();

    }

    @Test(description = "verify PullDown", alwaysRun = true, priority = 13)
    public void selectPullDown() {
        btnCloseOpen();
        clickPullDown();
        String value=getBtnOptionText();
        softAssert.assertEquals(value,dataProvider.option());
        clickBackToTop();
        displayCarousal();
        navigateToMarkdown();
        boolean markdown=markdownIsEnabled();
        softAssert.assertTrue(markdown);
        softAssert.assertAll();


    }

    @Test(description = "verify suggestions", alwaysRun = true, priority = 14)
    public void verifySuggestions() {
        btnCloseOpen();
        enterSuggestions();
        String text=getSuggestionsText();
        softAssert.assertEquals(text,dataProvider.outputTxt());
        softAssert.assertAll();

    }

    @Test(description = "verify select video ", alwaysRun = true, priority = 15)
    public void verifySelectVideo() {
        btnCloseOpen();
        selectVideo();
        boolean video=viewVideoLocation();
        softAssert.assertTrue(video);
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }



}