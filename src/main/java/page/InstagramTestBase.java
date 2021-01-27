package page;



import dataProvider.dataProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public abstract class InstagramTestBase {

    public static AndroidDriver<MobileElement> driver;


    @BeforeSuite
    public void setUpAppium() throws MalformedURLException
    {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);
        File appDir = new File(dataProvider.PATH());
        File app = new File(appDir, dataProvider.APP());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //Use a empty DesiredCapabilities object

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dataProvider.DEVICE_NAME());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,dataProvider.AUTOMATION_NAME());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        capabilities.setCapability("appWaitActivity", "SplashActivity, SplashActivity,OtherActivity, *, *.SplashActivity");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);

        driver = new AndroidDriver<MobileElement>(url,capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

        login();
    }

    /**
     * Before any test we want to be sure we can login to the app.
     */
    public void login()
    {
        int attempt = 0;
        boolean loggedIn = false;
        WebDriverWait wait = new WebDriverWait(driver, 15);

        takeScreenshot("homeScreen");

        // Open login page.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/log_in_button"))).click();

        takeScreenshot("LoginScreen");

        while(!loggedIn && (attempt++) < 10)
        {
            int usernameCount = 0;

            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username")));

            // Sometimes sendKeys will remove a letter form the start or end of a string
            // so we will reenter the username (if invalid) up to 10 times before moving on.
            while(!"stitchstorm".equals(username.getText()) && (usernameCount++) < 10)
                username.sendKeys("testautomation1");

           WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
           password.sendKeys("test1234");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("next_button"))).click();

            try
            {
                driver.findElementById("alertTitleContainer").isDisplayed();
                driver.findElementById("button_negative").click();

                //Clears the input fields completely be causing the activities to reload.
                wait.until(ExpectedConditions.elementToBeClickable(By.id("log_in_button"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.id("log_in"))).click();
            }
            catch(NoSuchElementException e)
            {
                loggedIn = true;
            }
        }

        takeScreenshot("LoggedIn");

        Assert.assertTrue(loggedIn, "Login unsuccessful");
    }

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium()
    {
        driver.quit();
    }

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    @AfterClass
    public void restartApp()
    {
        driver.resetApp();
    }

    /**
     * Takes a screenshot and saves it. This method was taken from
     * http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-appium-java-testng.html
     *
     * @param name The name of the image.
     *
     * @return <tt>True</tt> when screenshot successfully saved, <tt>False</tt> otherwise.
     */
    public static boolean takeScreenshot(final String name)
    {
        String screenshotDirectory = System.getProperty("appium.screenshots.dir", System.getProperty("java.io.tmpdir", ""));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }
}