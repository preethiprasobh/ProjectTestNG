package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.AdminUserStatus;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserStatusTest extends Base {
	
	@Test
	public void verifyTheUserIsAbleToChangeTheUserStatus() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		
		adminuserstatus.getCurrentUserStatusInStatus();
		adminuserstatus.clickOnStatusIcon();
		
	}

}
