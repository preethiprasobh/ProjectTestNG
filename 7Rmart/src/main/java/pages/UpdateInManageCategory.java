package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UpdateInManageCategory {
	WebDriver driver;
	PageUtility pageutility=new PageUtility();
	public UpdateInManageCategory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[5]/div/a/i")private WebElement managecategory ;
		@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headerlistcategories ;
		@FindBy(xpath="//i[@class='fas fa-edit']")private WebElement blueupdateicon ;
		@FindBy(xpath="//h1[@class='m-0 text-dark']")private WebElement headereditcategory ;
		@FindBy(xpath="//input[@name='category']")private WebElement categoryfield ;
		@FindBy(xpath="//li[@id='134-selection']")private WebElement selectgroupsitem ;
		
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[1]/label[2]/input")private WebElement showontopmenuyes ;
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[1]/label[3]/input")private WebElement showontopmenuno ;
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[2]/label[2]/input")private WebElement showonleftmenuyes ;
		@FindBy(xpath="//*[@id=\"form\"]/div/div[4]/div[2]/label[3]/input")private WebElement showonleftmenuno ;
		@FindBy(xpath="//button[@type='submit']")private WebElement updatebutton ;
		
		public void clickOnManageCategory()
		{
			managecategory.click();
		}
		public boolean isListCategoriesPageLoaded()
		{
			return headerlistcategories.isDisplayed();
		}
		public void clickOnBlueUpdateIcon()
		{
			blueupdateicon.click();
		}
		public boolean isEditcategoryPageLoaded()
		{
			return headereditcategory.isDisplayed();
		}
		public void enterCategoryInformation(String category)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			categoryfield.sendKeys(category);
			System.out.println("category set");
			
			pageutility.actionClick(driver,selectgroupsitem );
			System.out.println("selectgroupsitem performed successfully");
			
			if (showontopmenuyes.isSelected()) {
				System.out.println("Show on Top Menu Yes is already selected.");
				js.executeScript("arguments[0].click();",showontopmenuno );
			}
			else 
			{
				js.executeScript("arguments[0].click();",showontopmenuyes );
			}
				
			if(showonleftmenuyes.isSelected())
			{
				showonleftmenuno.click();
			}
			else
			{
				showonleftmenuyes.click();
			}
			
			
		}
		public void clickOnUpdateButton()
		{
			updatebutton.click();
			driver.navigate().back();
		}
		

}
