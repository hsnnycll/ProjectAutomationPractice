package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage{

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionTitleElement;

    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmailBox;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "success-subscribe")
    private WebElement successSubscriptionMessageElement;

    @FindBy(xpath = "//tbody//tr")
    private List<WebElement> listOfProductsElement;

    @FindBy(xpath = "//td[@class='cart_price']")
    private List<WebElement> listOfCartPriceElement;

    @FindBy(xpath = "//td[@class='cart_quantity']")
    private List<WebElement> listOfProductsQuantityElement;

    @FindBy(xpath = "//td[@class='cart_total']")
    private List<WebElement> listOfProductsTotalPriceElement;

    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    private WebElement registerAndLoginButton;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    private WebElement removeProductFromCartButton;

    @FindBy(xpath = "//b[normalize-space()='Cart is empty!']")
    private WebElement cartIsEmptyMessageElement;

    @FindBy(xpath = "//h4/a")
    private List<WebElement> listOfSelectedProductsElement;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement signupLoginButton;

    @FindBy(xpath = "//td[@class='cart_description']")
    private WebElement cartDescriptionFrameElement;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homePageButton;

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

    public int getTheNumberOfProductsInCart(){
        return listOfProductsElement.size();
    }

    public List<WebElement> getListOfCartPriceElement() {
        return listOfCartPriceElement;
    }

    public List<WebElement> getListOfProductsQuantityElement() {
        return listOfProductsQuantityElement;
    }

    public List<WebElement> getListOfProductsTotalPriceElement() {
        return listOfProductsTotalPriceElement;
    }

    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }

    public void clickRegisterAndLoginButton(){
        registerAndLoginButton.click();
    }

    public void clickRemoveProductFromCartButton(){
        removeProductFromCartButton.click();
    }

    public String getCartIsEmptyMessage(){
        return cartIsEmptyMessageElement.getText();
    }

    public List<String> getListOfSelectedProducts(){
        return listOfSelectedProductsElement.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void clickSignupLoginButton(){
        signupLoginButton.click();
    }

    public WebElement getCartDescriptionFrameElement() {
        return cartDescriptionFrameElement;
    }

    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public void clickHomePageButton(){
        homePageButton.click();
    }
}
