package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.CareerPage;
import pages.ContactUsPage;
import pages.FullStackPage;
import pages.ValoriHomePage;

import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;

    public StepDefinitions (){
        this.driver = DriverManager.driver;
    }


    @Given( "^I am on the Valori homepage$" )
    public void iAmOnTheValoriHomepage(){
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        assertTrue("Expecting the innovation header to be visible",valoriHomePage.isInnovationHeaderVisible());
    }

    @And( "^I navigate to the Full Stack page$" )
    public void iNavigateToTheFullStackPage(){
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        FullStackPage fullStackPage = new FullStackPage(driver);
        valoriHomePage.clickFullStackTile();
        assertTrue("Expecting the full stack header to be visible",fullStackPage.isFullStackHeaderVisibile());
    }

    @Then( "^I want to come and dance$" )
    public void iWantToComeAndDance(){
        FullStackPage fullStackPage = new FullStackPage(driver);
        CareerPage careerPage = new CareerPage(driver);
        fullStackPage.clickTheComeAndDanceButton();
        assertTrue(careerPage.isTitleVisible());
    }

    @And( "^I contact Valori$" )
    public void iContactValori()throws Throwable{
        FullStackPage fullStackPage = new FullStackPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        fullStackPage.clickContactUsButton();
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable() throws Throwable {

        throw new PendingException();
    }
}


