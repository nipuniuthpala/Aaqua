package test;


import functions.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import dataProvider.dataProvider;
import java.net.MalformedURLException;

public class suggestions extends login {


    SoftAssert softAssert = new SoftAssert();

    public suggestions() throws MalformedURLException {
    }


    @BeforeClass(description = "Load the Device", alwaysRun = true)
    public void Login () {

      login();
    }

    @Test(description = "verify suggestions", alwaysRun = true, priority = 1)
    public void verifySuggestions() {
        enterSuggestions();
        String text=getSuggestionsText();
        softAssert.assertEquals(text,dataProvider.outputTxt());
        softAssert.assertAll();

    }

    @AfterClass(description = "Quit Device", alwaysRun = true)
    public void quit() {
        logout();
    }


}
