package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.UpdateInManageCategory;

public class UpdateInManageCategoryTest extends Base {
	@Test
	public void verifyTheUserIsAbleToUpdateInManageCategory()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		UpdateInManageCategory updateinmanagecategory=new UpdateInManageCategory(driver);
		updateinmanagecategory.clickOnManageCategory();
		boolean isListCategoriesPageAvailable=updateinmanagecategory.isListCategoriesPageLoaded();
		updateinmanagecategory.clickOnBlueUpdateIcon();
		boolean isEditcategoryPageAvailable=updateinmanagecategory.isEditcategoryPageLoaded();
		String category="Television";
		updateinmanagecategory.enterCategoryInformation(category);
		
		updateinmanagecategory.clickOnUpdateButton();
		
		
		assertTrue(isListCategoriesPageAvailable,"List Categories Page not loaded");
		assertTrue(isEditcategoryPageAvailable,"Edit Categories Page not loaded");
	}

}
