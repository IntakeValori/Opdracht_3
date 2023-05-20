package pages;

import entities.Persona;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage {
    private final By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");
    private final By sendButton = By.xpath("//button[contains(text(),'Versturen')]");
    private final By firstNameInput = By.xpath("//input[@name='firstName']");
    private final By lastNameInput = By.xpath("//input[@name='lastName']");
    private final By emailInput= By.xpath("//input[@name='email']");
    private final By formInputMessage= By.xpath("//textarea[@name='message']");

    public ContactUsPage(WebDriver driver){ super(driver); }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean isSendButtonEnabled(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(sendButton));
        return driver.findElement(sendButton).isEnabled();
    }

    public void fillForm(Persona persona){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));

        driver.findElement(firstNameInput).sendKeys(persona.firstName);
        driver.findElement(lastNameInput).sendKeys(persona.lastName);
        driver.findElement(emailInput).sendKeys(persona.email);
        driver.findElement(formInputMessage).sendKeys("Lorem ipsum dolor sit amet, consectetur ...");
    }
}