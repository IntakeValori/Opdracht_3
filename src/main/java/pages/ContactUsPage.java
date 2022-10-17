package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Map;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 10;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");
    private By contactForm = By.xpath("//form[@method='post']");
    private By firstNameInputBox=By.xpath("//input[@name='firstName']");
    private By lastNameInputBox=By.id("form-input-lastName");
    private By companyNameInputBox=By.id("form-input-companyName");
    private By phoneNumberInputBox=By.id("form-input-homePhone");
    private By emailInputBox=By.id("form-input-email");
    private By messageInputBox=By.id("form-input-message");
    private By submitBtn=By.xpath("//button[@data-original-text='Versturen']");



    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean contactFormIsAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
         return driver.findElement(contactForm).isEnabled();
    }

    public void navigateToContactUsPage(){
        ValoriHomePage valoriHomePage=new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage=new MobileChapterPage(driver);
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        valoriHomePage.clickCookieConsent();
        valoriHomePage.clickExpertisesDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        mobileChapterPage.clickContactUsButton();

        //switch the tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        contactUsPage.isTitleVisible();
    }

    public void fillContactUsForm(Map<String,String> userInfo) {
       WebDriverWait wait = new WebDriverWait(driver,timeOut);
       wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));

        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameInputBox));
        driver.findElement(firstNameInputBox).sendKeys(userInfo.get("FirstName"));
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameInputBox));
        driver.findElement(lastNameInputBox).sendKeys(userInfo.get("LastName"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyNameInputBox));
        driver.findElement(companyNameInputBox).sendKeys(userInfo.get("CompanyName"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInputBox));
        driver.findElement(phoneNumberInputBox).sendKeys(userInfo.get("TelephoneNumber"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputBox));
        driver.findElement(emailInputBox).sendKeys(userInfo.get("EMail"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageInputBox));
        driver.findElement(messageInputBox).sendKeys(userInfo.get("Message"));
    }

    public Boolean submitBtnIsEnable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
        return driver.findElement(submitBtn).isEnabled();

    }

}
