package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC_013_VerifyProductQuantityInCartTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void verifyProductQuantityInCartTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 13 : Verify home page is visible\n");

        pages.getHomePage().clickViewProductButtonOfFirstProduct();
        BrowserUtils.verifyElementDisplayed(pages.getProductDetailsPage().getProductNameElement());
        BrowserUtils.verifyElementDisplayed(pages.getProductDetailsPage().getPriceOfProductElement());

        pages.getProductDetailsPage().setQuantityBox("4");
        pages.getProductDetailsPage().clickAddToCartButton();
        pages.getProductDetailsPage().clickViewCartButton();

        String quantityOfProduct = pages.getCartPage().getListOfProductsQuantityElement().get(0).getText();

        softAssert.assertEquals(quantityOfProduct, "4", "ERROR--> Test Case 13 : Verify quantity is true");

        pages.getCartPage().clickHomePageButton();
    }
}
