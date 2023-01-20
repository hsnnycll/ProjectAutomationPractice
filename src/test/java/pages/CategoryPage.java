package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{

    @FindBy(css = ".title.text-center")
    private WebElement titleTextElement;

    @FindBy(xpath = "//a[normalize-space()='Men']")
    private WebElement menCategoryButton;

    @FindBy(xpath = "//a[normalize-space()='Tshirts']")
    private WebElement tshirtsBelowMenCategoryButton;

    public String getTitleTextMessage(){
        return titleTextElement.getText();
    }

    public void clickMenCategoryButton(){
        menCategoryButton.click();
    }

    public void clickTshirtsBelowMenCategoryButton(){
        tshirtsBelowMenCategoryButton.click();
    }
}
