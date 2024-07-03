package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUserStatus;
import pages.LoginPage;

public class AdminUserStatusTest extends Base {
	
	@Test
	public void verifyTheUserIsAbleToChangeTheUserStatus()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		boolean ishomepageavailable=loginpage.isHomePageLoaded();
		
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		boolean isadminuserpageavailable=adminuserstatus.isAdminUserPageLoaded();
		adminuserstatus.getCurrentUserStatusInStatus();
		adminuserstatus.clickOnStatusIcon();
		
		
		assertTrue(ishomepageavailable,"Page is not loaded when user gives valid credentials");
		assertTrue(isadminuserpageavailable,"Admin User page is not loaded");
	}

}
