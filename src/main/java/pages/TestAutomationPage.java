package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAutomationPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By testAutomationPageHeader = By.xpath("//h1[contains(text(),'Test automatisering')]");
    private By contactUsButton = By.xpath("//a[contains(text(),'Neem contact op')]");

    public TestAutomationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isTestAutomationPageVisible() {
        waitUntil(testAutomationPageHeader);
        return driver.findElement(testAutomationPageHeader).isDisplayed();
    }

    public void clickContactUsButton() {
        waitUntil(contactUsButton);
        driver.findElement(contactUsButton).click();
    }

    //Not DRY -> implement a BasePage..?
    private void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
