package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");
    private By contactFormFirstName = By.xpath("//input[@name='firstName']");
    private By contactFormLastName = By.xpath("//input[@name='lastName']");
    private By contactFormCompanyName = By.xpath("//input[@name='companyName']");
    private By contactFormTelephoneNumber = By.xpath("//input[@name='homePhone']");
    private By contactFormEmail = By.xpath("//input[@name='email']");
    private By contactFormMessageBox = By.xpath("//textarea[@name='message']");

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        waitUntil(contactUsPageTitle);
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public boolean areFormFieldsVisible() {
        waitUntil(contactFormFirstName);
        return driver.findElement(contactFormFirstName).isDisplayed()&&
                driver.findElement(contactFormLastName).isDisplayed()&&
                driver.findElement(contactFormCompanyName).isDisplayed()&&
                driver.findElement(contactFormTelephoneNumber).isDisplayed()&&
                driver.findElement(contactFormEmail).isDisplayed()&&
                driver.findElement(contactFormMessageBox).isDisplayed();

    }

    public void fillInputField(String inputFieldType, String input) {

        By inputFieldXPath = By.xpath("//label[contains(text(),'"+inputFieldType+"')]//..//*[@class='input ']");
        if (Objects.equals(inputFieldType, "E-mail")||Objects.equals(inputFieldType, "Jouw bericht")){
            inputFieldXPath = By.xpath("//label[contains(text(),'"+inputFieldType+"')]//..//*[@class='input']");
        }
        waitUntil(inputFieldXPath);
        driver.findElement(inputFieldXPath).sendKeys(input);
    }

    //Not DRY -> implement a BasePage...?
    private void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
