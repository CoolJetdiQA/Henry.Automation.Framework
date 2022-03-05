package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.PropertyReader;

public class Driver {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		if(driver == null) {
			switch(PropertyReader.getProperty("browser")) {
			case "firefox": WebDriverManager.firefoxdriver().setup();
							driver = new FirefoxDriver();
							driver.get(PropertyReader.getProperty("urlAutomation"));
							driver.manage().window().maximize();
							driver.manage().deleteAllCookies();
							PageInitializer.initialize();
							//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							break;
			case "chrome":  WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
							driver.get(PropertyReader.getProperty("urlAutomation"));
							driver.manage().window().maximize();
							driver.manage().deleteAllCookies();
							PageInitializer.initialize();
							//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							break;	
			}
		}
		return driver; 
	}
	
	// CLose quit browser
	public static void tearDown() {
		if(driver != null) {
			driver.close();
			driver = null;
		}
	}
}
