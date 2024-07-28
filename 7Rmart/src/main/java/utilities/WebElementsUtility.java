package utilities;

import org.openqa.selenium.WebElement;

public class WebElementsUtility {
	
    public boolean isElementDisplayed(WebElement element) {
    	
    	boolean isdisplayed=element.isDisplayed();
		return isdisplayed;
     
    }

    
    public boolean isElementSelected(WebElement element) {
    	boolean isselected=element.isSelected();
    	return isselected;
       
    }

   
    public boolean isElementEnabled(WebElement element) {
    	boolean isenabled=element.isEnabled();
      return isenabled;
    }
    
    public String getElementText(WebElement element) {
    	String text=element.getText();
        return text;
    }
    
    public boolean isImageDisplayed(WebElement imageElement) {
    	boolean isimagedisplayed=imageElement.isDisplayed();
        return isimagedisplayed;
    }
    

    }
