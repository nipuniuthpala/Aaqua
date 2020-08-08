package test;


import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class video extends login {


    SoftAssert softAssert = new SoftAssert();

    public video() throws MalformedURLException {
    }

    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

      login();
    }

    @Test(description = "verify select video ", alwaysRun = true, priority = 1)
    public void verifySelectVideo() {

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
