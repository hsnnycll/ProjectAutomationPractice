package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;

    @FindBy(xpath = "//a[normalize-space()='Cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement signupLoginButton;

    @FindBy(css = "li:nth-child(10) a:nth-child(1)")
    private WebElement loggedInAsUserElement;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[normalize-space()='Test Cases']")
    private WebElement testCasesButton;

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionTitleElement;

    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmailBox;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "success-subscribe")
    private WebElement successSubscriptionMessageElement;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement viewProductButtonOfFirstProduct;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/a[1]")
    private WebElement addToCartFirstProductButton;

    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/a[1]")
    private WebElement addToCartSecondProductButton;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[normalize-space()='Women']")
    private WebElement womenCategoryButton;

    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
    private WebElement dressBelowWomenCategoryButton;

    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    private WebElement recommendedItemsHeadElement;

    @FindBy(xpath = "//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")
    private WebElement firstRecommendedItemAddToCartButton;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//i[@class='fa fa-angle-up']")
    private WebElement scrollUpArrowButton;

    @FindBy(xpath = "//*[@id=\"slider-carousel\"]/div/div/div/h2")
    private List<WebElement> fullFledgedPractiseHeadsElements;


    public void clickSignupLoginButton(){
        signupLoginButton.click();
    }

    public void clickCartButton(){
        cartButton.click();
    }

    public void clickProductsButton(){
        productsButton.click();
    }

    public WebElement getLoggedInAsUserElement(){
        return loggedInAsUserElement;
    }

    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void clickContactUsButton(){
        contactUsButton.click();
    }

    public void clickTestCasesButton(){
        testCasesButton.click();
    }

    public String getSubscriptionTitle(){
        return subscriptionTitleElement.getText();
    }

    public void setSubscriptionEmailBox(String email){
        subscriptionEmailBox.sendKeys(email);
    }

    public void clickSubscribeButton(){
        subscribeButton.click();
    }

    public String getSuccessSubscriptionMessage(){
        return successSubscriptionMessageElement.getText();
    }

    public void clickViewProductButtonOfFirstProduct(){
        viewProductButtonOfFirstProduct.click();
    }

    public void clickAddToCartFirstProductButton(){
        addToCartFirstProductButton.click();
    }

    public void clickAddToCartSecondProductButton(){
        addToCartSecondProductButton.click();
    }

    public void clickContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clickWomenCategoryButton(){
        womenCategoryButton.click();
    }

    public void clickDressBelowWomenCategoryButton(){
        dressBelowWomenCategoryButton.click();
    }

    public String getRecommendedItemsHead() {
        return recommendedItemsHeadElement.getText();
    }

    public void clickFirstRecommendedItemAddToCarButton(){
        firstRecommendedItemAddToCartButton.click();
    }

    public void clickViewCartButton(){
        viewCartButton.click();
    }

    public void clickScrollUpArrowButton(){
        scrollUpArrowButton.click();
    }

    public List<WebElement> getListOfFullFledgedHeadElements(){
        return fullFledgedPractiseHeadsElements;
    }
}
