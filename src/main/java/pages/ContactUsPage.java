package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.util.List;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public void fillInField(By field, String input){
        driver.findElement(field).sendKeys(input);
    }

    public void fillInContactPage(By[] fields, String[] inputs){
        for (int i = 0; i < fields.length; i++){
            fillInField(fields[i], inputs[i]);
        }
    }

    public void verifyPageElementVisible(By field){
        List<WebElement> elements = driver.findElements(field);
        assert(elements.size() > 0);
    }

    public void verifyPageElementsVisible(By[] field){
        for (int i = 0; i < field.length; i++){
            verifyPageElementVisible(field[i]);
        }
    }

    public void verifyFieldEditable(By field){
        WebElement element = driver.findElement(field);
        Boolean isEditable = element.isEnabled() && element.getAttribute("readonly") == null;
        assertTrue(isEditable);
    }

    public void verifyFieldsEditable(By[] field){
        for (int i = 0; i < field.length; i++){
            verifyFieldEditable(field[i]);
        }

    }

    public void isClickable(By field){
        List<WebElement> elements = driver.findElements(field);
        assert(elements.size() > 0);
    }
}
