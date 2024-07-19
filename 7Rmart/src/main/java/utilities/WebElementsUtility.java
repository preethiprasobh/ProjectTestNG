package utilities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

public class WebElementsUtility {
	// Method to check if a WebElement is displayed and assert
    public boolean isElementDisplayed(WebElement element) {
    	
    	boolean isdisplayed=element.isDisplayed();
		return isdisplayed;
     
    }

    // Method to check if a WebElement is selected and assert
    public boolean isElementSelected(WebElement element) {
    	boolean isselected=element.isSelected();
    	return isselected;
       
    }

    // Method to check if a WebElement is enabled and assert
    public boolean isElementEnabled(WebElement element) {
    	boolean isenabled=element.isEnabled();
      return isenabled;
    }
    /*public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if element is not found or not displayed
        }*/

    }
