package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MobileAppTestingPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By mobilePageSlogan = By.xpath("//h1[contains(text(),'Mobiel App testen')]");
    private By articleHeaderBlock = By.xpath("//h2[@class='h1 block__title']/a");

    public MobileAppTestingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isMobilePageVisible(){
        waitUntil(mobilePageSlogan);
        return driver.findElement(mobilePageSlogan).isDisplayed();
    }

    public boolean areArticlesVisible() {
        waitUntil(articleHeaderBlock);
        List<WebElement> allArticles = driver.findElements(articleHeaderBlock);
        for (WebElement article: allArticles) {
            System.out.println(article.getText());
            if(!article.getAttribute("href").contains("https://www.valori.nl/"))
                return false;
        }
        return true;
    }

    //Not DRY -> maybe implement a BasePage?
    private void waitUntil(By element) {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
