package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;
import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;

    public StepDefinitions() {
        this.driver = DriverManager.driver;
    }


    @Given("^I am on the Valori homepage$")
    public void iAmOnTheValoriHomepage() {
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible", valoriHomePage.isLogoVisible());
    }

    @And("I navigate to the Mobile Chapter page")
    public void iNavigateToTheMobileChapterPage() {
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        valoriHomePage.clickBusinessDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Mobiel App testen", mobileChapterPage.isMobilePageVisibile());
    }

    @Then("^I can read articles about the Mobile Chapter$")
    public void iCanReadAboutMobileChapter() {
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        assertTrue(mobileChapterPage.areArticlesVisible());
    }

    @And("^I contact Valori$")
    public void iContactValori() throws Throwable {
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        mobileChapterPage.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then("^the contact us form is available$")
    public void theContactUsFormIsAvailable() throws Throwable {
        //TODO IMPLEMENT THIS
        //Verify the contact form fields are available.

        //FirstName
        ContactUsPage contactUsFirstName = new ContactUsPage(driver);
        contactUsFirstName.write_ContactUsFirstName("Ramazan");


        //LastName
        ContactUsPage  contactUsLastName = new ContactUsPage(driver);
        contactUsLastName.write_ContactUsLastName("Ucar");

        //CompanyName
        ContactUsPage contactUsCompanyName = new ContactUsPage(driver);
        contactUsCompanyName.write_ContactUsCompanyName("MobileValori");

        //Email
        ContactUsPage contactUsEmail = new ContactUsPage(driver);
        contactUsEmail.write_ContactUsEmail("RamazanUcar@valori.nl");

        //Phone number
        ContactUsPage contactUsPhoneNumber = new ContactUsPage(driver);
        contactUsPhoneNumber.write_ContactUsPhoneNumber("+31651783353");

        //Your message
        ContactUsPage contactUsYourMessage = new ContactUsPage(driver);
        contactUsYourMessage.write_ContactUsYourMessage("Hallo dit is een test opdracht voor chapter Mobile, Ramazan Ucar");

        //Click_Submit
        ContactUsPage contactUsSubmit = new ContactUsPage(driver);
//        contactUsSubmit.click_ContactUsSubmit();

        //Form is Send
        ContactUsPage contactFormIsSend = new ContactUsPage(driver);
//        assertTrue(contactFormIsSend.control_ContactFormIsSend());

    }


}



