package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Heb je een vraag? Laat het ons weten.')]");
    private By firstnameTextField = By.name("firstname");
    private By lastnameTextField = By.name("lastname");
    private By companyTextField = By.name("company");
    private By emailTextField = By.name("email");
    private By phoneTextField = By.name("phone");
    private By messageTextField = By.name("message");
    private By contactFormSubmitButton = By.cssSelector("input[value='Neem contact met mij op']");
    private By errorMessage = By.cssSelector("label[class='hs-error-msg']");
    String firstname = "Dennis";
    String lastname = "TestHetWelEven";
    String company = "MisschienOoitValori";
    String email = "dennisvanrossum@gmail.com";
    String phone = "0612345678";
    String message = "Laten we dit even testen";

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean isContactFormSubmitButtonClickable(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactFormSubmitButton));
        driver.findElement(contactFormSubmitButton).click();
        return  driver.findElement(contactFormSubmitButton).isDisplayed();
    }

    public Boolean isErrorMessageVisibleAfterSubmittingNothing(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return  driver.findElement(errorMessage).isDisplayed();
    }

    public Boolean isItPossibleToFillInContactForm(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(firstnameTextField));
        driver.findElement(firstnameTextField).click();
        driver.findElement(firstnameTextField).sendKeys(firstname);
        driver.findElement(lastnameTextField).click();
        driver.findElement(lastnameTextField).sendKeys(lastname);
        driver.findElement(companyTextField).click();
        driver.findElement(companyTextField).sendKeys(company);
        driver.findElement(emailTextField).click();
        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(phoneTextField).click();
        driver.findElement(phoneTextField).sendKeys(phone);
        driver.findElement(messageTextField).click();
        driver.findElement(messageTextField).sendKeys(message);
        return  driver.findElement(firstnameTextField).isDisplayed();
    }

}
