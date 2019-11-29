package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.text.normalizer.UCharacter;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;
    private int longTimeOut = 10;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Heb je een vraag? Laat het ons weten.')]");
    //Ramazan Uçar:
    private By contactUsFirstName = By.xpath("//input[@name='firstname']");
    private By contactUsLastName = By.xpath("//input[@name='lastname']");
    private By contactUsCompanyName = By.xpath("//input[@name='company']");
    private By contactUsEmail = By.xpath("//input[@type='email']");
    private By contactUsPhoneNumber = By.xpath("//input[@name='phone']");
    private By contactUsYourMessage = By.xpath("//textarea[@name='message']");
    private By contactUsSubmit = By.xpath("//input[@type='submit']");
    private By contactFormIsSend = By.xpath("//h2[contains(text(),'Bedankt voor het invullen')]");


    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver, longTimeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    //Ramazan Uçar:
    public void write_ContactUsFirstName(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, longTimeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsFirstName));
        driver.findElement(contactUsFirstName).sendKeys(firstName);
    }

    public void write_ContactUsLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsLastName));
        driver.findElement(contactUsLastName).sendKeys(lastName);
    }

    public void write_ContactUsCompanyName(String companyName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsCompanyName));
        driver.findElement(contactUsCompanyName).sendKeys(companyName);
    }

    public void write_ContactUsEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsEmail));
        driver.findElement(contactUsEmail).sendKeys(email);
    }

    public void write_ContactUsPhoneNumber(String phone_number) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPhoneNumber));
        driver.findElement(contactUsPhoneNumber).sendKeys(phone_number);

    }

    public void write_ContactUsYourMessage(String your_message) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsYourMessage));
        driver.findElement(contactUsYourMessage).sendKeys(your_message);
    }

    public void click_ContactUsSubmit() {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(contactUsSubmit));
//      driver.findElement(contactUsSubmit).click();
    }

    public boolean control_ContactFormIsSend () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactFormIsSend));
        if (driver.findElement(contactFormIsSend).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }


}
