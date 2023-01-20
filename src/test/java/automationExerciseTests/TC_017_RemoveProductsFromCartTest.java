package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TC_017_RemoveProductsFromCartTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void removeProductsFromCartTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 17 : Verify home page is visible\n");

        pages.getHomePage().clickAddToCartFirstProductButton();
        pages.getHomePage().clickContinueShoppingButton();
        pages.getHomePage().clickCartButton();
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart", "ERROR-->Test Case 17 : Verify cart page is visible\n");

        pages.getCartPage().clickRemoveProductFromCartButton();
        String cartEmptyMessage = pages.getCartPage().getCartIsEmptyMessage();
        softAssert.assertEquals(cartEmptyMessage, "Cart is empty!", "ERROR-->Test Case 17 : Verify 'Cart is Empty' is visible\n");

        pages.getCartPage().clickHomePageButton();
    }

}
