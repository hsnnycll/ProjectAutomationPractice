package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TC_023_VerifyAddressDetailsTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    List<String> listOfInfos = Arrays.asList("Hasan", "YCL", "Inar", "Street10", "AvenueHope", "NY", "NYC", "26555", "0555444");

    @Test
    public void verifyAddressDetailsTest() {

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 23 : Verify home page is visible\n");

        pages.getHomePage().clickSignupLoginButton();
        pages.getLoginPage().setSignupNameBox("hasan");
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

        String accountCreatedMessage = pages.getAccountPage().getAccountMessage();
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!", "ERROR-->Test Case 23 : Verify 'ACCOUNT CREATED' is visible\n");

        pages.getAccountPage().clickContinueButton();
        BrowserUtils.verifyElementDisplayed(pages.getHomePage().getLoggedInAsUserElement());

        pages.getProductsPage().clickAddToCartFirstProductButton();
        pages.getProductsPage().clickContinueShoppingButton();
        pages.getHomePage().clickCartButton();
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart", "ERROR-->Test Case 23 : Verify cart page is visible\n");

        pages.getCartPage().clickProceedToCheckoutButton();
        List<String> listOfDeliveryAddressInfos = pages.getCheckoutAndPaymentPage().getListOfDeliveryAddressInfos();
        List<String> listOfBillingAddressInfos = pages.getCheckoutAndPaymentPage().getListOfBillingAddressInfos();
        softAssert.assertEquals(listOfDeliveryAddressInfos, listOfBillingAddressInfos, "ERROR-->Test Case 23 : Verify 'Delivery Address' and 'Billing Address' is identical\n");

        ArrayList<String> checkList = new ArrayList<>();
        for (int i = 0; i < listOfDeliveryAddressInfos.size(); i++) {
            for (int j = 0; j < listOfInfos.size(); j++) {
                if (listOfDeliveryAddressInfos.get(i).contains(listOfInfos.get(j))){
                    checkList.add(listOfInfos.get(j));
                }
            }
        }
        softAssert.assertEquals(listOfInfos, checkList, "ERROR-->Test Case 23 : Verify 'Delivery Address' and 'Registration Address' is identical\n");

        pages.getCheckoutAndPaymentPage().clickDeleteAccountButton();
        String accountDeletedMessage = pages.getCheckoutAndPaymentPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!", "ERROR-->Test Case 23 : Verify 'ACCOUNT DELETED!' is visible\n");

        pages.getCartPage().clickHomePageButton();
    }
}
