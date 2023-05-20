package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerformanceTesten extends BasePage {
    private final By performancePageTitle = By.xpath("//h1[contains(text(), 'Performance testen')]");

    public PerformanceTesten(WebDriver driver) { super(driver); }

    public boolean isPerformancePageSloganVisibile() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(performancePageTitle));
        return driver.findElement(performancePageTitle).isDisplayed();
    }
}