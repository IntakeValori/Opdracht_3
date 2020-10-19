package modules;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

// TODO write tests for this class??
public class BrowserScreenshotMaker {

	public void takeScreenShot(WebDriver driver, String dir, String fileName) throws IOException {
		final String DATEFORMATISO8601 = "dd_MM_yyyy_h_mm_ss";
		final String EXTENSIONTYPESCREENSHOT = ".jpg";
		final File SRCFILE = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(SRCFILE, new File(dir + "/" + fileName + "__"
				+ new SimpleDateFormat(DATEFORMATISO8601).format(new Date()) + EXTENSIONTYPESCREENSHOT));
	}
}
