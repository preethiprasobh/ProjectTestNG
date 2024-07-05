package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUserSearch;
import pages.AdminUserStatus;
import pages.LoginPage;

public class AdminUserSearchTest extends Base {
	@Test
	public void verifyTheUserIsAbleToSearchTheUser()
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
		
		AdminUserSearch adminusersearch=new AdminUserSearch(driver);
		
		String username="PreethiArun";
		String usertype="admin";
		adminusersearch.clickOnBlueSearchButton();
		boolean isheadersearchadminusersavailable=adminusersearch.isSearchAdminUsersWindowLoaded();
		adminusersearch.enterSearchDetails(username, usertype);
		adminusersearch.clickOnRedSearchButton();
		
		
		assertTrue(isadminuserpageavailable,"Admin User page is not loaded");
		assertTrue(isheadersearchadminusersavailable,"Admin User search page is not loaded");
	}

}
