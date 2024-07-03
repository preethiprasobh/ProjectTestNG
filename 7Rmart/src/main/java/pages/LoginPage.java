package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboardvalue;
	
	public void enterUserNameOnUserNameField(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		
	}
	public void enterPasswordOnPasswordField(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	public void clickOnSignInButton()
	{
		signin.click();
	}
	public boolean isHomePageLoaded()
	{
		return dashboardvalue.isDisplayed();
	}
	
}

