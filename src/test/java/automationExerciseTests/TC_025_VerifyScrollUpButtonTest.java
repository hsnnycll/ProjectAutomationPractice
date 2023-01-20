package automationExerciseTests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC_025_VerifyScrollUpButtonTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyScrollUpButtonTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 25 : Verify home page is visible\n");
        BrowserUtils.scrollBottom();

        softAssert.assertEquals(pages.getHomePage().getSubscriptionTitle(), "SUBSCRIPTION", "ERROR-->Test Case 25 : Verify 'SUBSCRIPTION' is visible\n");

        pages.getHomePage().clickScrollUpArrowButton();
        softAssert.assertTrue(pages.getHomePage().getListOfFullFledgedHeadElements().stream().map(WebElement::isDisplayed).isParallel(), "ERROR-->Test Case 25 : Verify 'Full Fledged Head' is visible\n");

    }
}
