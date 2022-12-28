package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage extends Page{

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");
    private By contactUsFirstNameInputField = By.cssSelector("input[name='firstName']");
    private By contactUsLastNameInputField = By.cssSelector("input[name='lastName']");
    private By contactUsEmailInputField = By.cssSelector("input[name='email']");
    private By contactUsCompanyNameInputField = By.cssSelector("input[name='companyName']");
    private By contactUsPhoneNumberInputField = By.cssSelector("input[name='homePhone']");
    private By contactUsMessageInputField = By.cssSelector("textarea[name='message']");
    private By submitButton = By.cssSelector(".block-button.block-button--primary");
//    private By firstName

    public ContactUsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public Boolean isTitleVisible(){
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }
//
    public Boolean isFirstNameInputFieldVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsFirstNameInputField));
        return driver.findElement(contactUsFirstNameInputField).isDisplayed();
    }

    public Boolean isSubmitButtonVisible(){
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
        return driver.findElement(submitButton).isDisplayed();
    }
    public void fillInFirstName(String firstName){
        driver.findElement(contactUsFirstNameInputField).click();
        driver.findElement(contactUsFirstNameInputField).sendKeys(firstName);
    }
    public void fillInLastName(String lastName){
        driver.findElement(contactUsLastNameInputField).click();
        driver.findElement(contactUsLastNameInputField).sendKeys(lastName);
    }
    public void fillInEmail(String email){
        driver.findElement(contactUsEmailInputField).click();
        driver.findElement(contactUsEmailInputField).sendKeys(email);
    }
    public void fillInCompanyName(String email){
        driver.findElement(contactUsCompanyNameInputField).click();
        driver.findElement(contactUsCompanyNameInputField).sendKeys(email);
    }
    public void fillInPhoneNumber(String email){
        driver.findElement(contactUsPhoneNumberInputField).click();
        driver.findElement(contactUsPhoneNumberInputField).sendKeys(email);
    }
    public void fillInMessage(String email){
        driver.findElement(contactUsMessageInputField).click();
        driver.findElement(contactUsMessageInputField).sendKeys(email);
    }
    public String getFilledInFirstName() {
        return driver.findElement(contactUsFirstNameInputField).getAttribute("value");
    }
    public String getFilledInLastName() {
        return driver.findElement(contactUsLastNameInputField).getAttribute("value");
    }
    public String getFilledInEmail() {
        return driver.findElement(contactUsEmailInputField).getAttribute("value");
    }
    public String getFilledInCompanyName() {
        return driver.findElement(contactUsCompanyNameInputField).getAttribute("value");
    }
    public String getFilledInPhoneNumber() {
        return driver.findElement(contactUsPhoneNumberInputField).getAttribute("value");
    }
    public String getFilledInMessage() {
        return driver.findElement(contactUsMessageInputField).getAttribute("value");
    }
}
