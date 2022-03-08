package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");
    private By firstName = By.id("form-input-firstName");
    private By lastName = By.id("form-input-lastName");
    private By companyName = By.id ("form-input-companyName");
    private By phone = By.id("form-input-homePhone");
    private By email = By.id("form-input-email");
    private By message = By.id("form-input-message");
    private By sendButton = By.xpath("/html/body/div[2]/main/div/section/article/div[2]/form/fieldset/div[5]/button");


    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean isFirstnameVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
        return driver.findElement(firstName).isDisplayed();
    }

    public Boolean isLastnameVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(lastName));
        return driver.findElement(lastName).isDisplayed();
    }

    public Boolean isCompanyVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(companyName));
        return driver.findElement(companyName).isDisplayed();
    }

    public Boolean isPhoneVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(phone));
        return driver.findElement(phone).isDisplayed();
    }

    public Boolean isEmailVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(email));
        return driver.findElement(email).isDisplayed();
    }

    public Boolean isMessageVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        return driver.findElement(message).isDisplayed();
    }
    public Boolean isSendVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(sendButton));
        return driver.findElement(sendButton).isDisplayed();
    }

}
