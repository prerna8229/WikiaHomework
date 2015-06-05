package pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	WebDriver driver;
	
	@FindBy (id="usernameInput")
	WebElement userName;
	
	@FindBy (id="passwordInput")
	WebElement loginPassword;
	
	@FindBy (xpath="//*[@id='UserLoginDropdown']/form/fieldset/div[7]/input")
	WebElement loginButton;	
	
	@FindBy (xpath="//*[@id='AccountNavigation']/li/div[1]/span")
	WebElement labelSignIn;
	
	
	
	
	public Login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		if (!"http://qm-homework.wikia.com/wiki/QM_HomeWork_Wikia".equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the home page");
        }

	}
	
	
	public void  locateLogin ()
	{
		if(labelSignIn.isDisplayed())
		{
		Actions builder = new Actions(driver);
		builder.moveToElement((WebElement) labelSignIn).build().perform();
		}
		
		else System.out.println("Login link not found");
	}
	
	
	
	public void setUserName(String strUserName){
		 
       userName.sendKeys(strUserName);
 
         
 
    }
	
	
	 public void setPassword(String strPassword){
		 
		 loginPassword.sendKeys(strPassword);
		 
		    }
	 
	 
	 public void clickLogin(){
		 
		 loginButton.click();

 }
	 
	 
	
	 
	 
	 public void loginToWikia(String strUserName,String strPasword){
		 
	        //Fill user name
	 
	        this.setUserName(strUserName);
	 
	        //Fill password
	 
	        this.setPassword(strPasword);
	 
	        //Click Login button
	 
	        this.clickLogin();
	 
	                 
	 
	    }
	 
	 
	 
	
	

	
	
	
	
}