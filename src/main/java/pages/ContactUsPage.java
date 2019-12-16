package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By contactUsPageTitle = By.id("hs_cos_wrapper_module_1556139453617195_");
    private By contactFormHeader = By.id("hs_cos_wrapper_module_1556196215775883_title");

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean isContactFormHeaderPresent(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactFormHeader));
        return driver.findElement(contactFormHeader).isDisplayed();
    }

}
