package utilities;

import pages.*;

public class Pages {

    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private ProductsPage productsPage;
    private AccountPage accountPage;
    private ContactUsPage contactUsPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private CheckoutAndPaymentPage checkoutAndPaymentPage;
    private CategoryPage categoryPage;

    public Pages() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.signupPage = new SignupPage();
        this.productsPage = new ProductsPage();
        this.accountPage = new AccountPage();
        this.contactUsPage = new ContactUsPage();
        this.productDetailsPage = new ProductDetailsPage();
        this.cartPage = new CartPage();
        this.checkoutAndPaymentPage = new CheckoutAndPaymentPage();
        this.categoryPage = new CategoryPage();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public ProductsPage getProductsPage(){
        return productsPage;
    }

    public AccountPage getAccountPage(){
        return accountPage;
    }

    public ContactUsPage getContactUsPage(){
        return contactUsPage;
    }

    public ProductDetailsPage getProductDetailsPage(){
        return productDetailsPage;
    }

    public CartPage getCartPage() {
        return cartPage;
    }

    public CheckoutAndPaymentPage getCheckoutAndPaymentPage() {
        return checkoutAndPaymentPage;
    }

    public CategoryPage getCategoryPage() {
        return categoryPage;
    }
}
