package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC_011_VerifySubscriptionInCartPageTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifySubscriptionInCartPageTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 11 : Verify home page is visible\n");

        pages.getHomePage().clickCartButton();
        BrowserUtils.scrollBottom();

        softAssert.assertEquals(pages.getCartPage().getSubscriptionTitle(), "SUBSCRIPTION", "ERROR-->Test Case 11 : Verify 'SUBSCRIPTION' is visible\n");

        pages.getCartPage().setSubscriptionEmailBox("hasan@maail.com");
        pages.getCartPage().clickSubscribeButton();

        String successfulSubscriptionMessage = pages.getCartPage().getSuccessSubscriptionMessage();
        softAssert.assertEquals(successfulSubscriptionMessage, "You have been successfully subscribed!", "ERROR-->Test Case 11 : Verify 'Successful Subs is' visible\n");

    }

}
