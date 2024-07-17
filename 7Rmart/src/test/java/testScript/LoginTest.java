package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
	
		
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingValidUsernameAndInvalidPassword() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(2, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(2, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		//assertTrue(isalertboxavailable,"Page is loaded when user gives valid username and invalid password");
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(3, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
	
		//assertTrue(isalertboxavailable,"Page is loaded when user gives invalid username and valid password");
	}
	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(4, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(4, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		//assertTrue(isalertboxavailable,"Page is loaded when user gives invalid username and invalid password");
	}
	
	
	

}
