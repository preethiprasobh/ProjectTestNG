package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AddInSubCategory;
import pages.LoginPage;

public class AddInSubCategoryTest extends Base {
	@Test
	
	public void verifyTheUserIsAbleToAddSubCategory()
	{
		String usernamevalue="admin";
		String passwordvalue="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		String categorydropdownvalue="168";
		String subcategorytextfieldvalue="Television";
		
		AddInSubCategory addinsubcategory=new AddInSubCategory(driver);
		addinsubcategory.clickOnManageCategory();
		boolean islistsubcategoriespageavailable=addinsubcategory.IsListSubCategoriesPageLoaded();
		
		
		addinsubcategory.clickOnNewInListSubCategory();
		boolean isaddsubcategorypageavailable=addinsubcategory.IsAddSubCategoryWindowLoaded();
		
		addinsubcategory.enterDataInAddSubcategoryWindow(categorydropdownvalue,subcategorytextfieldvalue);
		addinsubcategory.clickOnSaveButton();
		
		assertTrue(islistsubcategoriespageavailable,"List categories page is not loaded");
		assertTrue(isaddsubcategorypageavailable,"Add SubCategory Window is not loaded");
	}

}
