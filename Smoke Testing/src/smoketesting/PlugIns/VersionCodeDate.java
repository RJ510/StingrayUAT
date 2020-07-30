package smoketesting.PlugIns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import smoketesting.BasePackage.BaseInit;
import smoketesting.Utility.MyLibrary;

public class VersionCodeDate extends BaseInit {

	@Test
	public static void checkVersionCode() {

		MyLibrary.signIn("Ravina.prajapati@e-isg.com", "Ravina@123");
		logs.info("Login is done successfully");

		try {
			isElementPresent("Overview_xpath").click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		} catch (Exception e) {
			logs.info("Overview tab is not found");
		}

		try {
			String vlnk = storage.getProperty("Versioncode_linkText");
			logs.info("Expected version is" + ":-" + vlnk);

			WebElement versioncode = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ucWelcome1_Main1_lblVersionNumber"));
			String vc = versioncode.getText();
			System.out.println("version code is" + ":-" + vc);
			logs.info("Actual version is" + ":-" + vc);

			if (vlnk.equalsIgnoreCase(vc)) {
				System.out.println("Version of the application is" + " :-" + vc);
				logs.info("Current version is matched with expected version,Version is" + ":-" + vlnk);

			} else {
				System.out.println("Version is not matched with current version,current version is" + ":-" + vc + " "
						+ "and" + " " + "expected version is" + ":-" + vlnk);
				logs.info("Version is not matched with current version,current version is" + ":-" + vc + " " + "and"
						+ " " + "expected version is" + ":-" + vlnk);

			}
		} catch (Exception e) {
			logs.info("Version Code is not found");

		}

	}

}
