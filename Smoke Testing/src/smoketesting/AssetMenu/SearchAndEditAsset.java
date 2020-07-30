package smoketesting.AssetMenu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import smoketesting.BasePackage.BaseInit;
import smoketesting.Utility.MyLibrary;

public class SearchAndEditAsset extends BaseInit {

	@BeforeTest
	public static void setUp() throws Exception {
		startUp();
	}

	@Test
	public static void searchAndEditAsset() throws Exception {

		MyLibrary.signIn("Ravina.prajapati@e-isg.com", "Ravina@123");
		logs.info("Login is done successfully");

		WebElement Assets = isElementPresent("Assets_xpath");
		WebElement EditAssets = isElementPresent("EditAssets_xpath");
		WebElement SearchAndEditAssets = isElementPresent("searchAndEditAssets_linkText");

		Actions action = new Actions(driver);
		action.moveToElement(Assets).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"ctl00_topMenu\"]/ul/li[1]/div/ul/li[2]/a/span[1]")));
		action.moveToElement(EditAssets).build().perform();
		SearchAndEditAssets.click();

		logs.info("Clicked on Search And Edit Assets menu");
		System.out.println("Move to Search And Edit Assets menu");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("CreatedDateCompare")));
		
		WebElement aplyfilter = isElementPresent("aplyfltr_xpath");
		
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_uimodules_assetsearch_ascx_btnApplyFilter\"]")));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", aplyfilter);
		
	
		logs.info("Clicked on Apply Filter button");
		System.out.println("Clicked on Apply Filter button");
		Thread.sleep(5000);
		
		
		WebElement table= isElementPresent("searchforassetTable_xpath");
		List<WebElement> tablerow=table.findElements(By.tagName("tr"));
		
		for(int row=1;row<tablerow.size();row++) {
			List<WebElement> tablecol= tablerow.get(row).findElements(By.tagName("td"));
			
			for(int col=3;col<tablecol.size();) {
				tablecol.get(col).click();
				break;
			}
			isElementPresent("EditThisItem_linkText").click();
			Thread.sleep(5000);
		}
		
		/*WebElement searchforassetrow= isElementPresent("searchforasssetrow_xpath");

		WebElement trTag= searchforassetrow.findElement(By.tagName("tr"));
		System.out.println(trTag.getSize());
		WebElement Frow= isElementPresent("searchforassetFirstRow_xpath");
	
		
	
		
		if(trTag.getTagName() !=null) {
			System.out.println(trTag +"is not empty");
			executor.executeScript("arguments[0].click();", Frow);
			System.out.println("click on the row");
			isElementPresent("EditThisItem_linkText").click();
			Thread.sleep(5000);
			

		}*/
	}

}
