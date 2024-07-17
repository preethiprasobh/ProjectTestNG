package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.LoginPage;
import pages.ManagePageNew;
import utilities.ExcelUtility;

public class ManagePageNewTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterIntoManagePages() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		
		boolean ismanagepagesavailable=managepagenew.IsManagePageLoaded();
		
		
		managepagenew.clickOnNewButton();
		String titledata=ExcelUtility.getStringData(0, 1, "ManagePagesNewData");
		String descriptiondata=ExcelUtility.getStringData(1, 1, "ManagePagesNewData");
		String pagedata=ExcelUtility.getStringData(2, 1, "ManagePagesNewData");
		
		boolean isaddpagesavailable=managepagenew.IsAddPagesWindowLoaded();
		
		
		managepagenew.enerPageInformation(titledata,descriptiondata,pagedata);
		managepagenew.clickOnAddImage();
		managepagenew.clickOnSaveButton();
		
		boolean isalertboxavailable=managepagenew.IsAlertBoxLoaded();
		
		
		assertTrue(ismanagepagesavailable,"ManagePages window is not loaded");
		assertTrue(isaddpagesavailable,"AddPages window is not loaded");
		assertTrue(isalertboxavailable,"AddPages window is not loaded");
		
	}
	

}
