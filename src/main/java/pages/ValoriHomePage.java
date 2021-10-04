package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValoriHomePage {

    private WebDriver driver;
    private int timeOut = 5;

    private By valoriLogo = By.cssSelector(".nav-bar__logo");
    private By expertisesDropdown = By.xpath("//span[contains(text(),'Expertises')]");
    private By mobileAppTestingDropdownItem = By.xpath("//a[contains(text(),'Mobiel app testen')]");
    private By testAutomationDropdownItem = By.xpath("//a[contains(text(),'Testautomatisering')]");
    private By cookieAcceptBtn = By.xpath("//button[@class='cookie-notice__link reset-button']");


    public ValoriHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isLogoVisible(){
        waitUntil(valoriLogo);
        return driver.findElement(valoriLogo).isDisplayed();
    }

     public void clickCookieConsent(){
         waitUntil(cookieAcceptBtn);
        driver.findElement(cookieAcceptBtn).click();
    }

    public void clickExpertisesDropdown(){
        waitUntil(expertisesDropdown);
        driver.findElement(expertisesDropdown).click();
    }

    public void clickMobileAppTestingInDropDown(){
        waitUntil(mobileAppTestingDropdownItem);
        driver.findElement(mobileAppTestingDropdownItem).click();
    }

    public void clickTestAutomationInDropDown(){
        waitUntil(testAutomationDropdownItem);
        driver.findElement(testAutomationDropdownItem).click();
    }

    //Not DRY -> implement a BasePage...?
    private void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
