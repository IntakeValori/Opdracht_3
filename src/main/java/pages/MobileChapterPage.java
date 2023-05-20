package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MobileChapterPage extends BasePage {
    private final By mobilePageSlogan = By.xpath("//h1[contains(text(),'Mobiel App testen')]");
    private final By articleHeaderBlock = By.xpath("//h2[@class='h1 block__title']/a");

    public MobileChapterPage(WebDriver driver){ super(driver); }

    public boolean isMobilePageVisibile(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(mobilePageSlogan));
        return driver.findElement(mobilePageSlogan).isDisplayed();
    }

    public boolean areArticlesVisible() {
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(articleHeaderBlock));
        List<WebElement> allArticles = driver.findElements(articleHeaderBlock);
        for (WebElement article: allArticles) {
            System.out.println(article.getText());
            if(!article.getAttribute("href").contains("https://www.valori.nl/"))
                return false;
        }
        return true;
    }
}