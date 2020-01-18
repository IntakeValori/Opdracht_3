package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;
    private int timeOut = 5;

    private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Heb je een vraag? Laat het ons weten.')]");
    //private By firstnameTextField = By.name("firstname");
    //private By lastnameTextField = By.name("lastname");
    //private By companyTextField = By.name("company");
    //private By emailTextField = By.name("email");
    //private By phoneTextField = By.name("phone");
    //private By messageTextField = By.name("message");
    private By contactFormSubmitButton = By.cssSelector("input[value='Neem contact met mij op']");
    private By errorMessage = By.cssSelector("label[class='hs-error-msg']");
    //String firstname = "Dennis";
    //String lastname = "TestHetWelEven";
    //String company = "MisschienOoitValori";
    //String email = "dennisvanrossum@test.nu";
    //String phone = "0612345678";
    //String message = "Laten we dit even testen";

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public Boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
        return driver.findElement(contactUsPageTitle).isDisplayed();
    }

    public Boolean isContactFormSubmitButtonVisible(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(contactFormSubmitButton));
        //ONDERSTAANDE CLICK ACTIE (REGEL 48) IS BIJ NADER INZIEN NUTTELOOS, WANT ER WORDT EEN CLICK ACTIE UITGEVOERD TERWIJL DE FORM LEEG IS EN DUS GEBEURT ER NIKS.
        //OP REGEL 44 WORDT DE AANWEZIGHEID VAN DE BUTTON AL GETEST EN IN HET KADER VAN SINGLE RESPONSIBILITY ZOU IK REGEL 48 DUS VERWIJDEREN.
        //OM DIT VERHAAL TE VERDUIDELIJKEN HEB IK HEM VOOR NU ECHTER LATEN STAAN. DE NAAM VAN DEZE METHODE HEB IK VERANDERD (WAS isContactFormSubmitButtonClickable).
        driver.findElement(contactFormSubmitButton).click();
        return  driver.findElement(contactFormSubmitButton).isDisplayed();
    }

    public Boolean isErrorMessageVisibleAfterSubmittingNothing(){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return  driver.findElement(errorMessage).isDisplayed();
    }

    public Boolean isItPossibleToFillInContactForm(){
        //DEZE METHODE VOERT ENKEL IETS IN, MAAR AANGEZIEN HET EEN LIVE WEBSITE BETREFT WIL IK DE INGEVULDE FORM NIET SUBMITTEN.
        //IK BEN HET ECHTER MET JE EENS DAT DEZE METHODE OP DEZE MANIER NIET HEEL VEEL WAARDE HEEFT.
        //BIJ EEN TESTWEBSITE ZOU IK DE FORM SUBMITTEN EN EEN ASSERTION DOEN OP DE INGEVULDE GEGEVENS (VOOR ZOVER MOGELIJK).
        //IN DAT GEVAL ZOU IK DEZE METHODE ZOIETS NOEMEN ALS: isContactDataCorrectlySavedAfterSubmitting.
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        //wait.until(ExpectedConditions.presenceOfElementLocated(firstnameTextField)); --> IS VV DOOR:
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
        //driver.findElement(firstnameTextField).click(); --> IS VV DOOR:
        driver.findElement(By.name("firstname")).click();
        //driver.findElement(firstnameTextField).sendKeys(firstname); --> IS VV DOOR:
        driver.findElement(By.name("firstname")).sendKeys("Dennis");
        //driver.findElement(lastnameTextField).click(); --> IS VV DOOR:
        driver.findElement(By.name("lastname")).click();
        //driver.findElement(lastnameTextField).sendKeys(lastname); --> IS VV DOOR:
        driver.findElement(By.name("lastname")).sendKeys("TestHetWelEven");
        //driver.findElement(companyTextField).click(); --> IS VV DOOR:
        driver.findElement(By.name("company")).click();
        //driver.findElement(companyTextField).sendKeys(company); --> IS VV DOOR:
        driver.findElement(By.name("company")).sendKeys("MisschienOoitValori");
        //driver.findElement(emailTextField).click(); --> IS VV DOOR:
        driver.findElement(By.name("email")).click();
        //driver.findElement(emailTextField).sendKeys(email); --> IS VV DOOR:
        driver.findElement(By.name("email")).sendKeys("dennisvanrossum@test.nu");
        //driver.findElement(phoneTextField).click(); --> IS VV DOOR:
        driver.findElement(By.name("phone")).click();
        //driver.findElement(phoneTextField).sendKeys(phone); --> IS VV DOOR:
        driver.findElement(By.name("phone")).sendKeys("0612345678");
        //driver.findElement(messageTextField).click(); --> IS VV DOOR:
        driver.findElement(By.name("message")).click();
        //driver.findElement(messageTextField).sendKeys(message); --> IS VV DOOR:
        driver.findElement(By.name("message")).sendKeys("Laten we dit even testen");
        //return  driver.findElement(firstnameTextField).isDisplayed(); --> IS VV DOOR:
        return  driver.findElement(By.name("firstname")).isDisplayed();
    }

}
