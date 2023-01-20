package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TC_007_VerifyCasesPageTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();


    @Test
    public void verifyCasesPageTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 7 : Verify home page is visible\n");

        pages.getHomePage().clickTestCasesButton();

        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/test_cases", "ERROR-->Test Case 7 : Verify test cases page is visible\n");
    }


}
