package test;

import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;

import java.net.MalformedURLException;


public class iconMessage extends login{


    SoftAssert softAssert = new SoftAssert();

    public iconMessage() throws MalformedURLException {
    }


   @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void LoginApp () {
        login();

    }

    @Test(description = "verify iconMessage", alwaysRun = true, priority = 1)
    public void VerifyIconMessageLogin() {
       clickBtnClose();
        selectIconMessage();
        displayCarousal();
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)

    public void quit() {

        logout();
    }
}


