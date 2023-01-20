package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(css = "div[class='product-information'] h2")
    private WebElement productNameElement;

    @FindBy(css = "div[class='product-information'] span span")
    private WebElement priceOfProductElement;

    @FindBy(xpath = "//div[@class='product-details']//p")
    private List<WebElement> listOfProductDetails;

    @FindBy(id = "quantity")
    private WebElement quantityBox;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(css = "a[href='#reviews']")
    private WebElement headWriteYourReviewElement;

    @FindBy(id = "name")
    private WebElement nameBox;

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "review")
    private WebElement reviewBox;

    @FindBy(id = "button-review")
    private WebElement submitButton;

    @FindBy(css = "div[class='alert-success alert'] span")
    private WebElement successReviewMessageElement;


    public WebElement getProductNameElement() {
        return productNameElement;
    }

    public WebElement getPriceOfProductElement() {
        return priceOfProductElement;
    }

    public List<WebElement> getListOfProductDetails() {
        return listOfProductDetails;
    }

    public void setQuantityBox(String quantity) {
        quantityBox.sendKeys(quantity);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public String getHeadWriteYourReview() {
        return headWriteYourReviewElement.getText();
    }

    public void setNameBox(String name){
        nameBox.sendKeys(name);
    }

    public void setEmailBox(String email){
        emailBox.sendKeys(email);
    }

    public void setReviewBox(String review){
        reviewBox.sendKeys(review);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getReviewSuccessMessage(){
       return successReviewMessageElement.getText();
    }
}
