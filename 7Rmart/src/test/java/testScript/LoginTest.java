package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base {
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean ishomepageavailable=loginpage.isHomePageLoaded();
		assertTrue(ishomepageavailable,"Page is not loaded when user gives valid credentials");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndInvalidPassword()
	{
		String usernamevalue="admin";
		String passwordvalue="admin@";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean ishomepageavailable=loginpage.isHomePageLoaded();
		assertTrue(ishomepageavailable,"Page is not loaded when user gives valid username and invalid password");
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword()
	{
		String usernamevalue="admin1";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean ishomepageavailable=loginpage.isHomePageLoaded();
		assertTrue(ishomepageavailable,"Page is not loaded when user gives invalid username and valid password");
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword()
	{
		String usernamevalue="admin1";
		String passwordvalue="admin1";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean ishomepageavailable=loginpage.isHomePageLoaded();
		assertTrue(ishomepageavailable,"Page is not loaded when user gives invalid username and invalid password");
	}
	
	
	

}
