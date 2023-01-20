package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignupPage extends BasePage{

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    private WebElement enterAccountInformationMessageElement;

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement titleForMen;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement titleForWomen;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordBox;

    @FindBy(id = "days")
    private WebElement dateOfBirthDays;

    @FindBy(id = "months")
    private WebElement dateOfBirthMonths;

    @FindBy(id = "years")
    private WebElement dateOfBirthYears;

    @FindBy(id = "newsletter")
    private WebElement checkBoxNewsletter;

    @FindBy(id = "optin")
    private WebElement checkBoxSpecialOffers;

    @FindBy(xpath = "/html/body/section/div/div/div/div/form/p/input")
    private List<WebElement> listOfAddressInformationElements;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement dropdownCountry;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;


    public String getEnterAccountInfoMessage(){
        return enterAccountInformationMessageElement.getText();
    }

    public void selectTitleMen(){
        titleForMen.click();
    }

    public void selectTitleWomen(){
        titleForWomen.click();
    }

    public void setPasswordBox(String password){
        passwordBox.sendKeys(password);
    }

    public void setDateOfBirth(String day, String month, String year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    private void setDay(String day) {
        Select select = new Select(dateOfBirthDays);
        select.selectByVisibleText(day);
    }

    private void setMonth(String month){
        Select select = new Select(dateOfBirthMonths);
        select.selectByVisibleText(month);
    }

    private void setYear(String year) {
        Select select = new Select(dateOfBirthYears);
        select.selectByVisibleText(year);
    }

    public void selectCheckBoxNewsletter(){
        checkBoxNewsletter.click();
    }

    public void selectCheckBoxSpecialOffers(){
        checkBoxSpecialOffers.click();
    }

    public void setAddressInformationElements(List<String> listOfInformation){
        for (int i = 0; i < listOfAddressInformationElements.size(); i++) {
            listOfAddressInformationElements.get(i).sendKeys(listOfInformation.get(i));
        }
    }

    public void setDropdownCountry(String country) {
        Select select = new Select(dropdownCountry);
        select.selectByVisibleText(country);
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }


}
