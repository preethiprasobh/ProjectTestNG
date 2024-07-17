package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.AdminUserSearch;
import pages.AdminUserStatus;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserSearchTest extends Base {
	@Test
	public void verifyTheUserIsAbleToSearchTheUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		
		AdminUserSearch adminusersearch=new AdminUserSearch(driver);
		
		String username=ExcelUtility.getStringData(1, 0, "AdminUserSearchData");
		String usertype=ExcelUtility.getStringData(1, 1, "AdminUserSearchData");
		adminusersearch.clickOnBlueSearchButton();
		adminusersearch.enterSearchDetails(username, usertype);
		adminusersearch.clickOnRedSearchButton();
		
	}

}
