package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;
import utils.NetworkUtils;

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

        NetworkUtils network = new NetworkUtils(driver);
        network.startSession().blockPostRequest("neem-contact-op");
        driver.findElement(By.cssSelector("[id=\"form-input-firstName\"]")).sendKeys("Ico");
        driver.findElement(By.cssSelector("[id=\"form-input-lastName\"]")).sendKeys("Bakker");
        driver.findElement(By.cssSelector("[id=\"form-input-email\"]")).sendKeys("icobakker@valori.nl");
        driver.findElement(By.cssSelector("[id=\"form-input-message\"]")).sendKeys("Let op! Als dit bericht door is gekomen dan heeft Ico het goed fout gedaan. Zou je dit bij hem willen melden? Bvd!");
        driver.findElement(By.cssSelector("button.block-button--primary")).click();
        Thread.sleep(5000);
    }

    @Then( "^the contact us form is available$" )
    public void theContactUsFormIsAvailable() throws Throwable {
        //TODO IMPLEMENT THIS
        //Verify the contact form fields are available.
        throw new PendingException();
    }
}


