package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.AddUserInAdminUser;
import pages.AdminUserStatus;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddUserInAdminUserTest extends Base {

	@Test
	public void verifyTheUserIsAbleToAddUserInAdminUser() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		
		
		AddUserInAdminUser adduserinadminuser=new AddUserInAdminUser(driver);
		adduserinadminuser.clickOnNewButton();
		
		
		String username1=ExcelUtility.getStringData(1, 0, "AddUserInAdminUserData");
		String password1=ExcelUtility.getStringData(1, 1, "AddUserInAdminUserData");
		String usertype=ExcelUtility.getStringData(1, 2, "AddUserInAdminUserData");
		
		adduserinadminuser.enterAdminUserInformations(username1, password1, usertype);
		adduserinadminuser.clickOnSaveButton();
		
	}
}

