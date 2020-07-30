package smoketesting.PlugIns;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import smoketesting.BasePackage.BaseInit;
import smoketesting.Utility.MyLibrary;

public class Plugins extends BaseInit {

	@BeforeTest
	public static void setUp() throws Exception {
		startUp();
	}

	@Test
	public static void plugIns() {

		try {
			MyLibrary.signIn("Ravina.prajapati@e-isg.com", "Ravina@123");
			logs.info("Login is done successfully");
		} catch (Exception e) {
			logs.info("Login is not done");
		}

		
		try {
			isElementPresent("GettingStarted_xpath").click();
			logs.info("Getting started tab is opened");
		} catch (Exception e) {
			logs.info("Getting started tab is not opened");
		}

		try {

			isElementPresent("ApproveAsset_linkText").click();
			logs.info("ApproveAsset PlugIn is opened");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			isElementPresent("Close_linkText").click();
			logs.info("Close the ApproveAsset plugin");
		} catch (Exception e) {
			logs.info("Approve Asset Plugin is not found");
		}

		try {
			isElementPresent("BuildAssembly_linkText").click();
			logs.info("BuildAssembly PlugIn is opened");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			isElementPresent("Close_linkText").click();
			logs.info("Close the BuildAssembly plugin");

		} catch (Exception e) {
			logs.info("Build Assembly Plugin is not found");
		}

		try {

			isElementPresent("AssignAssetToPeople_linkText").click();
			logs.info("AssignAssetToPeople PlugIn is opened");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			isElementPresent("Close_linkText").click();
			logs.info("Close the AssignAssetToPeople plugin");
		} catch (Exception e) {
			logs.info("Assign Asset To People Plugin is not found");
		}

		try {
			isElementPresent("UIDRegistry_linkText").click();
			logs.info("UIDRegistry PlugIn is opened");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			isElementPresent("Close_linkText").click();
			logs.info("Close the UIDRegistry plugin");
		} catch (Exception e) {
			logs.info("UID Registry Plugin is not found");
		}

		try {
			isElementPresent("TransferInventory_linkText").click();
			logs.info("TransferInventory PlugIn is opened");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			isElementPresent("Close_linkText").click();
			logs.info("Close the TransferInventory plugin");

		} catch (Exception e) {
			logs.info("Transfer Inventory Plugin is not found");
		}

	}

}
