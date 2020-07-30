package smoketesting.BasePackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import smoketesting.Utility.ExcelFileReader;

public class BaseInit {

	public static Properties storage = null;
	public static WebDriver driver;
	public static Logger logs;
	public static ExcelFileReader data;

	public static void startUp() throws Exception {

		if (driver == null) {
			// Initialize Logs
			logs = Logger.getLogger("devpinoyLogger");
			logs.info("initialization of the log is done");

			// Initialization and Load Properties File
			logs.info("initialization of the properties file");

			storage = new Properties();
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\smoketesting\\PropertiesData\\ObjectStorage.properties");
			storage.load(fi);
			logs.info("initialization of the properties file is done");

			// Launch the browser
			logs.info("Launching the browser");
			String browserkey = storage.getProperty("browser");

			if (browserkey.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "E:\\Automation\\software\\drivers\\windows\\geckodriver.exe");
				driver = new FirefoxDriver();
				logs.info("Firefox Browser is launched");
				
			} else if (browserkey.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"E:\\Automation\\software\\drivers\\windows\\chromedriver.exe");
				driver = new ChromeDriver();
				logs.info("Chrome Browser is launched");
			} else {
				System.out.println("Browser is not defined");
				logs.info("Browser is not defined");
			}
		}

		// Maximize the browser
		driver.manage().window().maximize();
		logs.info("windows is maximized");

		// define timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logs.info("timeout is defined");

		// delete the cookies
		driver.manage().deleteAllCookies();
		logs.info("Cookies are deleted");

		// Object of the ExcelFileReader Class
		data = new ExcelFileReader(System.getProperty("user.dir") + "\\src\\smoketesting\\TestData\\TestCases.xlsx");
		logs.info("initialization of the excelfilereader Class is done");

	}

	public static WebElement isElementPresent(String propkey) {

		try {

			if (propkey.contains("xpath")) {

				return driver.findElement(By.xpath(storage.getProperty(propkey)));

			} else if (propkey.contains("id")) {

				return driver.findElement(By.id(storage.getProperty(propkey)));

			} else if (propkey.contains("name")) {

				return driver.findElement(By.name(storage.getProperty(propkey)));

			} else if (propkey.contains("linkText")) {

				return driver.findElement(By.linkText(storage.getProperty(propkey)));

			} else if (propkey.contains("className")) {

				return driver.findElement(By.className(storage.getProperty(propkey)));

			} else {

				System.out.println("propkey is not defined");

				logs.info("prop key is not defined");
			}

		} catch (Exception e) {

		}
		return null;

	}
	
	public static void endUp() {
		driver.close();
	}
}
