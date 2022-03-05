package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.Driver;


public class MyAccountPage {

	public MyAccountPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "username")
	public WebElement usernameField;

	@FindBy(id = "password")
	public WebElement passwordField;

	@FindBy(xpath = "//*[@id='customer_login']/div[1]/form/p[3]/input[3]")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div/p[1]/a")
	public WebElement signOutButton;
}
