package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    private int timeOut = 5;
    protected WebDriverWait wait;

    public Page(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeOut);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterTextIntoField(String text, By locator) {
        WebElement locatorElement = driver.findElement(locator);
        locatorElement.click();
        locatorElement.sendKeys(text);
    }
}
