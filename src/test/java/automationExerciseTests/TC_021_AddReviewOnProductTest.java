package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;


public class TC_021_AddReviewOnProductTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addReviewOnProductTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 21 : Verify home page is visible\n");

        pages.getHomePage().clickProductsButton();
        String headOfAllProducts = pages.getProductsPage().getAllProductsHead();
        softAssert.assertEquals(headOfAllProducts, "ALL PRODUCTS", "ERROR-->Test Case 21 : Verify all products page is visible\n");

        pages.getProductsPage().clickViewProductButtonOfFirstProduct();
        String headWriteYourReview = pages.getProductDetailsPage().getHeadWriteYourReview();
        softAssert.assertEquals(headWriteYourReview, "WRITE YOUR REVIEW", "ERROR-->Test Case 21 : Verify 'WRITE YOUR REVIEW' is visible\n");

        pages.getProductDetailsPage().setNameBox("hasan");
        pages.getProductDetailsPage().setEmailBox("hasan@mail.com");
        pages.getProductDetailsPage().setReviewBox("It is super.");
        pages.getProductDetailsPage().clickSubmitButton();
        String successReviewMessage = pages.getProductDetailsPage().getReviewSuccessMessage();
        softAssert.assertEquals(successReviewMessage, "Thank you for your review.", "ERROR-->Test Case 21 : Verify 'Thank you for your review.' is visible\n");

        pages.getProductsPage().clickHomePageButton();
    }
}
