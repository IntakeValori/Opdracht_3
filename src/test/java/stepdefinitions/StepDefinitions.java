package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.MobileAppTestingPage;
import pages.TestAutomationPage;
import pages.ValoriHomePage;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {

    private ValoriHomePage valoriHomePage;
    private MobileAppTestingPage mobileAppTestingPage;
    private ContactUsPage contactUsPage;
    private TestAutomationPage testAutomationPage;
    private WebDriver driver;

    public StepDefinitions() {
        this.driver = DriverManager.driver;
    }

    @Given("^I am on the Valori homepage$")
    public void iAmOnTheValoriHomepage() {
        valoriHomePage = new ValoriHomePage(driver);
        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible", valoriHomePage.isLogoVisible());
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String page) {

        switch (page) {
            case "Mobile app testing":
                mobileAppTestingPage = new MobileAppTestingPage(driver);
                valoriHomePage.clickExpertisesDropdown();
                valoriHomePage.clickMobileAppTestingInDropDown();
                assertTrue("Expecting the mobile app testing header to be visible", mobileAppTestingPage.isMobilePageVisible());
                break;
            case "Test automation":
                testAutomationPage = new TestAutomationPage(driver);
                valoriHomePage.clickExpertisesDropdown();
                valoriHomePage.clickTestAutomationInDropDown();
                assertTrue("Expecting the test automation header to be visible", testAutomationPage.isTestAutomationPageVisible());
                break;
            default:
                throw new NotImplementedException();
        }
    }

    @Then("^I can read articles about mobile app testing$")
    public void iCanReadAboutMobileChapter() {
        assertTrue(mobileAppTestingPage.areArticlesVisible());
    }

    @When("^I contact Valori$")
    public void iContactValori() throws Throwable {
        contactUsPage = new ContactUsPage(driver);
        testAutomationPage.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then("^the contact us form is available$")
    public void theContactUsFormIsAvailable() throws Throwable {
        assertTrue(contactUsPage.areFormFieldsVisible());
    }

    @Then("I can fill the {string} input field in the contact form with {string}")
    public void iCanFillTheInputFieldInTheContactFormWith(String inputFieldType, String input) {
        contactUsPage.fillInputField(inputFieldType, input);
        //how to validate that the input fields are filled?
        assertTrue(contactUsPage.areFormFieldsVisible());

    }
}


