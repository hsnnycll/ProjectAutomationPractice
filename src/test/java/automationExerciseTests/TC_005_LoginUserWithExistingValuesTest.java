package automationExerciseTests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;


public class TC_005_LoginUserWithExistingValuesTest extends BaseTest{

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
    public void registrationWithExistingValuesTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 5 : Verify home page is visible\n");

        pages.getHomePage().clickSignupLoginButton();
        String newUserSignupMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignupMessage, "New User Signup!", "ERROR-->Test Case 5 : Verify 'New User Signup' is visible\n");

        pages.getLoginPage().setSignupNameBox("Hasan");
        pages.getLoginPage().setSignupEmailAddressBox("hasan@mail.com");
        pages.getLoginPage().clickSignupButton();
        String emailAddressAlreadyMessage = pages.getLoginPage().getEmailAddressAlreadyExistMessage();
        softAssert.assertEquals(emailAddressAlreadyMessage, "Email Address already exist!", "ERROR-->Test Case 5 : Verify 'Email Address already exist!' is visible\n");

    }

    @AfterMethod
    public void deleteAccount(){
        pages.getLoginPage().setLoginEmailAddressBox("hasan@mail.com");
        pages.getLoginPage().setLoginPasswordBox("hasan");
        pages.getLoginPage().clickLoginButton();
        pages.getHomePage().clickDeleteAccountButton();
    }

}
