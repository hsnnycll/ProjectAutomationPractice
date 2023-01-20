package automationExerciseTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TC_019_ViewAndCartBrandProductsTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    final List<String> productsName = Arrays.asList("POLO", "H&M", "MADAME", "MAST & HARBOUR", "BABYHUG", "ALLEN SOLLY JUNIOR", "KOOKIE KIDS", "BIBA");

    @Test
    public void viewAndCartBrandProductsTest(){

        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise", "ERROR-->Test Case 19 : Verify home page is visible\n");

        pages.getHomePage().clickProductsButton();
        List<String> listOfProducts = pages.getProductsPage().getListOfProducts();
        softAssert.assertTrue(productsName.stream().anyMatch(s -> listOfProducts.contains(s)));

        pages.getProductsPage().clickMadameBrandButton();
        String headOfMadameBrandProducts = pages.getProductsPage().getTitleOfSearchedProducts();
        softAssert.assertEquals(headOfMadameBrandProducts, "BRAND - MADAME PRODUCTS", "ERROR-->Test Case 19 : Verify madame brand products is visible\n");

        pages.getProductsPage().clickBibaBrandButton();
        String headOfBibaBrandProducts = pages.getProductsPage().getTitleOfSearchedProducts();
        softAssert.assertEquals(headOfBibaBrandProducts, "BRAND - BIBA PRODUCTS", "ERROR-->Test Case 19 : Verify biba brand products is visible\n");

    }

}
