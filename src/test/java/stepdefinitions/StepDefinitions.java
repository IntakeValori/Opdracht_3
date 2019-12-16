package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;

import java.util.ArrayList;

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
        valoriHomePage.clickBusinessDropDown();
        valoriHomePage.clickMobileInDropDown();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisibile());
    }

    @Then( "^I can read articles about the Mobile Chapter$" )
    public void iCanReadAboutMobileChapter(){
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        assertTrue("Expecting the articles are visible", mobileChapterPage.areArticlesVisible());
    }

    @And( "^I contact Valori$" )
    public void iContactValori() throws Throwable {
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        mobileChapterPage.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //Verify the contact page is present by assertion on page title
        assertTrue("Expecting the contact page is visible", contactUsPage.isTitleVisible());
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable() throws Throwable {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        //Verify the contact form is available by assertion on contact form header
        assertTrue("Expecting the contact form is present", contactUsPage.isContactFormHeaderPresent());
        //Notice that navigating to this contact us form is also possible directly from the main menu
    }
}


