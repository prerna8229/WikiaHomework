package pageFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contribute {
	WebDriver driver;
	@FindBy (css="#AccountNavigation > li > div > a[data-id=userpage]")
	WebElement userProfile;
	
	@FindBy (css="#WikiHeader > div.buttons > nav")
	WebElement buttonContribute;
	
	@FindBy (css="#WikiHeader > div.buttons > nav > ul > li > a[data-id=wikiavideoadd]")
	WebElement addVideoLink;
	
	@FindBy (id="wpWikiaVideoAddUrl")
	WebElement url;
	
	@FindBy (css="#mw-content-text > form > div > input[type='submit']")
    WebElement addButton;
	
	@FindBy (css="#WikiaPage > div.WikiaPageContentWrapper > div > div > div")
    WebElement flashMessage;
	
	@FindBy (css="#WikiaPage > div.WikiaPageContentWrapper > div > div > div > a")
    WebElement fileName;
	
	String requestUri = null;

	
	
	public Contribute(WebDriver driver)
	{
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	public String getProfileName(){
		
			 System.out.println(userProfile.getAttribute("title"));
			 return userProfile.getAttribute("title");
	 }
	 

	
	
	
	public void clickElement(WebElement e)
	{
		e.click();
	}
	
	public void setVideoUrl(String videoUrl)
	{
		url.sendKeys(videoUrl);
	}
	
	public String getFileNameFromMessage() 
	{
		if(flashMessage.isDisplayed())
		{
		//get the file name from the flash message
	String messageUrl=	fileName.getAttribute("title");
	messageUrl= messageUrl.split(":")[1];
	return messageUrl;
		}
		
		else 
			{
			throw new NoSuchElementException("Message not displayed");
			}
		
	
	}
	
	public String getFileNameFromUrl() 
	{
		try
		{
			this.clickElement(fileName);	
			String currentUrl = driver.getCurrentUrl();
			
			//get the filename from the current url by splitting the actual url string
			if(currentUrl.startsWith("http://"))
			{
				requestUri= currentUrl.substring(7).split(":")[1];
			}
			else
			{
				requestUri= currentUrl.split(":")[1];
			}
			//replace all _ with spaces in the filename
			requestUri= requestUri.replaceAll("_", " ");
			
			
				
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("Filename not found");
		}
			
		return requestUri;
		}
	
		
	

	
	
	public void addVideo(String userUrl){
		 
        this.clickElement(buttonContribute);
        
        this.clickElement(addVideoLink);
 
        this.setVideoUrl(userUrl);
        
        this.clickElement(addButton);
 
        
 
                 
 
    }
	
	
	
}