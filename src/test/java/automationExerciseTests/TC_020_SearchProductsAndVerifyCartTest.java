package automationExerciseTests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class TC_020_SearchProductsAndVerifyCartTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    List<String> listOfInfos = Arrays.asList("Hasan", "YCL", "Inar", "Street10", "AvenueHope", "NY", "NYC", "26555", "0555444");

    String searchedProduct = "T-Shirt";

    @BeforeMethod
    public void createAnAccountForTest(){
        pages.getHomePage().clickSignupLoginButton();
        pages.getLoginPage().setSignupNameBox("Hasan");
        pages.getLoginPage().setSignupEmailAddressBox("hasan@mail.com");
        pages.getLoginPage().clickSignupButton();
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPasswordBox("hasan");
        pages.getSignupPage().setDateOfBirth("1", "June", "2000");
        pages.getSignupPage().selectCheckBoxNewsletter();
        pages.getSignupPage().selectCheckBoxSpecialOffers();
        pages.getSignupPage().setAddressInformationElements(listOfInfos);
        pages.getSignupPage().setDropdownCountry("United States");
        pages.getSignupPage().clickCreateAccountButton();
        pages.getAccountPage().clickContinueButton();
        pages.getHomePage().clickLogoutButton();
    }

    @Test
    public void viewAndCartBrandProductsTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 20 : Verify home page is visible\n");

        pages.getHomePage().clickProductsButton();
        String headOfAllProducts = pages.getProductsPage().getAllProductsHead();
        softAssert.assertEquals(headOfAllProducts, "ALL PRODUCTS", "ERROR-->Test Case 20 : Verify all products page is visible\n");

        pages.getProductsPage().setSearchBox(searchedProduct);
        pages.getProductsPage().clickSearchButton();
        String titleOfSearchedProduct = pages.getProductsPage().getTitleOfSearchedProducts();
        softAssert.assertEquals(titleOfSearchedProduct, "SEARCHED PRODUCTS", "ERROR-->Test Case 20 : Verify 'SEARCHED PRODUCTS' is visible\n");

        List<String> listOfSearchedProducts = pages.getProductsPage().getListOfSearchedProducts();
        softAssert.assertTrue(listOfSearchedProducts.stream().anyMatch(s -> s.contains(searchedProduct)), "ERROR-->Test Case 20 : Verify searched products names are true\n");

        pages.getProductsPage().clickAddToCartOfAllProducts();
        pages.getProductsPage().clickCartButton();
        List<String> listOfSelectedProducts = pages.getCartPage().getListOfSelectedProducts();
        softAssert.assertEquals(listOfSearchedProducts, listOfSelectedProducts, "ERROR-->Test Case 20 : Verify searched products names are related\n");

        pages.getCartPage().clickSignupLoginButton();
        pages.getLoginPage().setLoginEmailAddressBox("hasan@mail.com");
        pages.getLoginPage().setLoginPasswordBox("hasan");
        pages.getLoginPage().clickLoginButton();
        pages.getHomePage().clickCartButton();
        List<String> listOfSelectedProducts2 = pages.getCartPage().getListOfSelectedProducts();
        softAssert.assertEquals(listOfSearchedProducts, listOfSelectedProducts2, "ERROR-->Test Case 20 : Verify searched products are visible\n");

    }

    @AfterMethod
    public void deleteAccount(){
        pages.getCartPage().clickDeleteAccountButton();
    }
}
