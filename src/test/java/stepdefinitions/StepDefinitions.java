package stepdefinitions;

import Utils.GenericUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;
import static org.junit.Assert.assertTrue;
public class StepDefinitions {
    ValoriHomePage valoriHomePage;
    MobileChapterPage mobileChapterPage;
    ContactUsPage contactUsPage;
    GenericUtils genericUtils;
    private WebDriver driver;
    public StepDefinitions() {
        this.driver = DriverManager.driver;
    }
    @Given("^I am on the Valori homepage$")
    public void iAmOnTheValoriHomepage() {
        valoriHomePage = PageFactory.initElements(driver, ValoriHomePage.class);
        valoriHomePage.clickCookieConsent();
        assertTrue("Expecting the innovation header to be visible", valoriHomePage.isLogoVisible());
    }
    @When("^I navigate to the Mobile Chapter page$")
    public void iNavigateToTheFullStackPage() {
         valoriHomePage = PageFactory.initElements(driver, ValoriHomePage.class);
         mobileChapterPage = PageFactory.initElements(driver, MobileChapterPage.class);
         valoriHomePage.clickExpertisesDropdown();
         valoriHomePage.clickMobileInDropDOwn();
        assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisible());
    }
    @Then("^I can read articles about the Mobile Chapter$")
    public void iCanReadAboutMobileChapter() {
        mobileChapterPage = PageFactory.initElements(driver, MobileChapterPage.class);
        assertTrue(mobileChapterPage.areArticlesVisible());
    }
    @And("^I contact Valori$")
    public void iContactValori()  {
        mobileChapterPage = PageFactory.initElements(driver, MobileChapterPage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        mobileChapterPage.clickContactUsButton();
        //switch to new tab
        genericUtils = PageFactory.initElements(driver, GenericUtils.class);
        genericUtils.SwitchToNewTab();
        assertTrue(contactUsPage.isTitleVisible());
    }
    @Then("^The contact us form is available$")
    public void theContactUsFormIsAvailable() {
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        assertTrue(contactUsPage.isFormVisible());
    }
    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }
    @Then("I fill in a contact form with personal details")
    public void iFillInAContactFormWithPersonalDetails(DataTable dataTable) throws InterruptedException {
        contactUsPage = PageFactory.initElements(driver,ContactUsPage.class);
        contactUsPage.submitForm(dataTable);
    }
}







