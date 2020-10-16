package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import modules.BrowserScreenshotMaker;
import modules.StackTraceHelper;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import pages.MobileChapterPage;
import pages.ValoriHomePage;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
	private WebDriver driver;
	private BrowserScreenshotMaker screenshotMaker;;

	public StepDefinitions() {
		this.driver = DriverManager.driver;
		this.screenshotMaker = new BrowserScreenshotMaker();
	}

	@Given("^I am on the Valori homepage$")
	public void iAmOnTheValoriHomepage() throws Throwable {
		ValoriHomePage valoriHomePage = new ValoriHomePage(driver);

		try {
			valoriHomePage.clickCookieConsent();
			assertTrue("Expecting the innovation header to be visible", valoriHomePage.isLogoVisible());
		}

		catch (AssertionError e) {
			screenshotMaker.takeScreenShot(this.driver, "src/test/screenshots", StackTraceHelper.getMethodNameCaller());
		}
	}

	@And("^I navigate to the Mobile Chapter page$")
	public void iNavigateToTheFullStackPage() throws Throwable {
		ValoriHomePage valoriHomePage = new ValoriHomePage(driver);
		MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);

		try {
			valoriHomePage.clickExpertisesDropdown();
			valoriHomePage.clickMobileInDropDOwn();
			assertTrue("Expecting the full stack header to be visible", mobileChapterPage.isMobilePageVisibile());
		}

		catch (AssertionError e) {
			screenshotMaker.takeScreenShot(this.driver, "src/test/screenshots", StackTraceHelper.getMethodNameCaller());
		}
	}

	@Then("^I can read articles about the Mobile Chapter$")
	public void iCanReadAboutMobileChapter() throws Throwable {
		MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
		try {
			assertTrue(mobileChapterPage.areArticlesVisible());
		}

		catch (AssertionError e) {
			screenshotMaker.takeScreenShot(this.driver, "src/test/screenshots", StackTraceHelper.getMethodNameCaller());
		}
	}

	@And("^I contact Valori$")
	public void iContactValori() throws Throwable {
		MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
		ContactUsPage contactUsPage = new ContactUsPage(driver);

		try {

			mobileChapterPage.clickContactUsButton();
			// switch to new tab
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			assertTrue(contactUsPage.isTitleVisible());
		}

		catch (AssertionError e) {
			screenshotMaker.takeScreenShot(this.driver, "src/test/screenshots", StackTraceHelper.getMethodNameCaller());
		}
	}

	@Then("^the contact us form is available$")
	public void theContactUsFormIsAvailable() throws Throwable {
		MobileChapterPage mobileChapterPage = new MobileChapterPage(driver);
		ContactUsPage contactUsPage = new ContactUsPage(driver);

		try {
			mobileChapterPage.clickContactUsButton();

			// switch to new tab
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			assertTrue(contactUsPage.formHtlmElementFound());
		}

		catch (AssertionError e) {
			screenshotMaker.takeScreenShot(this.driver, "src/test/screenshots", StackTraceHelper.getMethodNameCaller());
		}
	}
}
