package test;


import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;

import java.net.MalformedURLException;


public class inputDisable extends login {



    SoftAssert softAssert = new SoftAssert();

    public inputDisable() throws MalformedURLException {
    }


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

       login();
    }

    @Test(description = "verify inputDisable", alwaysRun = true, priority = 1)
    public void selectInputDisable() {

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
    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }

    }
