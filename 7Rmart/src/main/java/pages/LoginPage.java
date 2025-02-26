package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementsUtility;

public class LoginPage {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Username']")private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//li[@class='breadcrumb-item active']")private WebElement dashboardvalue;
	@FindBy(xpath="//h5[text()=\" Alert!\"]")private WebElement alerticon;
	
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
	public boolean isDashboardVisible()
	{
		boolean isdashboardavailable=webelementsutility.isElementDisplayed(dashboardvalue);
		return isdashboardavailable;
	}
	public boolean isAlertboxVisible()
	{
		boolean alertavailable=webelementsutility.isElementDisplayed(alerticon);
		return alertavailable;
	}
	
}

