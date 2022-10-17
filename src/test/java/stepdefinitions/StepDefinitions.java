package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;

import java.util.ArrayList;
import java.util.Map;

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
    public void theContactUsFormIsAvailable() throws Throwable {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        assertTrue(contactUsPage.contactFormIsAvailable());
    }

    @Given("The user is on the contact us page")
    public void theUserIsOnTheContactUsPage() {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.navigateToContactUsPage();

    }

    @When("The user fills the contact us form the following details")
    public void theUserFillsTheFormTheFollowingDetails(Map<String,String> userInfo){
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        contactUsPage.fillContactUsForm(userInfo);

    }

    @Then("The user should be able to submit a message")
    public void theUserShouldBeAbleToSubmitAMessage() {
        ContactUsPage contactUsPage=new ContactUsPage(driver);
        assertTrue(contactUsPage.submitBtnIsEnable());

    }
}


