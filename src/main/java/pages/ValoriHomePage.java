package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValoriHomePage extends BasePage {
    private final By valoriLogo = By.cssSelector(".nav-bar__logo");
    private final By expertisesDropdown = By.xpath("//span[contains(text(),'Expertises')]");
    private final By mobileDropdownItem = By.xpath("//a[contains(text(),'Mobiel app testen')]");
    private final By cookieAcceptBtn = By.xpath("//button[@class='cookie-notice__link reset-button']");
    private final By performanceDropdownItem = By.xpath("//a[contains(text(), 'Performance testen')]");

    public ValoriHomePage(WebDriver driver) { super(driver); }

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

    public void clickExpertisesDropdown(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(expertisesDropdown));
        driver.findElement(expertisesDropdown).click();
    }

    public void clickMobileInDropDown(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileDropdownItem));
        driver.findElement(mobileDropdownItem).click();
    }

    public void clickPerformanceInDropDown(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(performanceDropdownItem));
        driver.findElement(performanceDropdownItem).click();
    }
}