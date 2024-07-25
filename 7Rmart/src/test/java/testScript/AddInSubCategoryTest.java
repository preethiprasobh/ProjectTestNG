package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import pages.AddInSubCategory;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddInSubCategoryTest extends Base {
	@Test(groups={"sanity","regression"})
	
	public void verifyTheUserIsAbleToAddSubCategory() 
	{
		String usernamevalue=ExcelUtility.getStringData(1, 0,Constants.LOGIN_PAGE);
		String passwordvalue=ExcelUtility.getStringData(1, 1,Constants.LOGIN_PAGE);
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(usernamevalue);
		loginpage.enterPasswordOnPasswordField(passwordvalue);
		loginpage.clickOnSignInButton();
		
		AddInSubCategory addinsubcategory=new AddInSubCategory(driver);
		addinsubcategory.clickOnManageCategory();
		boolean isheaderlistsubcategoriesloaded= addinsubcategory.isHeaderListSubCategoriesVisible();
		
		addinsubcategory.clickOnNewInListSubCategory();
		boolean isheaderaddsubcategoryloaded=addinsubcategory.isHeaderAddSubCategoryVisible();
		
	
		String categorydropdownvalue=ExcelUtility.getIntegerData(0, 1,Constants.SUB_CATEGORY_DATA_PAGE);
		String subcategoryname=RandomDataUtility.getProductSubCategory();//faker class is used here
		String subcategorytextfieldvalue=subcategoryname;
		
		
		addinsubcategory.enterDataInAddSubcategoryWindow(categorydropdownvalue,subcategorytextfieldvalue);
		addinsubcategory.clickOnSaveButton();
		
		
		Assert.assertTrue(isheaderlistsubcategoriesloaded,Messages.HEADER_LIST_SUBCATEGORIES_NOT_LOADED);
		Assert.assertTrue(isheaderaddsubcategoryloaded,Messages.HEADER_ADD_SUBCATEGORIES_NOT_LOADED);
		
		
	}

}
