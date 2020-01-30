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
    private By contactFormSubmitButton = By.cssSelector("input[value='Neem contact met mij op']");
    private By errorMessage = By.cssSelector("label[class='hs-error-msg']");

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean isContactFormSubmitButtonVisible(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactFormSubmitButton));
        return  driver.findElement(contactFormSubmitButton).isDisplayed();
    }

    public Boolean isErrorMessageVisibleAfterSubmittingNothing(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return  driver.findElement(errorMessage).isDisplayed();
    }

    public Boolean isItPossibleToFillInContactForm(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("Dennis");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("TestHetWelEven");
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).sendKeys("MisschienOoitValori");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("dennisvanrossum@test.nu");
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys("0612345678");
        driver.findElement(By.name("message")).click();
        driver.findElement(By.name("message")).sendKeys("Laten we dit even testen");
        return  driver.findElement(By.name("firstname")).isDisplayed();
    }

}
