package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;
    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Heb je een vraag? Laat het ons weten.')]");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//label[contains(text(),'Vul alle verplichte velden')]");

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public void FillContactForm(String condition){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
        if (condition.equals("with insufficient details")){
            driver.findElement(By.name("firstname")).sendKeys("Voornaam");
        }
        else {
            // fill Contact form with all the details
            driver.findElement(By.name("firstname")).sendKeys("Matthijs");
            driver.findElement(By.name("lastname")).sendKeys("Breeman");
            driver.findElement(By.name("email")).sendKeys("matthijsbreeman@hotmail.com");
            driver.findElement(By.name("message")).sendKeys("Dit is een automatisch verstuurd bericht");
        }
    }

    public void clickSubmitContactForm(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public Boolean IsErrorVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }
}
