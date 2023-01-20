package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

public class TC_008_VerifyProductsAndDetailPageTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();


    @Test
    public void verifyProductsAndDetailPageTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 8 : Verify home page is visible\n");

        pages.getHomePage().clickProductsButton();
        String headOfAllProducts = pages.getProductsPage().getAllProductsHead();
        softAssert.assertEquals(headOfAllProducts, "ALL PRODUCTS", "ERROR-->Test Case 8 : Verify all products page is visible\n");

        BrowserUtils.verifyElementDisplayed(pages.getProductsPage().getListOfAllProductsElement());

        pages.getProductsPage().clickViewProductButtonOfFirstProduct();
        BrowserUtils.verifyElementDisplayed(pages.getProductDetailsPage().getProductNameElement());
        BrowserUtils.verifyElementDisplayed(pages.getProductDetailsPage().getPriceOfProductElement());
        pages.getProductDetailsPage().getListOfProductDetails().forEach(element -> BrowserUtils.verifyElementDisplayed(element));

    }

}
