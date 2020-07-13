package utility;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import page.base;

public class utilities extends base {
   static  AndroidDriver<AndroidElement> driver;

    static {
        try {
            driver = capabilities();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public  utilities() throws MalformedURLException {
    }
    public static void sleep(){

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
