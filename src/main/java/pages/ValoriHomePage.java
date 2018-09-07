package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValoriHomePage {

    private WebDriver driver;
    private int timeOut = 5;

    private By innovationHeader = By.xpath("//h1[contains(text(), 'Innovation starts with Testing')]");
    private By fullStackTile = By.xpath("//p[contains(text(),'Full Stack')]");

    public ValoriHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isInnovationHeaderVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(innovationHeader));
        return driver.findElement(innovationHeader).isDisplayed();
    }

    public void clickFullStackTile(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullStackTile));
        driver.findElement(fullStackTile).click();

    }

}
