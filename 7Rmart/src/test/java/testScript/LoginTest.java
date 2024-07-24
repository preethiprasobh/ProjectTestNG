package testScript;

import static org.testng.Assert.assertFalse;
import java.io.IOException;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import dataProvider.DataProviders;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(groups={"smoke","regression"})//if we are using multiple group
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
	
		
	}
	
	@Test(groups="regression",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void verifyUserLoginWithInvalidCredentials(String username,String password)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnSignInButton();
		boolean actualresultlogin=loginpage.isDashboardVisible();
		
		assertFalse(actualresultlogin,Messages.LOGIN_WITH_INVALID_CREDENTIALS);
	}
	
	
	

}
