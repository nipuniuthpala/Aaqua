package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.InstagramTestBase;


import java.net.MalformedURLException;

public class functions extends InstagramTestBase {



    public functions() throws MalformedURLException {
    }

    public static String validateHomepage(){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Click Like
        String text=wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/igds_headline_emphasized_headline"))).getText();
        return text;

    }

    public static String addPost(){
        WebDriverWait wait = new WebDriverWait(driver, 40);

        //Click Like
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Profile\"]/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Create new\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/igds_headline_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/draft_image_view"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/next_button_imageview"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/next_button_imageview"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/next_button_imageview"))).click();
        String post=wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/row_profile_header_textview_post_count"))).getText();
        return post;


    }


    public static String deletePost(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Home\"]/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/feed_more_button_stub"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text=\"Delete\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/primary_button"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Profile\"]/android.widget.ImageView"))).click();
        String post_delete=wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/row_profile_header_textview_post_count"))).getText();
        return post_delete;
    }

    public static String ConnectFriends(){
        WebDriverWait wait = new WebDriverWait(driver, 30);



        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Search and explore\"]/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageView[@content-desc=\"Discover people\"]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/negative_button"))).click();

        String text=wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/find_people_action_button"))).getText();
         return text;
    }

    public static String searchContent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/action_bar_button_back"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc=\"Search and explore\"]/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/action_bar_search_edit_text"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/action_bar_search_edit_text"))).sendKeys("who");
        String list=wait.until(ExpectedConditions.elementToBeClickable(By.id("com.instagram.android:id/row_search_user_username"))).getText();
        return list;
    }




}



