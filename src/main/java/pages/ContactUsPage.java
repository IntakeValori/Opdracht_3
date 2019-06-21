package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 10;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Heb je een vraag? Laat het ons weten.')]");
    private By contactForm = By.xpath ("//h3[contains(text(), 'Contact formulier')]");
    private By FirstName = By.xpath ("//input[contains(@id,'firstname-')]");
    private By LastName = By.xpath ("//input[contains(@id,'lastname-')]");
    private By Email = By.xpath ("//input[contains(@id,'email-')]");
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

    public Boolean isFirstnameAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        return driver.findElement(FirstName).isDisplayed();
    }
    public Boolean isLastnameAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        return driver.findElement(LastName).isDisplayed();
    }
    public Boolean isEmailAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        return driver.findElement(Email).isDisplayed();
    }
    public Boolean isContactbtnAvailable(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        return driver.findElement(ContactButton).isDisplayed();
    }

    public String TestFirstname(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        driver.findElement(FirstName).sendKeys("Akash13!" );
        driver.findElement(ContactButton).click();
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys("12345" );
        driver.findElement(ContactButton).click();
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys("@adj!" );
        driver.findElement(ContactButton).click();
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys("Akash" );
        return ("Voornaam is invulbaar");
    }
    public String TestLastname(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        driver.findElement(LastName).sendKeys("Foederer247284");
        driver.findElement(ContactButton).click();
        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys("84141");
        driver.findElement(ContactButton).click();
        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys("!@&!^");
        driver.findElement(ContactButton).click();
        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys("Foederer");

        return ("Achternaam is invulbaar");
    }
    public String TestEmail(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactForm));
        driver.findElement(Email).sendKeys("akashfoederer@valori.");
        driver.findElement(ContactButton).click();
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys("akashfoederer@valori.n");
        driver.findElement(ContactButton).click();
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys("akashfoederer@valori.nl");

        return ("Email is invulbaar");
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
