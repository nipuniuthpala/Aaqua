package test;

import functions.functions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.InstagramTestBase;

/**
 * Appium Test of Home Activity.
 *
 * @author Sonny Trujillo
 *
 */
public class testInstagram extends InstagramTestBase
{
    /**
     * Click the Like button on the first image found.
     */
    @Test(description = "Validate Login to the device and navigate to teh home screen ", alwaysRun = true, priority = 1)
    public void ValidateHomeScreen()
    {
        String text=functions.validateHomepage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Welcome to Instagram",text);
        softAssert.assertAll();

    }
    @Test(description = "ValidateAddingAndDeletingPostInInstagram", alwaysRun = true, priority = 2)
    public void ValidateAddingAndDeletingPost()
    {

        SoftAssert softAssert = new SoftAssert();
        String post=functions.addPost();
        softAssert.assertEquals(post,"1");
        String post_delete=functions.deletePost();
        softAssert.assertEquals(post_delete,"0");
        softAssert.assertAll();

    }

    @Test(description = "ValidateUserCanSearchPostsAndFriends", alwaysRun = true, priority = 3)
    public void ValidateUserCanSearch()
    {
        SoftAssert softAssert = new SoftAssert();
        String text=functions.ConnectFriends();
        softAssert.assertEquals(text,"Connect");
        String list=functions.searchContent();
        softAssert.assertEquals(list,"who");
        softAssert.assertAll();

    }
}
