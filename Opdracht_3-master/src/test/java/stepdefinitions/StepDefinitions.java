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

            //Testrunner een pauze geven van 1/4 seconde om stabiliteit te vergroten
            try{
                Thread.sleep(250);
                }
            catch(InterruptedException e)
                {System.out.println("interrupt");}

        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible",valoriHomePage.isLogoVisible());
    }

    @And( "^I navigate to the Mobile Chapter page$" )
    public void iNavigateToTheMobileChapterPage(){
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        valoriHomePage.clickBusinessDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Expecting the Mobile automation header to be visible", mobileChapterPage.isMobilePageVisibile());
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
        driver.navigate().refresh();

            //switch to new tab.
            // Dit zorgt ervoor dat er een tab wordt geopend naar innovation.valori.nl/neem-contact-op
            //Echter moet de link https://innovation.valori.nl/neem-contact-op zijn om de pagina te bereiken.
            //een (minder nette) manier die ik hier gebruik is de tabblad te verversen mbv driver.navigate().refresh() op regel 59
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            assertTrue(contactUsPage.isTitleVisible());
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable() throws Throwable {
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Verify the contact form fields are available.
        if (contactUsPage.isFormAvailable() == false)
        {
            System.out.println("Contact form not available");
        }

        else
        {
            System.out.println("Contact form available");
        }
    //Deze throw snapte ik niet helemaal en heb dit dus eruit gecomment omdat het ervoor zorgde dat de test werd geskipt
        // throw new PendingException();
    }
}


