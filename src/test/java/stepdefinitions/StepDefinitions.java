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
        valoriHomePage.clickBusinessDropdown();
        valoriHomePage.clickMobileInDropdown();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisibile());
    }

    @Then( "^I can read articles about the Mobile Chapter$" )
    public void iCanReadAboutMobileChapter(){
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        assertTrue("Expecting the articles are visible", mobileChapterPage.areArticlesVisible());
    }

    @And( "^I contact Valori$" )
    public void iContactValori(){
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        mobileChapterPage.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue("Expecting the contact page is visible", contactUsPage.isTitleVisible());
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue("Expecting the contact form submit button is clickable", contactUsPage.isContactFormSubmitButtonClickable());
        assertTrue("Expecting error message when trying to submit empty form", contactUsPage.isErrorMessageVisibleAfterSubmittingNothing());
        assertTrue("Something can be filled in the contact form", contactUsPage.isItPossibleToFillInContactForm());
    }
}


