package stepdefinitions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.UtilitiesAka;
import pages.ValoriHomePage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertFalse;
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

    @And("^I navigate to the Mobile Chapter page$")
    public void iNavigateToTheMobileChapterPage() {
        ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
        MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
        valoriHomePage.clickBusinessDropdown();
        valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Expecting the Mobile automation header to be visible", mobileChapterPage.isMobilePageVisibile());
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
        driver.navigate().refresh();

        //switch to new tab.
        // Dit zorgt ervoor dat er een tab wordt geopend naar innovation.valori.nl/neem-contact-op
        //Echter moet de link https://innovation.valori.nl/neem-contact-op zijn om de pagina te bereiken.
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        //nakijken of de juiste pagina is bereikt.
        assertTrue(contactUsPage.isTitleVisible());
    }

    @Then("^the contact us form is available$")
    public void theContactUsFormIsAvailable() throws Throwable {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        //nakijken of het contactformulier aanwezig is.
        assertTrue(contactUsPage.isFormAvailable());

    }

    @Given("^fill the contact form with the following data$")
        public void fillContactForm(DataTable exampleTable) throws Throwable {
            UtilitiesAka aka = new UtilitiesAka(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        //Nakijken of de contactformulier velden aanwezig zijn en deze ook gelijk invullen.
        List<Map<String, String>> list = exampleTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            aka.ElementAssertAndFill("//input[contains(@id,'firstname-')]",(list.get(i).get("First name")));
            aka.ElementAssertAndFill("//input[contains(@id,'lastname-')]",(list.get(i).get("Last name")));
            aka.ElementAssertAndFill("//input[contains(@id,'company-')]",(list.get(i).get("Company name")));
            aka.ElementAssertAndFill("//input[contains(@id,'email-')]",(list.get(i).get("Email")));
            aka.ElementAssertAndFill("//input[contains(@id,'phone-')]",(list.get(i).get("Phonenumber")));
            aka.ElementAssertAndFill("//textarea[contains(@id,'message-')]",(list.get(i).get("Message")));

            }
        //nakijken of button aanwezig is en deze daarna ook klikken. klik functie uitgezet ivm daadwerkelijk sturen van formulier.
        assertTrue(contactUsPage.isContactbtnAvailable());
       //contactUsPage.TestContactbtn();

        //nakijken of het versturen echt gebeurd is op basis van het dank je wel bericht.
        //assertTrue(contactUsPage.ContactformThankyou());
        }

        //Deze throw snapte ik niet helemaal en heb dit dus eruit gecomment omdat het ervoor zorgde dat de test werd geskipt
        // throw new PendingException();
    }

