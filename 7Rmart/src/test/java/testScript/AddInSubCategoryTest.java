package testScript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import baseClass.Base;
import constants.Constants;
import constants.Messages;
import pages.AddInSubCategory;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddInSubCategoryTest extends Base {
	@Test
	
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
		String subcategorytextfieldvalue=ExcelUtility.getStringData(1, 1,Constants.SUB_CATEGORY_DATA_PAGE);
		
		addinsubcategory.enterDataInAddSubcategoryWindow(categorydropdownvalue,subcategorytextfieldvalue);
		addinsubcategory.clickOnSaveButton();
		boolean isalertboxloaded=addinsubcategory.isAlertBoxVisible();
		
		assertTrue(isheaderlistsubcategoriesloaded,Messages.HEADER_LIST_SUBCATEGORIES_NOT_LOADED);
		assertTrue(isheaderaddsubcategoryloaded,Messages.HEADER_ADD_SUBCATEGORIES_NOT_LOADED);
		assertTrue(isalertboxloaded,Messages.ALERT_WINDOW_NOT_LOADED);
		
	}

}
