package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    private WebElement allProductsHeadElement;

    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement listOfAllProductsElement;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement viewProductButtonOfFirstProduct;

    @FindBy(id = "search_product")
    private WebElement searchBox;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(css = ".title.text-center")
    private WebElement searchedProductsElement;

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    private List<WebElement> listOfSearchedProducts;

    @FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/a[1]")
    private WebElement addToCartFirstProductButton;

    @FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/a[1]")
    private WebElement addToCartSecondProductButton;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//div[@class='brands-name']/ul/li/a")
    private List<WebElement> listOfProductsElement;

    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    private WebElement madameBrandButton;

    @FindBy(xpath = "//a[@href='/brand_products/Biba']")
    private WebElement bibaBrandButton;

    @FindBy(css = ".btn.btn-default.add-to-cart")
    private List<WebElement> addToCartButtonAllProducts;

    @FindBy(xpath = "//a[normalize-space()='Cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homePageButton;

    public String getAllProductsHead() {
        return allProductsHeadElement.getText();
    }

    public WebElement getListOfAllProductsElement() {
        return listOfAllProductsElement;
    }

    public void clickViewProductButtonOfFirstProduct() {
        viewProductButtonOfFirstProduct.click();
    }

    public void setSearchBox(String product) {
        searchBox.sendKeys(product);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getTitleOfSearchedProducts() {
        return searchedProductsElement.getText();
    }

    public List<String> getListOfSearchedProducts(){
        return listOfSearchedProducts.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void clickAddToCartFirstProductButton() {
        addToCartFirstProductButton.click();
    }

    public void clickAddToCartSecondProductButton() {
        addToCartSecondProductButton.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public List<String> getListOfProducts() {
        return listOfProductsElement.stream().map(element -> element.getText()).collect(Collectors.toList());
    }

    public void clickMadameBrandButton(){
        madameBrandButton.click();
    }

    public void clickBibaBrandButton(){
        bibaBrandButton.click();
    }

    public void clickAddToCartOfAllProducts(){
        for (int i = 0; i <addToCartButtonAllProducts.size(); i+=2) {
            addToCartButtonAllProducts.get(i).click();
            continueShoppingButton.click();
        }
    }

    public void clickCartButton(){
        cartButton.click();
    }

    public void clickHomePageButton(){
        homePageButton.click();
    }

}
