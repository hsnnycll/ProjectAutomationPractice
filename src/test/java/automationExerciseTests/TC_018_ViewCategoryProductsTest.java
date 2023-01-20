package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class TC_018_ViewCategoryProductsTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void viewCategoryProductsTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 18 : Verify home page is visible\n");

        pages.getHomePage().clickWomenCategoryButton();
        pages.getHomePage().clickDressBelowWomenCategoryButton();
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/category_products/1", "ERROR-->Test Case 18 : Verify women category page is visible\n");

        String titleText = pages.getCategoryPage().getTitleTextMessage();
        softAssert.assertEquals(titleText, "WOMEN - DRESS PRODUCTS", "ERROR-->Test Case 18 : Verify 'Women - Dress Products' is visible\n");

        pages.getCategoryPage().clickMenCategoryButton();
        pages.getCategoryPage().clickTshirtsBelowMenCategoryButton();
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/category_products/3", "ERROR-->Test Case 18 : Verify men category page is visible\n");

    }
}
