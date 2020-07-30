package smoketesting.ToolsMenu;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import smoketesting.BasePackage.BaseInit;
import smoketesting.Utility.MyLibrary;

public class DataImport extends BaseInit {

	@BeforeTest
	public static void setUp() throws Exception {
		startUp();
	}

	@Test
	public static void dataImport() throws Exception {
		MyLibrary.signIn("Ravina.prajapati@e-isg.com", "Ravina@123");
		logs.info("Login is done successfully");

		WebElement tools = isElementPresent("Toolsmenu_xpath");
		WebElement dataimport = isElementPresent("Dataimport_xpath");

		Actions action = new Actions(driver);
		action.moveToElement(tools).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_topMenu\"]/ul/li[3]/div/ul/li[1]/a/span")));
		dataimport.click();

		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		System.out.println(parentWindowHandler);
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
			System.out.println(subWindowHandler);
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window

		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		// Now you are in the popup window, perform necessary actions here
		
		WebElement tilexpath=isElementPresent("Tile_xpath");
		tilexpath.findElement(By.id("RadTileList1_RadImageAndTextTile1")).click();
		             
		Thread.sleep(2000);

	


		
	}

}

//*[@id="ctl00_topMenu"]/ul/li[1]/a/span[1]


