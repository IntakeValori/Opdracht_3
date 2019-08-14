
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;


public final class UtilitiesAka {

    private static WebDriver driver;
    private static int timeOut = 10;

    public UtilitiesAka(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public String ElementAssertAndFill(String Element, String Text){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element)));
        driver.findElement(By.xpath(Element)).sendKeys(Text);
        return ("Element is invulbaar");
    }

    public String ElementAssertClickandTest(String Element,String Check){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Element)));
        driver.findElement(By.xpath(Element)).click();
        driver.findElement(By.xpath(Check));
        return ("Pagina is bereikt, Check is aanwezig");
    }



}

