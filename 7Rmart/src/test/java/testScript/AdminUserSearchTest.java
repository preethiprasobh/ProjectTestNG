package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.AdminUserSearch;
import pages.AdminUserStatus;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserSearchTest extends Base {
	@Test(groups="sanity")
	public void verifyTheUserIsAbleToSearchTheUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		
		AdminUserSearch adminusersearch=new AdminUserSearch(driver);
		
		String username=ExcelUtility.getStringData(1, 0,Constants.ADMIN_USER_SEARCH_DATA);
		String usertype=ExcelUtility.getStringData(1, 1,Constants.ADMIN_USER_SEARCH_DATA);
		adminusersearch.clickOnBlueSearchButton();
		
		boolean is_header_search_admin_user_loaded=adminusersearch.isHeaderSearchAdminUserVisible();
		adminusersearch.enterSearchDetails(username, usertype);
		adminusersearch.clickOnRedSearchButton();
		
		assertTrue(is_header_search_admin_user_loaded,Messages.HEADER_SEARCH_ADMIN_USER_NOT_LOADED);
	}

}
