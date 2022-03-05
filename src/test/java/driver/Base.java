package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReader;

public class Base {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (PropertyReader.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			}
		}
		driver.get(PropertyReader.getProperty("url"));
		// maximize
		driver.manage().window().maximize();

		return driver;
	}

	// close/quit browser
	@AfterTest
	public static void tearDown() {
		if (driver != null) {
			driver.close();
			// driver.quit();
			driver = null;
		}
	}
}