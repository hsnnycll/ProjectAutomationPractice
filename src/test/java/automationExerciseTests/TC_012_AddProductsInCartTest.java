package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TC_012_AddProductsInCartTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addProductsInCartTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 12 : Verify home page is visible\n");

        pages.getHomePage().clickProductsButton();
        pages.getProductsPage().clickAddToCartFirstProductButton();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getProductsPage().clickAddToCartSecondProductButton();
        pages.getProductsPage().clickViewCartButton();
        int numberOfProductsInCart = pages.getCartPage().getTheNumberOfProductsInCart();
        softAssert.assertEquals(numberOfProductsInCart, 2, "ERROR-->Test Case 12 : Verify the products ın the cart\n");

        softAssert.assertTrue(pages.getCartPage().getListOfCartPriceElement().stream().anyMatch(element -> element.isDisplayed()), "ERROR-->Test Case 12 : Verify price is visible\n");
        softAssert.assertTrue(pages.getCartPage().getListOfProductsQuantityElement().stream().anyMatch(element -> element.isDisplayed()), "ERROR-->Test Case 12 : Verify quantity is visible\n");
        softAssert.assertTrue(pages.getCartPage().getListOfProductsTotalPriceElement().stream().anyMatch(element -> element.isDisplayed()), "ERROR-->Test Case 12 : Verify total price is visible\n");

        pages.getCartPage().clickHomePageButton();
    }
}
