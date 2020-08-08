package test;

import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;

import java.net.MalformedURLException;


public class adaptiveCard extends login{





    SoftAssert softAssert = new SoftAssert();

    public adaptiveCard() throws MalformedURLException {
    }


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void LoginApp () {
        login();

    }

    @Test(description = "verify adaptiveCard", alwaysRun = true, priority = 1)
    public void VerifySelectAdaptiveCard() {

        selectAdaptiveCard();
        String value=getAdaptiveCardValue();
        softAssert.assertEquals(value,dataProvider.card_Value());
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)

    public void quit() {

        logout();
    }
}
