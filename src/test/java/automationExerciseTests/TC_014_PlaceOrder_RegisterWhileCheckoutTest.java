package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class TC_014_PlaceOrder_RegisterWhileCheckoutTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    List<String> listOfInfos = Arrays.asList("Hasan", "YCL", "Inar", "Street10", "AvenueHope", "NY", "NYC", "26555", "0555444");

    List<String> listOfCardInfos = Arrays.asList("User USR", "1234567890", "123", "01", "2030");

    @Test
    public void placeOrderRegisterWhileCheckoutTest() throws InterruptedException {

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 14 : Verify home page is visible\n");

        pages.getHomePage().clickAddToCartFirstProductButton();
        pages.getHomePage().clickContinueShoppingButton();
        pages.getHomePage().clickAddToCartSecondProductButton();
        pages.getHomePage().clickContinueShoppingButton();
        pages.getHomePage().clickCartButton();
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/view_cart", "ERROR-->Test Case 14 : Verify home page is visible\n");

        pages.getCartPage().clickProceedToCheckoutButton();
        pages.getCartPage().clickRegisterAndLoginButton();
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
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!", "ERROR-->Test Case 14 : Verify 'ACCOUNT CREATED' is visible\n");
        pages.getAccountPage().clickContinueButton();
        BrowserUtils.verifyElementDisplayed(pages.getHomePage().getLoggedInAsUserElement());

        pages.getHomePage().clickCartButton();
        pages.getCartPage().clickProceedToCheckoutButton();

        String headAddressDetails = pages.getCheckoutAndPaymentPage().getHeadAddressDetails();
        softAssert.assertEquals(headAddressDetails, "Address Details", "ERROR-->Test Case 14 : Verify 'Address Details' is visible\n");

        String headReviewYourOrder = pages.getCheckoutAndPaymentPage().getHeadReviewYourOrder();
        softAssert.assertEquals(headReviewYourOrder, "Review Your Order", "ERROR-->Test Case 14 : Verify 'Review Your Order' is visible\n");

        pages.getCheckoutAndPaymentPage().setMessageBox("It is urgent.");
        pages.getCheckoutAndPaymentPage().clickPlaceOrderButton();
        pages.getCheckoutAndPaymentPage().setListOfPaymentInfosElement(listOfCardInfos);
        pages.getCheckoutAndPaymentPage().clickPayAndConfirmButton();
        //BrowserUtils.waitForVisibility(pages.getCheckoutAndPaymentPage().getSuccessMessageElement(), 3);

        //String successMessage = pages.getCheckoutAndPaymentPage().getSuccessMessageElement().getText();
        //softAssert.assertEquals(successMessage, "Your order has been placed successfully!", "ERROR-->Test Case 14 : Verify success message is visible\n");
        //Thread.sleep(3000);
        //BrowserUtils.waitForPresence(By.id("success_message"), 10);
        //System.out.println(Driver.getDriver().findElement(By.xpath("(//div[@class='form-row'])[4]")).getText());
        pages.getCheckoutAndPaymentPage().clickDeleteAccountButton();
        String accountDeletedMessage = pages.getCheckoutAndPaymentPage().getAccountDeletedMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!", "ERROR-->Test Case 14 : Verify 'ACCOUNT DELETED!' is visible\n");

        pages.getCheckoutAndPaymentPage().clickContinueButton();

    }

}
