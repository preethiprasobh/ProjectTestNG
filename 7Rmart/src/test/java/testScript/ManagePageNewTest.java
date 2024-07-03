package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePageNew;

public class ManagePageNewTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterIntoManagePages()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		
		boolean ismanagepagesavailable=managepagenew.IsManagePageLoaded();
		
		
		managepagenew.clickOnNewButton();
		String titledata="Preethi";
		String descriptiondata="Welcome to our sample application!Feel free to navigate around and explore all the webElements";
		String pagedata="7mart Supermarket";
		
		boolean isaddpagesavailable=managepagenew.IsAddPagesWindowLoaded();
		
		
		managepagenew.enerPageInformation(titledata,descriptiondata,pagedata);
		managepagenew.clickOnSaveButton();
		
		
		
		assertTrue(ismanagepagesavailable,"ManagePages window is not loaded");
		assertTrue(isaddpagesavailable,"AddPages window is not loaded");
		
	}
	

}
