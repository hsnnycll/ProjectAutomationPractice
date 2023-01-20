package automationExerciseTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.Pages;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected Pages pages = new Pages();
    String URL = ConfigurationReader.getProperty("url");
    String browser = ConfigurationReader.getProperty("browser");


    @BeforeSuite
    public void setUpSuite(){
        String environment = ConfigurationReader.getProperty("environment");
        System.out.println(":::::::::TEST INFORMATION:::::::::\n\tURL:" + URL + "\n\tBrowser:" + browser + "\n\tEnvironment:" + environment);
    }

    @BeforeTest
    public void getDriverAndURL() throws InterruptedException {
        Driver.getDriver().get(URL);
        if(browser.equals("chrome")) {
            BrowserUtils.closeAdBlockerPage();
        }
    }

    @AfterSuite
    public void tearDown(){
        Driver.getDriver().quit();
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\test-output\\" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "\\test-output\\" + testCaseName + ".png";
    }
}
