package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ValoriHomePage {
    private WebDriver driver;
    private int timeOut = 10;
    @FindBy(xpath ="//button[@class='cookie-notice__link reset-button']" )
    WebElement cookieAcceptBtn;
    @FindBy(xpath = "//span[contains(text(),'Expertises')]")
    WebElement expertisesDropdown;
    @FindBy(xpath = "//a[contains(text(),'Mobiel app testen')]")
    WebElement mobileDropdownItem;
    @FindBy(css = ".nav-bar__logo")
    WebElement valoriLogo;

    public ValoriHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isLogoVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(valoriLogo));
        return  valoriLogo.isDisplayed();
    }
    public void clickCookieConsent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(cookieAcceptBtn));
        cookieAcceptBtn.click();
    }
    public void clickExpertisesDropdown(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(expertisesDropdown));
        expertisesDropdown.click();
    }
    public void clickMobileInDropDOwn(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(mobileDropdownItem));
        mobileDropdownItem.click();
    }
}
