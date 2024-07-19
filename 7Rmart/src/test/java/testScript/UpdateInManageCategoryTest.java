package testScript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import constants.Constants;
import constants.Messages;
import pages.LoginPage;
import pages.UpdateInManageCategory;
import utilities.ExcelUtility;

public class UpdateInManageCategoryTest extends Base {
	@Test
	public void verifyTheUserIsAbleToUpdateInManageCategory() throws IOException, AWTException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		UpdateInManageCategory updateinmanagecategory=new UpdateInManageCategory(driver);
		updateinmanagecategory.clickOnManageCategory();
		boolean is_header_list_categories_loaded=updateinmanagecategory.isHeaderListCategoriesVisible();
		
		updateinmanagecategory.clickOnBlueUpdateIcon();
		boolean is_header_edit_category_loaded=updateinmanagecategory.isHeaderEditCategoryVisible();
		
		String category=ExcelUtility.getStringData(1, 0,Constants.UPDATE_IN_MANAGE_CATEGORY_DATA);
		updateinmanagecategory.enterCategoryInformation(category);
		
		updateinmanagecategory.clickOnUpdateButton();
		
		assertTrue(is_header_list_categories_loaded,Messages.HEADER_LIST_CATEGORIES_NOT_LOADED);
		assertTrue(is_header_edit_category_loaded,Messages.HEADER_EDIT_CATEGORY_NOT_LOADED);
		
	}

}
