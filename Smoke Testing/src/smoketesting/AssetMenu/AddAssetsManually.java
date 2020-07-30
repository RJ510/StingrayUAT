package smoketesting.AssetMenu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import smoketesting.BasePackage.BaseInit;
import smoketesting.Utility.MyLibrary;

public class AddAssetsManually extends BaseInit {

	@BeforeTest
	public static void setUp() throws Exception {
		startUp();
	}

	@Test
	public static void addAssetsManually() throws Exception {

		MyLibrary.signIn("Ravina.prajapati@e-isg.com", "Ravina@123");
		logs.info("Login is done successfully");

		WebElement Assets = isElementPresent("Assets_xpath");
		WebElement AddAssets = isElementPresent("AddAssets_xpath");

		try {
			Actions action = new Actions(driver);
			Thread.sleep(1000);
			action.moveToElement(Assets).build().perform();
			logs.info("Move to Assets menu");
			Thread.sleep(1000);
			AddAssets.click();
			logs.info("Clicked on Add Assets menu");
			Thread.sleep(10000);

			WebElement AddAssetsManuallyTable = isElementPresent("chooseyourwaytoaddingAssetTable_xpath");
			List<WebElement> classvals = AddAssetsManuallyTable.findElements(By.tagName("Div"));
			
			try {
				for (int count = 0; count < classvals.size(); count++) {

					if (classvals.get(count).getText().equalsIgnoreCase("Add Assets Manually")) {

						logs.info(classvals.get(count).getText());
						System.out.println(classvals.get(count).getText());
						classvals.get(count).click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						Thread.sleep(5000);

					}
				}
			} catch (StaleElementReferenceException e) {

			}
		}catch(Exception e) {
			logs.info("Assets menu and edit assets menu is not found");
		}
	

	

	}

}
