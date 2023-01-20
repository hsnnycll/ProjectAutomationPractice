package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    private WebElement getInTouchMessageElement;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameBox;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailBox;

    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement subjectBox;

    @FindBy(id = "message")
    private WebElement messageBox;

    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileButton;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement statusAlertMessageElement;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homePageButton;

    public String getGetInTouchMessage(){
        return getInTouchMessageElement.getText();
    }

    public void setNameBox(String name){
        nameBox.sendKeys(name);
    }

    public void setEmailBox(String email){
        emailBox.sendKeys(email);
    }

    public void setSubjectBox(String subject){
        subjectBox.sendKeys(subject);
    }

    public void setMessageBox(String message){
        messageBox.sendKeys(message);
    }

    public void setUploadFileButton(String path){
        uploadFileButton.sendKeys(path);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getStatusAlertMessage(){
        return statusAlertMessageElement.getText();
    }

    public void clickHomePageButton(){
        homePageButton.click();
    }
}
