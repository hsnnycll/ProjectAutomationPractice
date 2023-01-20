package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TC_009_SearchProductTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    String searchedProduct = "T-Shirt";

    @Test
    public void searchButtonTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 9 : Verify home page is visible\n");

        pages.getHomePage().clickProductsButton();
        String headOfAllProducts = pages.getProductsPage().getAllProductsHead();
        softAssert.assertEquals(headOfAllProducts, "ALL PRODUCTS", "ERROR-->Test Case 9 : Verify all products page is visible\n");

        pages.getProductsPage().setSearchBox(searchedProduct);
        pages.getProductsPage().clickSearchButton();
        String titleOfSearchedProduct = pages.getProductsPage().getTitleOfSearchedProducts();
        softAssert.assertEquals(titleOfSearchedProduct, "SEARCHED PRODUCTS", "ERROR-->Test Case 9 : Verify 'SEARCHED PRODUCTS' is visible\n");

        softAssert.assertTrue(pages.getProductsPage().getListOfSearchedProducts().stream().anyMatch(s -> s.contains(searchedProduct)));
    }

}
