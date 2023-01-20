package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;

    @FindBy(css = "h2[class='title text-center'] b")
    private WebElement accountMessageElement;

    public void clickContinueButton(){
        continueButton.click();
    }

    public String getAccountMessage(){
        return accountMessageElement.getText();
    }
}
