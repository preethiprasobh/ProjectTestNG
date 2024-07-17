package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.Base;
import pages.LoginPage;
import pages.UpdateInManageCategory;
import utilities.ExcelUtility;

public class UpdateInManageCategoryTest extends Base {
	@Test
	public void verifyTheUserIsAbleToUpdateInManageCategory() throws IOException
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0, "Login");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "Login");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		UpdateInManageCategory updateinmanagecategory=new UpdateInManageCategory(driver);
		updateinmanagecategory.clickOnManageCategory();
		boolean isListCategoriesPageAvailable=updateinmanagecategory.isListCategoriesPageLoaded();
		updateinmanagecategory.clickOnBlueUpdateIcon();
		boolean isEditcategoryPageAvailable=updateinmanagecategory.isEditcategoryPageLoaded();
		String category=ExcelUtility.getStringData(1, 0, "UpdateInManageCategoryData");
		updateinmanagecategory.enterCategoryInformation(category);
		
		updateinmanagecategory.clickOnUpdateButton();
		
		
		assertTrue(isListCategoriesPageAvailable,"List Categories Page not loaded");
		assertTrue(isEditcategoryPageAvailable,"Edit Categories Page not loaded");
	}

}
