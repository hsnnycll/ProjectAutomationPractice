package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;


public class TC_006_ContactUsFormTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void contactUsFormTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 6 : Verify home page is visible\n");

        pages.getHomePage().clickContactUsButton();
        String getInTouchMessage = pages.getContactUsPage().getGetInTouchMessage();
        softAssert.assertEquals(getInTouchMessage, "Get In Touch", "ERROR-->Test Case 6: Verify 'GET IN TOUCH' is visible\n");

        pages.getContactUsPage().setNameBox("hasan");
        pages.getContactUsPage().setEmailBox("hasan@mail.com");
        pages.getContactUsPage().setSubjectBox("About last order");
        pages.getContactUsPage().setMessageBox("Thanks for your gift.");
        pages.getContactUsPage().setUploadFileButton("C:\\Users\\hsnny\\workspace\\jenkins.war");
        pages.getContactUsPage().clickSubmitButton();
        Driver.getDriver().switchTo().alert().accept();

        String statusMessage = pages.getContactUsPage().getStatusAlertMessage();
        softAssert.assertEquals(statusMessage, "Success! Your details have been submitted successfully.", "ERROR-->Test Case 6: Verify 'Success!' is visible\n");

        pages.getContactUsPage().clickHomePageButton();
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 6 : Verify home page is visible\n");
    }

}
