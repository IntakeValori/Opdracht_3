package modules;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BrowserScreenshotMaker {

	public void takeScreenShot(WebDriver driver, String dir, String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				dir + "/" + fileName + "__" + new SimpleDateFormat("dd_MM_yyyy_h_mm_ss").format(new Date()) + ".jpg"));
	}
}
