// package and import statement 
package cms.pages;
import org.openqa.selenium.WebDriver;

public class BasePage {							//Class declaration
		
	protected WebDriver driver;					//Class Variables : declares a protected instance variable driver of type WebDriver

// Define Constructor 
	public BasePage(WebDriver driver) {     	// is the constructor of the BasePage class.
    this.driver = driver; 	
	}

// Common methods that can be used across different page classes
public void navigateTo(String url) { 			// public void navigateTo(String url) is a method defined within the BasePage class.
												// This method takes a String parameter url
    driver.navigate().to(url);					// Inside the method, driver.navigate().to(url); uses the driver instance to navigate the browser to the specified URL (url).
    
}

}