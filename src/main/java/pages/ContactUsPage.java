package pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ContactUsPage {
    private WebDriver driver;
    @FindBy(xpath = "//h1[contains(text(),'Contact')]")
    WebElement contactUsPageTitle;
    @FindBy(id = "form-input-companyName")
    WebElement companyName;
    @FindBy(id ="form-input-email")
    WebElement email;
    @FindBy(id="form-input-firstName")
    WebElement firstname;
    @FindBy(tagName = "fieldset")
    WebElement form;
    @FindBy(id = "form-input-lastName")
    WebElement lastname;
    @FindBy(id ="form-input-message")
    WebElement message;
    @FindBy(id = "form-input-homePhone")
    WebElement phoneNumber;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;
    private int timeOut = 10;

    public ContactUsPage(WebDriver driver) {

        this.driver = driver;
    }
    public Boolean isTitleVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(contactUsPageTitle));
        return contactUsPageTitle.isDisplayed();
    }

    public Boolean isFormVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(form));
        return form.isDisplayed();
    }
//This method clears form fields in "for loop" as we do not want to submit a form.
    public void clearFormFields() {
        firstname.clear();
        lastname.clear();
        companyName.clear();
        phoneNumber.clear();
        email.clear();
        message.clear();
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }
    public void submitForm(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> users = dataTable.asMaps();
        for (Map<String, String> e : users) {
            String companyNameData = "Company name";
            String phoneNumberData = "Phone number";
            firstname.sendKeys(e.get("Firstname"));
            lastname.sendKeys(e.get("Lastname"));
            if (e.get(companyNameData).isEmpty()) {
                stringType(companyNameData);
            }
            companyName.sendKeys(e.get(companyNameData));
            if (e.get(phoneNumberData).isEmpty()) {
                stringType(phoneNumberData);
            }
            phoneNumber.sendKeys(e.get(phoneNumberData));
            email.sendKeys(e.get("E-mail"));
            message.sendKeys(e.get("Message"));
            Thread.sleep(5000);
            clearFormFields();
            //Commented out for obvious reasons:
             //driver.findElement(submitButton).click();
        }
    }
}
