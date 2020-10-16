package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

	private WebDriver driver;
	private int timeOut = 5;

	private By contactUsPageTitle = By.xpath("//h1[contains(text(),'Contact')]");
	// TODO find out why at the moment i need to use the full xpath
	private By formHtlmElement = By.xpath("/html/body/div[2]/main/div/section/article/div[2]/form");

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public Boolean isTitleVisible() {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(contactUsPageTitle));
		return driver.findElement(contactUsPageTitle).isDisplayed();
	}

	public Boolean formHtlmElementFound() {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(formHtlmElement));
		return driver.findElement(formHtlmElement).isDisplayed();
	}
}
