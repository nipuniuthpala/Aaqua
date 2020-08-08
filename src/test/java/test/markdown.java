package test;

import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class markdown extends login {


        SoftAssert softAssert = new SoftAssert();

    public markdown() throws MalformedURLException {
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
            boolean image=imageTextValue();
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

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }

}
