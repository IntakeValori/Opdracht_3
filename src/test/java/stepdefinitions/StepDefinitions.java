package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.Page;
import pages.ValoriHomePage;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class StepDefinitions {
    private WebDriver driver;
    private ValoriHomePage valoriHomePage;
    private ContactUsPage contactUsPage;
    private MobileChapterPage mobileChapterPage;
    private Page page;

    public StepDefinitions() {
        this.driver = DriverManager.driver;
        initPageObjects();
    }

    public void initPageObjects() {
        valoriHomePage = new ValoriHomePage(driver);
        contactUsPage = new ContactUsPage(driver);
        mobileChapterPage = new MobileChapterPage(driver);
        page = new Page(driver);
    }

    @Given("^I am on the Valori homepage$")
    public void iAmOnTheValoriHomepage() {
        // should add loging levels in the future
        System.out.println("This is the Valori page title: " + page.getPageTitle());
        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible", valoriHomePage.isLogoVisible());
        assertThat(page.getPageTitle())
                .as("Page title is not as expected")
                .isEqualTo("Nummer 1 in QA en Testen - Valori");
    }

    @And("^I navigate to the Mobile Chapter page$")
    public void iNavigateToTheFullStackPage() {
        valoriHomePage.clickExpertisesDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisibile());
    }

    @Then("^I can read articles about the Mobile Chapter$")
    public void iCanReadAboutMobileChapter() {
        assertTrue("Expecting the articles to be visible", mobileChapterPage.areArticlesVisible());
    }

    @And("^I contact Valori$")
    public void iContactValori() throws Throwable {
        mobileChapterPage.clickContactUsButton();
        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue("Expecting the title to be visible", contactUsPage.isTitleVisible());
    }

    @Then("^the contact us form is available$")
    public void theContactUsFormIsAvailable() throws Throwable {
        assertTrue("Expecting the first name input field to be visible", contactUsPage.isFirstNameInputFieldVisible());
        assertTrue("Expecting the submit button to be visible", contactUsPage.isSubmitButtonVisible());
    }

    @Then("I fill in all the mandatory fields, {string} , {string}, {string}")
    public void iFillInTheMandatoryFields(String firstName, String lastName, String email) {
        contactUsPage.fillInFirstName(firstName);
        contactUsPage.fillInLastName(lastName);
        contactUsPage.fillInEmail(email);
        assertThat(contactUsPage.getFilledInFirstName())
                .as("First name is not as expected")
                .isEqualTo(firstName);
        assertThat(contactUsPage.getFilledInLastName())
                .as("Last name is not as expected")
                .isEqualTo(lastName);
        assertThat(contactUsPage.getFilledInEmail())
                .as("Email is not as expected")
                .isEqualTo(email);
    }


    @Then("I fill in all the remaining fields, {string}, {string}, {string}")
    public void iFillInAllTheRemainingFields(String companyName, String phoneNumber, String message) {
        contactUsPage.fillInCompanyName(companyName);
        contactUsPage.fillInPhoneNumber(phoneNumber);
        contactUsPage.fillInMessage(message);
        assertThat(contactUsPage.getFilledInCompanyName())
                .as("Company name is not as expected")
                .isEqualTo(companyName);
        assertThat(contactUsPage.getFilledInPhoneNumber())
                .as("Phone number is not as expected")
                .isEqualTo(phoneNumber);
        assertThat(contactUsPage.getFilledInMessage())
                .as("Message is not as expected")
                .isEqualTo(message);
    }
}


