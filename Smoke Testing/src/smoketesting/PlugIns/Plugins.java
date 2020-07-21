package smoketesting.PlugIns;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import smoketesting.BasePackage.BaseInit;
import smoketesting.Utility.MyLibrary;

public class Plugins extends BaseInit{
	
	@BeforeTest
	public static void setUp() throws Exception {
		startUp();
	}
	@Test
	public static void plugIns(){
	
		MyLibrary.signIn("Ravina.prajapati@e-isg.com", "Ravina@123");
		isElementPresent("GettingStarted_xpath").click();
		
		isElementPresent("ApproveAsset_xpath").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		isElementPresent("btn_Close_className").click();
		
		isElementPresent("BuildAssembly_xpath").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		isElementPresent("btn_Close_className").click();
		
		isElementPresent("AssignAssetToPeople_xpath").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		isElementPresent("btn_Close_className").click();
		
		isElementPresent("UIDRegistry_xpath").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		isElementPresent("btn_Close_className").click();
		
		isElementPresent("TransferInventory_xpath").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		isElementPresent("btn_Close_className").click();
		
		
		BaseInit.endUp();
	}

}
