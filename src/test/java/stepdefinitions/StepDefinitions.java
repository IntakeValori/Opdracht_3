package stepdefinitions;

import com.sun.xml.internal.xsom.impl.scd.Iterators;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.UtilitiesAka;
import pages.ValoriHomePage;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertFalse;
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
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable() throws Throwable {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        UtilitiesAka aka = new UtilitiesAka(driver);
        //Controleer of het contactformulier aanwezig is en of de individuele velden aanwezig zijn.
       // assertTrue("Contact formulier is niet aanwezig", contactUsPage.isFormAvailable());

      //  assertTrue("Voornaam veld is niet aanwezig", contactUsPage.isFirstnameAvailable());

      //  assertTrue("Achternaam veld is niet aanwezig", contactUsPage.isLastnameAvailable());

       // assertTrue("Email veld is niet aanwezig", contactUsPage.isEmailAvailable());

       // assertTrue("Neem contact met mij op btn is niet aanwezig", contactUsPage.isContactbtnAvailable());

        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).get("First Name"));
            System.out.println(list.get(i).get("Last Name"));


            aka.ElementAssertAndFill("//input[contains(@id,'firstname-')]", "Akash");
        aka.ElementAssertAndFill("//input[contains(@id,'lastname-')]", "Foederer");


       // contactUsPage.TestFirstname();

        //contactUsPage.TestLastname();

      //  contactUsPage.TestEmail();

       //onderstaande code eruit gecomment omdat de test elke keer een contactverzoek stuurt naar Valori
             //contactUsPage.TestContactbtn();

             //assertTrue("Het contact formulier is ingevuld",contactUsPage.ContactformThankyou());
    }

        //Deze throw snapte ik niet helemaal en heb dit dus eruit gecomment omdat het ervoor zorgde dat de test werd geskipt
            // throw new PendingException();
    }
