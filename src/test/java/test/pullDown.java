package test;


import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;

import java.net.MalformedURLException;


public class pullDown extends login {



    SoftAssert softAssert = new SoftAssert();


    public pullDown() throws MalformedURLException {
    }

    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

       login();
    }

    @Test(description = "verify PullDown", alwaysRun = true, priority = 1)
    public void selectPullDown() {

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

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }
}
