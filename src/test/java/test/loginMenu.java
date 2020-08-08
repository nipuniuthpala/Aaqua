package test;

import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;

import java.net.MalformedURLException;


public class loginMenu extends login {


    SoftAssert softAssert = new SoftAssert();

    public loginMenu() throws MalformedURLException {
    }


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

       login();
    }

    @Test(description = "verify login", alwaysRun = true, priority = 1)
    public void verifyLogin() {
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

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }

}
