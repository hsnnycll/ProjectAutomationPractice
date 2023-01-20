package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC_022_AddToCartFromRecommendedTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addToCartFromRecommendedTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 22 : Verify home page is visible\n");

        BrowserUtils.scrollBottom();

        String headRecommendedItems = pages.getHomePage().getRecommendedItemsHead();
        softAssert.assertEquals(headRecommendedItems, "RECOMMENDED ITEMS", "ERROR-->Test Case 22 : Verify 'RECOMMENDED ITEMS' is visible\n");

        pages.getHomePage().clickFirstRecommendedItemAddToCarButton();
        pages.getHomePage().clickViewCartButton();

        BrowserUtils.verifyElementDisplayed(pages.getCartPage().getCartDescriptionFrameElement());

    }

}
