package test;

import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class image extends login {


    SoftAssert softAssert = new SoftAssert();

    public image() throws MalformedURLException {
    }


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

        login();
    }

    @Test(description = "verify image", alwaysRun = true, priority = 1)
    public void selectImage() {

        clickImage();
        boolean image=verifyImage();
        softAssert.assertTrue(image);
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }
}
