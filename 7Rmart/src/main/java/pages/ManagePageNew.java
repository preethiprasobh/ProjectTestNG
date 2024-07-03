package pages;

import javax.swing.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePageNew {
	WebDriver driver;
	public ManagePageNew(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[1]/div/a")private WebElement managepagesmoreinfo;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbuttonmangepage;
	
	@FindBy(xpath="//h1[text()='Add Pages']")private WebElement addpageswindow;
	
	@FindBy(xpath="//input[@placeholder=\"Enter the Title\"]")private WebElement title ;
	@FindBy(xpath="//div[@class='note-editable card-block']")private WebElement description ;
	@FindBy(xpath="//input[@placeholder='Enter Page Name']")private WebElement page ;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")private WebElement savebutton ;
	
	public void managePagesMoreInfolinkClick()
	{
		managepagesmoreinfo.click();	
	}
	public boolean IsManagePageLoaded()
	{
		return  newbuttonmangepage.isDisplayed();
	}
	public void clickOnNewButton()
	{
		newbuttonmangepage.click();
	}
	public boolean IsAddPagesWindowLoaded()
	{
		return addpageswindow.isDisplayed();
	}
	public void enerPageInformation(String titledata,String descriptiondata,String pagedata)
	{
		title.sendKeys(titledata);
		description.sendKeys(descriptiondata);
		page.sendKeys(pagedata);
	}
	public void clickOnSaveButton()
	{
		savebutton.click();
		driver.navigate().back();
		
		
	}
	
	
}


