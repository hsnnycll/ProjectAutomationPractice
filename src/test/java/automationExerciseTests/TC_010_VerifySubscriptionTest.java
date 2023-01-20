package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC_010_VerifySubscriptionTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifySubscriptionTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 10 : Verify home page is visible\n");
        BrowserUtils.scrollBottom();

        softAssert.assertEquals(pages.getHomePage().getSubscriptionTitle(), "SUBSCRIPTION", "ERROR-->Test Case 10 : Verify 'SUBSCRIPTION' is visible\n");

        pages.getHomePage().setSubscriptionEmailBox("hasan@maail.com");
        pages.getHomePage().clickSubscribeButton();

        String successfulSubscriptionMessage = pages.getHomePage().getSuccessSubscriptionMessage();
        softAssert.assertEquals(successfulSubscriptionMessage, "You have been successfully subscribed!", "ERROR-->Test Case 10 : Verify 'Successful Subs is' visible\n");

    }

}
