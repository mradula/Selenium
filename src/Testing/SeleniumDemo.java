package Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class SeleniumDemo
{
	public boolean isAlreadyLogIn=false;
    WebDriver driver;
    @BeforeTest
    @Parameters("browser")

    public void setup(String browser) throws Exception
    {
        //if parameter passed is 'firefox'
        if(browser.equalsIgnoreCase("firefox"))
        {          
        	//set path to chromedriver.exe 
        	String exegeckoPath = "C:\\Users\\kbakshi\\Documents\\geckodriver-v0.10.0-win64\\geckodriver.exe";
        	//create firefox instance
    		System.setProperty("webdriver.gecko.driver", exegeckoPath);
            driver = new FirefoxDriver();
        }

        //if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome"))
        {
            //set path to chromedriver.exe 
            System.setProperty("webdriver.chrome.driver","C:\\Users\\kbakshi\\Documents\\chromedriver_win32\\chromedriver.exe");
            //create chrome instance
           driver = new ChromeDriver();
       }
        else
        {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Open the website
    	driver.get("http://www.match.com");
    	//Maximize window
		driver.manage().window().maximize();
    }

  	@Test
    public void testParameterWithXML() throws InterruptedException
    {
  		String useremail = "gmanugiri@gmail.com";
  		String passwd = "123456";
  		String username = "USer25";
  		
		//Set "I am"  drop down
		setElementByNameDropDown("gc","Man");
	    //Set "Seeking a" drop down
		setElementByNameDropDown("tr","Woman");
		//Set MInimum age	
		setElementByNameDropDown("lage","30");
		//Set Max age	
		setElementByNameDropDown("uage","45");
				
				
		WebElement ZipCode=driver.findElement(By.xpath("//input[contains(@class, 'matchSearchFormZipInput')]")); 
		ZipCode.clear();
		ZipCode.sendKeys("75057");
				
		driver.findElement(By.xpath("//button[contains(.,'View Photos')]")).click();
	    //Set email
		setElementByNameText("email",useremail);
		Thread.sleep(500);
		//Set password
		setElementByNameText("password",passwd);		
		//Set birth month drop dowm
		setElementByNameDropDown("birthMonth","Apr");	
		//Set birth day drop down
		setElementByNameDropDown("birthDay","19");
		//Set birth year drop down
		setElementByNameDropDown("birthYear","1998");
		//CLick continue button
		driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
		Thread.sleep(500);
		//Set user name 
		setElementByNameText("handle",username);
		Thread.sleep(500);
		
		
		//Using Absolute XPath because there are two Continue button in the page with same class name
		driver.findElement(By.xpath("html/body/div[13]/div/div[2]/div[1]/div[2]/div[3]/div[2]/button")).click();
		
		//Assert.assertTrue("User logged in successfully? ", driver.getTitle().trim().equals("Let's get started and find you a date!"));
		
		//CLick start matching button
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a")).click();

		Thread.sleep(5000);
		 
		//**************About your date***************//
		//First Keep going button click  
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		Thread.sleep(500);
		//Second keep going button click 
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		//Third keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		
		//Fourth keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		
		//Fifth keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
				
		//*********************About you ************************//		
		
		//First Keep going button click  
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		Thread.sleep(500);
		//Second keep going button click 
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		//Third keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
				
		//Fourth keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
				
		//Fifth keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();
		//Sixth keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();

		//Seven keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();

		WebElement AboutYourSelf = driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[2]/div[2]/div/div[1]/div[1]/textarea")); 
		AboutYourSelf.sendKeys("I'm a genuine, creative and thoughtful person who'd like to be with someone who is both, too. I'm looking for someone with aspirations of growing, learning and always becoming a better person.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Eight keep going button click
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/form/div[3]/a[1]")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/div[1]/div[3]/form/input[1]")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[4]/div/div/div/form/div[3]/input")).click();
				
		//Next step button click
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[4]/div/div/div[1]/div[3]/a")).click();
				
		//Search user
		SearchForUser();
		//Sign out the user 		
		logOut();
		//Assert.assertTrue("User logged out successfully? ", driver.getTitle().trim().equals("So long, friend. See you soon."));
		// Sign in again
		logIn(useremail, passwd);
		
		//add at least one user as a favorite
		CkeckUserAddedToFavList();
		
		Thread.sleep(500);
		logOut();
		driver.close();

    }
    //Method to set the text value
    public void setElementByNameText(String byname,String value) throws InterruptedException{
    	
    	WebElement element = driver.findElement(By.name(byname));
    	element.clear();
    	Thread.sleep(500);
    	element.sendKeys(value);		
    	
    }
    //Method to set the drop down value
   public void setElementByNameDropDown(String byname,String value){
    	
    	WebElement element = driver.findElement(By.name(byname)); 
    	Select mySelectMonth = new Select(element);
		mySelectMonth.selectByVisibleText(value);
    	   	
    }
   
   public void logIn(String userID, String password) throws InterruptedException
   {
	   //To check If already login previously then don't execute this function.
	   if(!isAlreadyLogIn){
	    //If Not login then login In to your account.
		//Set email
		setElementByNameText("email",userID);
		//Set password
		setElementByNameText("password",password);		
		driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div/div/section/div/div/form/fieldset[2]/button")).click();
	    isAlreadyLogIn=true;
	   }
	 }
	  
	 public void logOut() throws InterruptedException
	 {
		    WebElement menuLOgOUt = driver.findElement(By.xpath("html/body/form/div[2]/div[1]/div/ul/li[8]/a/div/span"));
			Actions Logbuilder = new Actions(driver);
			Logbuilder.moveToElement(menuLOgOUt).build().perform();
			Thread.sleep(500);
			//identify  sign out menu option and click
			WebElement menulogOption = driver.findElement(By.xpath("html/body/form/div[2]/div[1]/div/ul/li[8]/ul/li[3]/a"));
			Actions Logoutbuilder = new Actions(driver);
			Logoutbuilder.moveToElement(menulogOption).build().perform();
			Thread.sleep(500);
			menulogOption.click();
			
	  }
	 public void CkeckUserAddedToFavList() throws InterruptedException
	 {
		//Navigate to connection navigation
		WebElement myConnectionNav = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/ul/li[4]/a/div/span "));
		Actions Connectionbuilder = new Actions(driver);
		Connectionbuilder.moveToElement(myConnectionNav).build().perform();
		Thread.sleep(5000);
		
		// Click my favorite 
		WebElement myFavNav = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/ul/li[4]/ul/li[6]/a"));
		Actions myFavbuilder = new Actions(driver);
		myFavbuilder.moveToElement(myFavNav).build().perform();
		Thread.sleep(5000);
		myFavNav.click();
	 }
	 public void SearchForUser() throws InterruptedException
	 {
			//locate the search menu 
			WebElement menu = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/ul/li[2]/a/div/span"));
			Actions builder = new Actions(driver);
			builder.moveToElement(menu).build().perform();
			Thread.sleep(5000);
			//CLick the search navigation
			WebElement menuOption = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/ul/li[2]/a/div/span"));
			menuOption.click();								
		    Thread.sleep(500);
		    
			//Add value to search box 
			WebElement Search=driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/form/input")); 
			Search.sendKeys("Jenny");
			Thread.sleep(500);
			//CLick search button  
			driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/div[1]/div/div/div/div/form/button")).click();
			Thread.sleep(5000);
			
			//Add to favorites by clicking Save button
			driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[2]/div/div[3]/span/a/span")).click();
			Thread.sleep(5000);
	 }
    
}
