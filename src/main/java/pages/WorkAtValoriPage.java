package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WorkAtValoriPage {

	private WebDriver driver;
	// TODO make class properties final/constant???
	private int timeOut = 5;
	private By werkenBijSlogan = By.xpath("//h2[contains(text(),'Kom ook werken bij het leukste QA & Testing bedrijf van Nederland!')]");
	private By iFrames = By.xpath("//iframe[@class='youtube']");

	public WorkAtValoriPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isWorkingAtValoriPageVisibile() {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(werkenBijSlogan));
		return driver.findElement(werkenBijSlogan).isDisplayed();
	}

	public boolean areIframesVisible() {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(iFrames));
		List<WebElement> allIframes = driver.findElements(iFrames);
		for (WebElement iFrame : allIframes) {
			System.out.println(iFrame.getLocation());
			if (!iFrame.getAttribute("src").contains("youtube"))
				return false;
		}
		return true;
	}
}
