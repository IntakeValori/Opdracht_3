package stepdefinitions;

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

    // TODO: Depending on how many navigate to page X we will have in the future, we could cluster them in one step. Like: @And( "^I navigate to the page '([^']*)?'$" )
    @And( "^I navigate to the page Mobile Chapter$" )
    public void iNavigateToTheFullStackPage(){
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        valoriHomePage.clickBusinessDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisible());
    }

    @And( "^I navigate to the page Contact Valori$" )
    public void iContactValori()throws Throwable{
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        mobileChapterPage.clickContactUsButton();

        //switch to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then( "^I can read articles about the Mobile Chapter$" )
    public void iCanReadAboutMobileChapter(){
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        assertTrue(mobileChapterPage.areArticlesVisible());
    }

    @And( "^I fill out the contact form (.*)$" )
    public void iFillContactForm(String condition) throws Throwable {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue("Expecting the contact form to be there", contactUsPage.isTitleVisible());
        contactUsPage.FillContactForm(condition);
    }

    @And( "^I submit the contact form$" )
    public void iClickSubmitContactForm()throws Throwable{
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.clickSubmitContactForm();
    }

    @Then( "^I expect an error on the contact form$" )
    public void iCanReadError(){
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertTrue("Expecting the error message to be visible",contactUsPage.IsErrorVisible());
    }
}