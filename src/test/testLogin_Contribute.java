package test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageFactory.Contribute;
import pageFactory.Login;

public class testLogin_Contribute {
	
	
	
	WebDriver driver;
	Login objLogin;
	Contribute objContribute;
	
	@BeforeTest
	@Parameters ("browser")
	
	public void setup(String browser) throws Exception
	{
		 if(browser.equalsIgnoreCase("firefox")){
			 
		            driver = new FirefoxDriver();
		 
		        }
		 
		 else if(browser.equalsIgnoreCase("chrome")){
			 
	            System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	 
	             driver = new ChromeDriver();
	 
	        }
		 
		 else{
	 
	            throw new Exception("Browser is not correct");
	 
	         }
		  
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	        driver.get("http://qm-homework.wikia.com");
	}
	
	
	@Test
	
	public void test_Login_Page() throws InterruptedException {
		 
 
    objLogin = new Login(driver);
   
	objLogin.locateLogin();
	
	objLogin.loginToWikia("prerna8229", "Babu90patil!");
    objContribute = new Contribute(driver);
    //Check if login has been replaced by profile name once logged in
    Assert.assertTrue(objContribute.getProfileName().contains("Prerna8229"));
    //add video once logged in
    objContribute.addVideo("http://www.youtube.com/watch?v=h9tRIZyTXTI");
    //Check if file name from the URL is the same as on the flash message
    Assert.assertTrue(objContribute.getFileNameFromMessage().equals(objContribute.getFileNameFromUrl()));
    
 
	

}
	
	 @AfterTest
	    public void teardown() {
	       // driver.quit();
	    }
	
	

}
