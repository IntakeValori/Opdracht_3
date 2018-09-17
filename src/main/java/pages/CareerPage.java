package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By careerPageTitle = By.xpath("//h1[contains(text(), 'Werken bij Valori')]");
    //De header is "Werken bij Valori".

    public CareerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(careerPageTitle));
        return driver.findElement(careerPageTitle).isDisplayed();
    }
}
