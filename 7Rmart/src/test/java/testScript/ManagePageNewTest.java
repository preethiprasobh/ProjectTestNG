package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.ManagePageNew;
import utilities.ExcelUtility;

public class ManagePageNewTest extends Base {
	@Test
	public void verifyTheUserIsAbleToEnterIntoManagePages() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		ManagePageNew managepagenew=new ManagePageNew(driver);
		managepagenew.managePagesMoreInfolinkClick();
		boolean is_new_button_in_manage_page_loaded=managepagenew.isNewButtonInManagePageVisible();
		
		managepagenew.clickOnNewButton();
		boolean is_add_page_window_loaded=managepagenew.isNewButtonInManagePageVisible();
		String titledata=ExcelUtility.getStringData(0, 1, Constants.MANAGE_PAGES_NEW_DATA);
		String descriptiondata=ExcelUtility.getStringData(1, 1,Constants.MANAGE_PAGES_NEW_DATA);
		String pagedata=ExcelUtility.getStringData(2, 1,Constants.MANAGE_PAGES_NEW_DATA);
		
		managepagenew.enerPageInformation(titledata,descriptiondata,pagedata);
		managepagenew.clickOnAddImage();
		managepagenew.clickOnSaveButton();
		boolean is_alertbox_loaded=managepagenew.isAlertBoxVisible();
		
		assertTrue(is_new_button_in_manage_page_loaded,Messages.MANAGE_PAGES_NEW_BUTTON_IS_NOT_LOADED);	
		assertTrue(is_add_page_window_loaded,Messages.ADD_PAGES_WINDOW_IS_NOT_LOADED);	
		assertTrue(is_alertbox_loaded,Messages.ALERT_WINDOW_NOT_LOADED);	
	}
	

}
