package dataProvider;


public class dataProvider {

    static String DEVICE_NAME = "Android";
    static String PLATFORM_NAME = "Android";
    static String AUTOMATION_NAME="uiautomator2";
    static String URL="http://127.0.0.1:4723/wd/hub";
    static String APP="Instagram.apk";
    static String PATH="src";




    public static String DEVICE_NAME() {
        return DEVICE_NAME;
    }
    public static String PLATFORM_NAME() {
        return PLATFORM_NAME;
    }

    public static String AUTOMATION_NAME(){
        return AUTOMATION_NAME;
    }

    public static String URL(){
        return URL;
    }


    public static String APP(){return APP;}

    public static String PATH(){return PATH;}
}