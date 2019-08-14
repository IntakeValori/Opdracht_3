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
        contactUsPage.isTitleVisible();

    }

    @And("^I enter ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
        public void IenterFirstnameLastnameCompanynameEmailPhonenumberMessage(String arg1, String arg2,String arg3,String arg4,String arg5,String arg6) throws Throwable {
        UtilitiesAka aka = new UtilitiesAka(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Nakijken of de contactformulier velden aanwezig zijn en deze ook gelijk invullen.
        aka.ElementAssertAndFill("//input[contains(@id,'firstname-')]", arg1);
        aka.ElementAssertAndFill("//input[contains(@id,'lastname-')]", arg2);
        aka.ElementAssertAndFill("//input[contains(@id,'company-')]",arg3);
        aka.ElementAssertAndFill("//input[contains(@id,'email-')]",arg4);
        aka.ElementAssertAndFill("//input[contains(@id,'phone-')]",arg5);
        aka.ElementAssertAndFill("//textarea[contains(@id,'message-')]",arg6);

        //Kijk of de verstuur button aanwezig is, klik erop en check of de volgende pagina is bereikt.
        //Methode uitgecomment ivm daadwerkelijk versturen van contactformulier
        //aka.ElementAssertClickandTest("//input[@type='submit']","//h2[contains(text(), 'Bedankt voor het invullen. We nemen zo snel mogelijk contact met je op.')]");
    }
}



    //Deze throw snapte ik niet helemaal en heb dit dus eruit gecomment omdat het ervoor zorgde dat de test werd geskipt
        // throw new PendingException();


