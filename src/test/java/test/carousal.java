package test;

import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;


public class carousal extends login {


    public carousal()throws MalformedURLException {
    }

    SoftAssert softAssert = new SoftAssert();


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

      login();

    }

    @Test(description = "verify select carousal and check link", alwaysRun = true, priority = 1)
    public void selectCarousalTest() {
        selectCarousal();
        softAssert.assertAll();
    }


    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {

        logout();
    }
}
