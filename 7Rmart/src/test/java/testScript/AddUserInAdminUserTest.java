package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.AddUserInAdminUser;
import pages.AdminUserStatus;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserInAdminUserTest extends Base {
	
	@Test(groups={"smoke","regression"})
	public void verifyTheUserIsAbleToAddUserInAdminUser() 
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AdminUserStatus adminuserstatus=new AdminUserStatus(driver);
		adminuserstatus.clickOnAdminUser();
		
		AddUserInAdminUser adduserinadminuser=new AddUserInAdminUser(driver);
		adduserinadminuser.clickOnNewButton();
		boolean is_header_admin_user_page_loaded=adduserinadminuser.isHeaderAdminUserPageVisible();
		
		String firstname=RandomDataUtility.getFirstName();//
		String lastname=RandomDataUtility.getLastName();
		String username1=firstname;
		String password1=firstname+"."+lastname;
		
		String usertype=ExcelUtility.getStringData(1, 2,Constants.ADD_USER_IN_ADMIN_USER_DATA);
		
		adduserinadminuser.enterAdminUserInformations(username1, password1, usertype);
		adduserinadminuser.clickOnSaveButton();
		
		assertTrue(is_header_admin_user_page_loaded,Messages.HEADER_ADMIN_USER_NOT_LOADED);
		
	}
}

