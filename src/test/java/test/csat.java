package test;


import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;

import java.net.MalformedURLException;


public class csat extends login {


    SoftAssert softAssert = new SoftAssert();

    public csat() throws MalformedURLException {
    }


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        login();
    }

    @Test(description = "verify csat", alwaysRun = true, priority = 1)
    public void selectCSAT() {

        clickCSAT();
        String value=getCSATText();
        softAssert.assertEquals(value,dataProvider.CSAT());
        softAssert.assertAll();


    }

    @Test(description = "verify click on csat", alwaysRun = true, priority = 2)
    public void selectCSATScreens() {

        clickCSATFirstScreen();
        enterCSATComment();
        softAssert.assertAll();


    }

    @Test(description = "verify Thank you message csat", alwaysRun = true, priority = 3)
    public void selectCSATThankYou() {
        clickCSATThankYou();
        softAssert.assertAll();


    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }
}
