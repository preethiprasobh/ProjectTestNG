package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.AdminUserStatus;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserStatusTest extends Base {
	
	@Test(groups="regression")
	public void verifyTheUserIsAbleToChangeTheUserStatus() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		boolean is_admin_header_loaded=adminuserstatus.isAdminHeaderVisible();
		
		adminuserstatus.getCurrentUserStatusInStatus();
		boolean is_status_icon_loaded=adminuserstatus.isStatusIconVisible();
		adminuserstatus.clickOnStatusIcon();
		
		assertTrue(is_admin_header_loaded,Messages.HEADER_ADMIN_IS_NOT_LOADED);
		assertTrue(is_status_icon_loaded,Messages.STATUS_ICON_IS_NOT_LOADED);
		
	}

}
