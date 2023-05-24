package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValoriTemplate extends BasePage {
    private final By contactUsButton = By.xpath("//a[contains(text(),'Neem contact op')]");

    public ValoriTemplate(WebDriver driver) { super(driver); }
    public void clickContactUsButton(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsButton));
        driver.findElement(contactUsButton).click();
    }
}