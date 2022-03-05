package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ListenerTestNG;
import utilities.CommonMethods;
import driver.Driver;
import utilities.PropertyReader;

@Listeners(ListenerTestNG.class)
public class MyAccountLogIn extends CommonMethods{
	//private WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		Driver.getDriver();
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(enabled = true)
	public void validUsernamePassword() {
		System.out.print("My Account: Log In - Valid Username & Password: Test case #1 starts.....");

		// Click on My Account menu.
		//driver.findElement(By.xpath(PropertiesReader.getProperties("MyAccountBtn"))).click();
		cp.myAccountTab.click();

		// Enter User email address.
		//driver.findElement(By.id(PropertiesReader.getProperties("usernameLogIn"))).sendKeys(PropertiesReader.getProperties("emailForAccountLogIn"));
		myAPage.usernameField.sendKeys(PropertyReader.getProperty("usernameLogIn"));

		// Enter User password.
		//driver.findElement(By.id(PropertiesReader.getProperties("passwordLogIn"))).sendKeys(PropertiesReader.getProperties("password"));
		myAPage.passwordField.sendKeys(PropertyReader.getProperty("password"));

		// Click Log In button.
		//driver.findElement(By.xpath(PropertiesReader.getProperties("logInBtn"))).click();
		myAPage.loginButton.click();

		// Assert login in to the next page.
		String actualPageTitle = Driver.getDriver().getTitle().toLowerCase();
		String expectedPageTitle = PropertyReader.getProperty("expectedPageTitle").toLowerCase();
		Assert.assertTrue(actualPageTitle.contains(expectedPageTitle), PropertyReader.getProperty("pageLoadError"));

		//System.out.println("PASS!");
	}

	@Test(enabled = true)
	public void invalidUsernamePassword() {
		//System.out.print("My Account: Log In - Invalid Username & Password: Test case #2 starts.....");

		// Click on My Account menu.
		//driver.findElement(By.xpath(PropertiesReader.getProperties("MyAccountBtn"))).click();
		cp.myAccountTab.click();

		// Enter incorrect user email address.
		//driver.findElement(By.id(PropertiesReader.getProperties("usernameLogIn"))).sendKeys(PropertiesReader.getProperties("incorrectEmail"));
		myAPage.usernameField.sendKeys(PropertyReader.getProperty("incorrectEmail"));

		// Enter incorrect user password.
		//driver.findElement(By.id(PropertiesReader.getProperties("passwordLogIn"))).sendKeys(PropertiesReader.getProperties("incorrectPassword"));
		myAPage.passwordField.sendKeys(PropertyReader.getProperty("incorrectPassword"));

		// Click Log In button.
		//driver.findElement(By.xpath(PropertiesReader.getProperties("logInBtn"))).click();
		myAPage.loginButton.click();


		// Assert invalid email/password error message is displayed.
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath(PropertyReader.getProperty("errorLabel"))).isDisplayed());

		//System.out.println("PASS!");
	}
	
	@AfterTest
	public void afterTest() {
		Driver.tearDown();
	}
}
