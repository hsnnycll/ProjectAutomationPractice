package automationExerciseTests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;


public class TC_002_LoginUserWithCorrectValuesTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    List<String> listOfInfos = Arrays.asList("Hasan", "YCL", "Inar", "Street10", "AvenueHope", "NY", "NYC", "26555", "0555444");

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
    public void registrationWithCorrectValuesTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 2 : Verify home page is visible\n");

        pages.getHomePage().clickSignupLoginButton();
        String loginYourAccountMessage = pages.getLoginPage().getLoginYourAccountMessage();
        softAssert.assertEquals(loginYourAccountMessage, "Login to your account", "ERROR-->Test Case 2 : Verify 'Login to your account' is visible\n");

        pages.getLoginPage().setLoginEmailAddressBox("hasan@mail.com");
        pages.getLoginPage().setLoginPasswordBox("hasan");
        pages.getLoginPage().clickLoginButton();
        BrowserUtils.verifyElementDisplayed(pages.getHomePage().getLoggedInAsUserElement());

        pages.getHomePage().clickDeleteAccountButton();
        String accountDeletedMessage = pages.getAccountPage().getAccountMessage();
        softAssert.assertEquals(accountDeletedMessage, "ACCOUNT DELETED!", "ERROR-->Test Case 2 : Verify 'ACCOUNT DELETED' is visible\n");

    }

}
