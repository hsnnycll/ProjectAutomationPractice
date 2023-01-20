package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutAndPaymentPage extends BasePage{

    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    private WebElement headAddressDetailsElement;

    @FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
    private WebElement headReviewYourOrderElement;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageBox;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//div/div/input")
    private List<WebElement> listOfPaymentInfosElement;

    @FindBy(id = "submit")
    private WebElement payAndConfirmButton;

    @FindBy(id = "success_message)]")
    private WebElement successMessageElement;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    private WebElement accountDeletedHeadElement;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li")
    private List<WebElement> listOfDeliveryAddressElements;

    @FindBy(xpath = "//*[@id=\"address_invoice\"]/li")
    private List<WebElement> listOfBillingAddressElements;

    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    private WebElement downloadInvoiceButton;

    public String getHeadAddressDetails() {
        return headAddressDetailsElement.getText();
    }

    public String getHeadReviewYourOrder() {
        return headReviewYourOrderElement.getText();
    }

    public void setMessageBox(String message) {
        messageBox.sendKeys(message);
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void setListOfPaymentInfosElement(List<String> list){
        for (int i = 0; i < listOfPaymentInfosElement.size(); i++) {
            listOfPaymentInfosElement.get(i).sendKeys(list.get(i));
        }
    }

    public void clickPayAndConfirmButton(){
        payAndConfirmButton.click();
    }

    public WebElement getSuccessMessageElement(){
        return successMessageElement;
    }

    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public String getAccountDeletedMessage(){
        return accountDeletedHeadElement.getText();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public List<String> getListOfDeliveryAddressInfos() {
        List<String> listOfDeliveryAddressInfos = listOfDeliveryAddressElements.stream().map(element -> element.getText()).collect(Collectors.toList());
        listOfDeliveryAddressInfos.remove(0);
        return listOfDeliveryAddressInfos;
    }

    public List<String> getListOfBillingAddressInfos() {
        List<String> listOfBillingAddressInfos = listOfBillingAddressElements.stream().map(element -> element.getText()).collect(Collectors.toList());
        listOfBillingAddressInfos.remove(0);
        return listOfBillingAddressInfos;
    }

    public void clickDownloadInvoiceButton(){
        downloadInvoiceButton.click();
    }
}
