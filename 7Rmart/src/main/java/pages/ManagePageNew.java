package pages;

import java.awt.AWTException;

import javax.swing.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManagePageNew {
	WebDriver driver;
	FileUploadUtility fileuploadutilities =new FileUploadUtility();
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
	
	@FindBy(xpath="//input[@name='main_img']")private WebElement imagebutton ;
	@FindBy(xpath="//div[@id='imagePreview']")private WebElement imagepreview ;
	
	@FindBy(xpath="//button[text()='Save']")private WebElement savebutton ;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div/div")private WebElement alertbox ;
	
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
		WaitUtility waitutility=new WaitUtility();
		waitutility.waitForElement(driver,title);
		System.out.println("Add page window loaded");
		title.sendKeys(titledata);
		//waitutility.waitForElementText(driver, description,  descriptiondata);
		description.sendKeys(descriptiondata);
		//waitutility.waitForElementText(driver, page,  pagedata);
		page.sendKeys(pagedata);
	//	waitutility.waitForElementText(driver, page,  pagedata);
		System.out.println("information entered correctly");
	}
	public void clickOnAddImage() throws AWTException
	{
		WaitUtility waitutility=new WaitUtility();
		//waitutility.waitForElementToBeClickable(driver,imagebutton);
		
		fileuploadutilities.fileUploadUsingSendKeys(imagebutton,Constants.TESTDATAFILEImAGEMANAGEPAGESADD);
		waitutility.waitForElement(driver, imagepreview);
		System.out.println("Image is Added");
	}
	public void clickOnSaveButton()
	{
		//WaitUtility waitutility=new WaitUtility();
		//waitutility.waitForElementToBeClickable(driver,savebutton);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",savebutton);
		//savebutton.click();
		System.out.println("Save button is clicked");
		driver.navigate().back();
		
	}
	public boolean IsAlertBoxLoaded()
	{
		return alertbox.isDisplayed();
	}
	
	
	
}


