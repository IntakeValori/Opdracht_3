package stepdefinitions;

import api.RandomApi;
import entities.Persona;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private final WebDriver driver;
    private Persona persona;

    public StepDefinitions() {
        this.driver = DriverManager.driver;
        this.persona = new Persona();
    }

    @Given("^I am on the Valori homepage$")
    public void iAmOnTheValoriHomepage() {
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible", valoriHomePage.isLogoVisible());
    }

    @And("^I navigate to the Mobile Chapter page$")
    public void iNavigateToTheFullStackPage() {
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        valoriHomePage.clickExpertisesDropdown();
        valoriHomePage.clickMobileInDropDown();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisibile());
    }

    @Then("^I can read articles about the Mobile Chapter$")
    public void iCanReadAboutMobileChapter() {
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        assertTrue(mobileChapterPage.areArticlesVisible());
    }

    @And("^I contact Valori$")
    public void iContactValori() {
        ValoriTemplate page = new ValoriTemplate(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        page.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then("^the contact us form is available$")
    public void theContactUsFormIsAvailable() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue(contactUsPage.isSendButtonEnabled());
    }

    @And("^I navigate to the performance testing page$")
    public void iNavigateToThePerformanceTestingPage() {
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        PerformanceTesten performanceTestenPage = new PerformanceTesten(driver);

        valoriHomePage.clickExpertisesDropdown();
        valoriHomePage.clickPerformanceInDropDown();

        assertTrue("Expecting the full stack header to be visible", performanceTestenPage.isPerformancePageSloganVisibile());
    }

    @And("^I fill in the form$")
    public void iFillInTheForm() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillForm(persona);
    }

    @Then("^the contact send button is clickable$")
    public void theContactSendButtonIsClickable() {
        // this is a copy of theContactUsFormIsAvailable() due to that we don't want any side-effects on production
        // (that would be mail to our colleagues)
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue(contactUsPage.isSendButtonEnabled());
    }

    @And("^I get random persona from random Api$")
    public void apiCall() throws Exception {
        RandomApi randomApi = new RandomApi();
        this.persona = randomApi.getRandomPersona();

        // Asserting that this persona is no longer the default
        Persona defaultPersona = new Persona();
        assertNotEquals(this.persona.firstName, defaultPersona.firstName);
    }
}