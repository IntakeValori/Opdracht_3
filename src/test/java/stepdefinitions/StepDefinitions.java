package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private WebDriver driver;

    public StepDefinitions (){
        this.driver = DriverManager.driver;
    }


    @Given( "^I am on the Valori homepage$" )
    public void iAmOnTheValoriHomepage(){
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible",valoriHomePage.isLogoVisible());
    }

    @And( "^I navigate to the Mobile Chapter page$" )
    public void iNavigateToTheFullStackPage(){
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        valoriHomePage.clickExpertisesDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisibile());
    }

    @Then( "^I can read articles about the Mobile Chapter$" )
    public void iCanReadAboutMobileChapter(){
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        assertTrue(mobileChapterPage.areArticlesVisible());
    }

    @And( "^I contact Valori$" )
    public void iContactValori()throws Throwable{
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        mobileChapterPage.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable() {

        ContactUsPage contactUsPage = new ContactUsPage(driver);

        assertThat(driver.findElement(By.cssSelector("h2:nth-child(9)")).getText(), is("Contactformulier"));

        By submitButton = By.xpath("(//button[@type=\'submit\'])[2]");

        By firstNameField = By.xpath("//input[@id=\'form-input-firstName\']");

        By lastNameField = By.xpath("//input[@id=\'form-input-lastName\']");

        By emailField = By.xpath("//input[@id=\'form-input-email\']");

        By messageField = By.xpath("//textarea[@id=\'form-input-message\']");

        By[] contactPageFields = {firstNameField, lastNameField, emailField, messageField};

        contactUsPage.verifyPageElementsVisible(contactPageFields);

        contactUsPage.verifyFieldsEditable(contactPageFields);

        contactUsPage.isClickable(submitButton);
    }

    @Then("I can send the contact form")
    public void iCanSendTheContactForm() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(9)")).getText(), is("Contactformulier"));

        By submitButton = By.xpath("(//button[@type=\'submit\'])[2]");

        // no actual clicking happens so as not to spam the company
        contactUsPage.isClickable(submitButton);
    }


    @And("I fill it in with legal values for {string}, {string}, {string}, {string}")
    public void iFillItInWithLegalValuesFor(String firstName, String lastName, String email, String message) {
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(9)")).getText(), is("Contactformulier"));

        ContactUsPage contactUsPage = new ContactUsPage(driver);

        By firstNameField = By.xpath("//input[@id=\'form-input-firstName\']");

        By lastNameField = By.xpath("//input[@id=\'form-input-lastName\']");

        By emailField = By.xpath("//input[@id=\'form-input-email\']");

        By messageField = By.xpath("//textarea[@id=\'form-input-message\']");

        By[] contactPageFields = {firstNameField, lastNameField, emailField, messageField};

        String[] inputs = {firstName, lastName, email, message};

        contactUsPage.fillInContactPage(contactPageFields,inputs);
    }
}


