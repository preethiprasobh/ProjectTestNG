package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddInSubCategory {
	WebDriver driver;
	public AddInSubCategory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[7]/div/a")private WebElement subcategory;
	
	@FindBy(xpath="//h1[text()='List Sub Categories']")private WebElement headerlistsubcategories;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement rednewbutton;
	@FindBy(xpath="//h1[text()='Add Sub Category']")private WebElement headeraddsubcategory;
	
	@FindBy(xpath="//select[@class='form-control selectpicker']")private WebElement categorydropdown;
	@FindBy(xpath="//input[@name='subcategory']")private WebElement subcategorytextfield;
	@FindBy(xpath="//button[@name='create']")private WebElement savebutton;
	
	public void clickOnManageCategory()
	{
		subcategory.click();
	}
	
public boolean IsListSubCategoriesPageLoaded()
{
	return headerlistsubcategories.isDisplayed();
}
public void clickOnNewInListSubCategory()
{
	rednewbutton.click();
}
public boolean IsAddSubCategoryWindowLoaded()
{
	return headeraddsubcategory.isDisplayed();
}
public void enterDataInAddSubcategoryWindow(String categorydropdownvalue,String subcategorytextfieldvalue)
{
	Select select=new Select(categorydropdown);
	select.selectByValue(categorydropdownvalue);
	
	subcategorytextfield.sendKeys(subcategorytextfieldvalue);
}
public void clickOnSaveButton()
{
	savebutton.click();
}
}
