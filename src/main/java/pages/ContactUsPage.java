package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 10;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Heb je een vraag? Laat het ons weten.')]");
    private By contactForm = By.xpath ("//h3[contains(text(), 'Contact formulier')]");
    private By ContactButton = By.xpath ("//input[@type='submit']");
    private By Thankyou = By.xpath("//h2[contains(text(), 'Bedankt voor het invullen. We nemen zo snel mogelijk contact met je op.')]");


    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;

    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }


    public Boolean isFormAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        return driver.findElement(contactForm).isDisplayed();
        }

    public Boolean isContactbtnAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        return driver.findElement(ContactButton).isDisplayed();
    }


    public void TestContactbtn(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContactButton));
        driver.findElement(ContactButton).click();
    }

    public boolean ContactformThankyou (){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(Thankyou));
        return driver.findElement(Thankyou).isDisplayed();
    }

}
