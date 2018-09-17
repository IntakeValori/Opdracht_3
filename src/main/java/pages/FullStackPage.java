package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FullStackPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By fullStackHeader = By.xpath("//h2[contains(text(),'Full Stack Chapters')]");
    private By comeAndDanceButton = By.xpath("//*[@title='Come and dance']");
    private By contactUsButton = By.xpath("//a[@class='cta_button Neem-contact-op']");

    public FullStackPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isFullStackHeaderVisibile(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(fullStackHeader));
        return driver.findElement(fullStackHeader).isDisplayed();
    }

    public void clickTheComeAndDanceButton(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(comeAndDanceButton));
        driver.findElement(comeAndDanceButton).click();
    }

    public void clickContactUsButton()throws Throwable{
        Thread.sleep(300);
        driver.findElement(contactUsButton).click();
    }
}
