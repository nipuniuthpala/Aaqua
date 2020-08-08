package page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidElement;

import dataProvider.dataProvider;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;


public class base {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement>  driver;

   static String markdown="text(\"MARKDOWN\")";
   static String fashionText="text(\"Rakuten Fashion\")";
   static String loginIcon="com.example.ai_answer_android:id/ai_answer_ui_fab_layout_fb";
   static String permission="com.android.permissioncontroller:id/permission_allow_button";
   static String getImageText="new UiScrollable(new UiSelector()).scrollIntoView(text(\"不在\"))";
   static String imageText="text(\"不在\")";
   static String btnBackToTop="new UiScrollable(new UiSelector()).scrollIntoView(text(\"BACK TO THE TOP\"))";
   static String txtBtnBackToTop="text(\"BACK TO THE TOP\")";
   static String txtBackToTop="text(\"Back to the top\")";
   static String textArea="com.example.ai_answer_android:id/ai_answer_ui_frag_text";
   static String btnEnter="com.example.ai_answer_android:id/ai_answer_ui_frag_text_bt";
   static String btnMinimize="com.example.ai_answer_android:id/ai_answer_ui_frag_tv_minimize";
   static String btnClose="com.example.ai_answer_android:id/ai_answer_ui_frag_tv_close";
   static String btnLogin="text(\"LOGIN\")";
   static String btnCarousal="text(\"CAROUSEL\")";
   static String btnMoreDetails="text(\"MORE DETAILS\")";
   static String btnReserve="text(\"RESERVE\")";
   static String btnCSAT="text(\"CSAT\")";
   static String btnImage="text(\"IMAGE\")";
   static String viewImage="android.widget.ImageView";
   static String btnInputDisable="text(\"INPUT DISABLE\")";
   static String txtInputDisable="text(\"Input has been disabled.\")";
   static String btnRIDLogin="text(\"RID LOGIN\")";
   static String username="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[3]/android.view.View/android.widget.ListView[1]/android.view.View/android.widget.EditText";
   static String password="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[3]/android.view.View/android.widget.ListView[2]/android.view.View/android.widget.EditText";
   static String webLogin="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View[3]/android.view.View/android.widget.Button";
   static String popup="com.example.ai_answer_android:id/snackbar_text";
   static String hamburgMenu="com.example.ai_answer_android:id/ai_answer_ui_iv_menu";
   static String txtLogOut="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView";
   static String btnPullDown="text(\"PULL DOWN\")";
   static String dropDown="android.widget.Spinner";
   static String btnOption="text(\"Option1\")";
   static String btnSubmit="text(\"SUBMIT\")";
   static String backToTop="text(\"GO BACK TO TOP\")";
   static String btnSuggestion="com.example.ai_answer_android:id/ai_answer_ui_frag_suggestion_tv";
   static String txtSuggestion="text(\"いつから予約できるか\")";
   static String btnVideo="text(\"VIDEO\")";
   static String viewVideo="android.view.View";
   static String btnAdaptiveCard="text(\"ADAPTIVE CARD\")";
   static String txtDropDown="text(\"New Zealand\")";
   static String value="text(\"0\")";
   static String btnCalculate="text(\"CALCULATE\")";
   static String valueText="text(\"NZ, 3\")";
   static String allowButton="com.android.permissioncontroller:id/permission_allow_button";


    public static  AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{

    // TODO Auto-generated method stub
    File appDir = new File(dataProvider.PATH());
    File app = new File(appDir, dataProvider.APP());

    DesiredCapabilities capabilities = new DesiredCapabilities();

     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dataProvider.DEVICE_NAME());
     capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,dataProvider.AUTOMATION_NAME());
     capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
     driver = new AndroidDriver<>(new URL(dataProvider.URL()), capabilities);
     return driver;

    }


  public static String markdown(){
       return markdown;
  }
  public static String fashionText() {
      return fashionText;
  }

    public static String clickLogin(){
        return loginIcon;
    }

  public static String getPermission(){
        return permission;
  }

  public static String clickAllow(){
        return allowButton;
  }

  public static String getImageText(){
        return getImageText;
  }

  public static String imageText(){
        return imageText;
  }

  public static String btnBackToTop(){
        return btnBackToTop;
  }

  public static String txtBtnBackToTop(){
        return txtBtnBackToTop;
  }

  public static String txtBackToTop(){
        return txtBackToTop;
  }

  public static String textArea(){
        return textArea;
  }

  public static String btnEnter(){
        return btnEnter;
  }

  public static String btnMinimize(){
        return btnMinimize;
  }

  public static String btnClose(){
        return btnClose;
  }

  public static String btnLogin(){
        return btnLogin;
  }

  public static String btnCarousal(){
        return btnCarousal;
  }

  public static String btnMoreDetails(){
        return btnMoreDetails;
  }

    public static String btnReserve(){
        return btnReserve;
    }

    public static String btnCSAT(){
        return btnCSAT;
    }

    public static String btnImage(){
        return btnImage;
    }

    public static String viewImage(){
        return viewImage;
    }

    public static String btnInputDisable(){
        return btnInputDisable;
    }

    public static String txtInputDisable(){
        return txtInputDisable;
    }

    public static String btnRIDLogin(){
       return btnRIDLogin;
    }

    public static String username(){
       return  username;
    }

    public static String password(){
        return password;
    }

    public static String webLogin(){
        return webLogin;
    }
    public static String popUp(){
        return popup;
    }

    public static String hamburgMenu(){
        return hamburgMenu;
    }

    public static String txtLogOut(){
        return txtLogOut;
    }

    public static String btnPullDown(){
        return btnPullDown;
    }

    public static String dropDown(){
        return dropDown;
    }

    public static String btnOption(){
        return btnOption;
    }

    public static String btnSubmit(){
        return btnSubmit;
    }

    public static String backToTop(){
        return backToTop;
    }

    public static String btnSuggestion(){
        return btnSuggestion;
    }

    public static String txtSuggestion(){
        return txtSuggestion;
    }

    public static String btnVideo(){
        return btnVideo;
    }

    public static String viewVideo(){
        return viewVideo;
    }

    public static String btnAdaptiveCard(){
        return btnAdaptiveCard;
    }

    public static String txtDropDown(){
        return txtDropDown;
    }

    public static String value(){
        return value;
    }

    public static String btnCalculate(){
        return btnCalculate;
    }

    public static String valueText(){
        return valueText;
    }


    public static void getScreenshot(String s) throws IOException
    {
        File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));

    }


    public AppiumDriverLocalService startServer()
    {
        //
        boolean flag=	checkIfServerIsRunnning(4723);
        if(!flag)
        {

            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;

    }

    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
}