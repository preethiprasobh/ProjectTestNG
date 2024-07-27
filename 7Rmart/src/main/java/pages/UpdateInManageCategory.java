package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.RandomDataUtility;
import utilities.WaitUtility;
import utilities.WebElementsUtility;

public class UpdateInManageCategory {
	WebDriver driver;
	WebElementsUtility webelementsutility=new WebElementsUtility();
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();
	FileUploadUtility fileuploadutility=new FileUploadUtility();
		
	public UpdateInManageCategory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[5]/div/a/i")private WebElement managecategory ;
		@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headerlistcategories ;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/category/edit?edit=285&page_ad=1']")private WebElement blueupdateicon ;
		@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headereditcategory ;
		@FindBy(xpath="//input[@value='Television']")private WebElement categoryfield ;
		@FindBy(xpath="//li[@id='134-selection']")private WebElement selectgroupsitem ;
		@FindBy(xpath="//input[@type='file']")private WebElement choosefilebutton ;
		@FindBy(xpath="//div[@id='imagePreview']")private WebElement imagepreview ;
		
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[1]/label[2]/input")private WebElement showontopmenuyes ;
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[1]/label[3]/input")private WebElement showontopmenuno ;
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[2]/label[2]/input")private WebElement showonleftmenuyes ;
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[2]/label[3]/input")private WebElement showonleftmenuno ;
		@FindBy(xpath="//button[@type='submit']")private WebElement updatebutton ;
		
		public void clickOnManageCategory()
		{
			managecategory.click();
			
		}
		public boolean isHeaderListCategoriesVisible()
		{
			boolean is_header_list_categories_available=webelementsutility.isElementDisplayed(headerlistcategories);
			return is_header_list_categories_available;
		}
		
		public void clickOnBlueUpdateIcon()
		{
			blueupdateicon.click();
			
		}
		public boolean isHeaderEditCategoryVisible()
		{
			boolean is_header_edit_category_available=webelementsutility.isElementDisplayed(headereditcategory);
			return is_header_edit_category_available;
		}
		
		public void enterCategoryInformation(String category) 
		{	
			categoryfield.clear();
			String categoryfieldvalue=RandomDataUtility.getProductSubCategory();
			categoryfield.sendKeys(categoryfieldvalue);
			System.out.println("category set");
			
			waitutility.waitForElementToBeClickable(driver, selectgroupsitem);
			pageutility.actionClick(driver,selectgroupsitem);
			System.out.println("selectgroupsitem performed successfully");
			
			waitutility.waitForElementToBeClickable(driver, choosefilebutton);
			pageutility.actionClick(driver, choosefilebutton);
			
			fileuploadutility.fileUploadUsingSendKeys(choosefilebutton, Constants.TESTDATA_FILEIMAGE_UPDATEIN_MANAGECATEGORY);			
			waitutility.waitForElement(driver,imagepreview );
			
			if (webelementsutility.isElementSelected(showontopmenuyes)) {
				System.out.println("Show on Top Menu Yes is already selected.");
				pageutility.javaScriptExecutor(driver, showontopmenuno);
				System.out.println("No is selected");
			}
			else 
			{
				pageutility.javaScriptExecutor(driver, showontopmenuyes);
			}
				
			if(webelementsutility.isElementSelected(showonleftmenuyes))
			{
				System.out.println("yes is already selected");
				pageutility.javaScriptExecutor(driver, showonleftmenuno);
			}
			else
			{
				pageutility.javaScriptExecutor(driver, showonleftmenuyes);
				
			}
			
		}
		public void clickOnUpdateButton()
		{
			pageutility.javaScriptExecutor(driver, updatebutton);
			//driver.navigate().back();
		}
		
		

}
