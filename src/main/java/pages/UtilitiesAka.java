
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class UtilitiesAka {

    private WebDriver driver;
    private int timeOut = 10;

    public UtilitiesAka(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public static String ElementAssertAndFill(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("text")));
        driver.findElement(By.xpath("text")).sendKeys("text");
        return ("Element is invulbaar");



    }



}

