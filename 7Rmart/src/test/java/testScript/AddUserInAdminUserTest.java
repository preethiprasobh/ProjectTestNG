package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddUserInAdminUser;
import pages.AdminUserStatus;
import pages.LoginPage;

public class AddUserInAdminUserTest extends Base {

	@Test
	public void verifyTheUserIsAbleToAddUserInAdminUser()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		boolean isadminuserpageavailable=adminuserstatus.isAdminUserPageLoaded();
		
		AddUserInAdminUser adduserinadminuser=new AddUserInAdminUser(driver);
		adduserinadminuser.clickOnNewButton();
		boolean isadminuserinformationpageavailable=adduserinadminuser.isAdminUsersInformationPageLoaded();
		
		String username1="PreethiArun";
		String password1="abcd123";
		String usertype="admin";
		
		adduserinadminuser.enterAdminUserInformations(username1, password1, usertype);
		adduserinadminuser.clickOnSaveButton();
		
		
		
		assertTrue(isadminuserpageavailable,"Admin User page is not loaded");
		assertTrue(isadminuserinformationpageavailable,"Admin User Information page is not loaded");
		
		
		
	}
}

