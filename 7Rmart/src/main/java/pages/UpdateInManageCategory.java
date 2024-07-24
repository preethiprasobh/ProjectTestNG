package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
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
		@FindBy(xpath="//input[@value='Cars100']")private WebElement categoryfield ;
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			categoryfield.clear();
			categoryfield.sendKeys(category);
			System.out.println("category set");
			
			waitutility.waitForElementToBeClickable(driver, selectgroupsitem);
			//selectgroupsitem.click();
			pageutility.actionClick(driver,selectgroupsitem);
			//selectgroupsitem.sendKeys(Keys.RETURN);
			
			System.out.println("selectgroupsitem performed successfully");
			
			waitutility.waitForElementToBeClickable(driver, choosefilebutton);
			pageutility.actionClick(driver, choosefilebutton);
			//choosefilebutton.click();
			
			
			fileuploadutility.fileUploadUsingSendKeys(choosefilebutton, Constants.TESTDATA_FILEIMAGE_UPDATEIN_MANAGECATEGORY);
						
			waitutility.waitForElement(driver,imagepreview );
			//webelementsutility.assertElementDisplayed(imagepreview);
			
			if (webelementsutility.isElementSelected(showontopmenuyes)) {
				System.out.println("Show on Top Menu Yes is already selected.");
				//showontopmenuno.click();
				js.executeScript("arguments[0].click();",showontopmenuno );
				System.out.println("No is selected");
			}
			else 
			{
				js.executeScript("arguments[0].click();",showontopmenuyes );
			}
				
			if(webelementsutility.isElementSelected(showonleftmenuyes))
			{
				System.out.println("yes is already selected");
				js.executeScript("arguments[0].click();",showonleftmenuno );
				
			}
			else
			{
				js.executeScript("arguments[0].click();",showonleftmenuyes );
				//showonleftmenuyes.click();
			}
			
			
		}
		public void clickOnUpdateButton()
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("arguments[0].click();",updatebutton );
			
			driver.navigate().back();
		}
		
		

}
