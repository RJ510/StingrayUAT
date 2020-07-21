 package smoketesting.Utility;

import smoketesting.BasePackage.BaseInit;

public class MyLibrary extends BaseInit {
	
	public static void signIn(String emailID, String pwd) {
		
		driver.get(storage.getProperty("url"));
		isElementPresent("IP_UserName_id").sendKeys(emailID);
		isElementPresent("IP_Password_id").sendKeys(pwd);
		isElementPresent("btn_Login_id").click();
		
	}
	
	public static void signOut() {
		isElementPresent("btn_logOut_id").click();
		
	}

}
