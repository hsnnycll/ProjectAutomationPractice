package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailAddressBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement loginPasswordBox;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement signupNameBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement signupEmailAddressBox;

    @FindBy(xpath = "//button[normalize-space()='Signup']")
    private WebElement signupButton;

    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    private WebElement newUserSignupMessageElement;

    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    private WebElement loginYourAccountMessageElement;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    private WebElement incorrectEmailOrPasswordMessageElement;

    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    private WebElement emailAddressAlreadyExistMessageElement;


    public void setLoginEmailAddressBox(String emailAddress) {
        loginEmailAddressBox.sendKeys(emailAddress);
    }

    public void setLoginPasswordBox(String password) {
        loginPasswordBox.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void setSignupNameBox(String name) {
        signupNameBox.sendKeys(name);
    }

    public void setSignupEmailAddressBox(String emailAddress) {
        signupEmailAddressBox.sendKeys(emailAddress);
    }

    public void clickSignupButton(){
        signupButton.click();
    }

    public String getNewUserSignupMessage(){
        return newUserSignupMessageElement.getText();
    }

    public String getLoginYourAccountMessage(){
        return loginYourAccountMessageElement.getText();
    }

    public WebElement getIncorrectEmailOrPasswordMessageElement(){
        return incorrectEmailOrPasswordMessageElement;
    }

    public String getEmailAddressAlreadyExistMessage(){
        return emailAddressAlreadyExistMessageElement.getText();
    }

    public void clearLoginPasswordBox(){
        loginPasswordBox.clear();
    }
}
