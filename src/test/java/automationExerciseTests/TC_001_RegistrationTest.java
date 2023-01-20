package automationExerciseTests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;


public class TC_001_RegistrationTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    List<String> listOfInfos = Arrays.asList("Hasan", "YCL", "Inar", "Street10", "AvenueHope", "NY", "NYC", "26555", "0555444");


    @Test
    public void registrationTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 1 : Verify home page is visible\n");

        pages.getHomePage().clickSignupLoginButton();
        String newUserSignupMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "ERROR-->Test Case 1 : Verify 'New User Signup' is visible\n");

        pages.getLoginPage().setSignupNameBox("Hasan");
        pages.getLoginPage().setSignupEmailAddressBox("hasan@mail.com");
        pages.getLoginPage().clickSignupButton();
        String enterAccountInfoMessage = pages.getSignupPage().getEnterAccountInfoMessage();
        softAssert.assertEquals(enterAccountInfoMessage, "ENTER ACCOUNT INFORMATION", "ERROR-->Test Case 1 : Verify 'ENTER ACCOUNT INFORMATION' is visible\n");

        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPasswordBox("hasan");
        pages.getSignupPage().setDateOfBirth("1", "June", "2000");
        pages.getSignupPage().selectCheckBoxNewsletter();
        pages.getSignupPage().selectCheckBoxSpecialOffers();
        pages.getSignupPage().setAddressInformationElements(listOfInfos);
        pages.getSignupPage().setDropdownCountry("United States");
        pages.getSignupPage().clickCreateAccountButton();

        String accountCreatedMessage = pages.getAccountPage().getAccountMessage();
        softAssert.assertEquals(accountCreatedMessage, "ACCOUNT CREATED!", "ERROR-->Test Case 1 : Verify 'ACCOUNT CREATED' is visible\n");
        pages.getAccountPage().clickContinueButton();
        BrowserUtils.verifyElementDisplayed(pages.getHomePage().getLoggedInAsUserElement());

        pages.getHomePage().clickDeleteAccountButton();
        String accountDeletedMessage = pages.getAccountPage().getAccountMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!", "ERROR-->Test Case 1 : Verify 'ACCOUNT DELETED' is visible\n");

    }

}
