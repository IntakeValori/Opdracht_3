package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValoriHomePage {

    private WebDriver driver;
    private int timeOut = 5;

    private By valoriLogo =         By.xpath("//h1[contains(text(),'Innovation starts with testing')]");
    private By businessDropdown =   By.xpath("//span[contains(text(),'Businesses')]");
    private By mobileDropdownItem = By.xpath("//a[contains(text(),'Mobile')]");
    private By cookieAcceptBtn =    By.xpath("//button[@class='cookie-notice__link reset-button']");


    public ValoriHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isLogoVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(valoriLogo));
        return driver.findElement(valoriLogo).isDisplayed();
    }

    public void clickCookieConsent(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookieAcceptBtn));
        driver.findElement(cookieAcceptBtn).click();
    }

    public void clickBusinessDropdown(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(businessDropdown));
        driver.findElement(businessDropdown).click();
    }

    public void clickMobileInDropDOwn(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileDropdownItem));
        driver.findElement(mobileDropdownItem).click();
    }

}
