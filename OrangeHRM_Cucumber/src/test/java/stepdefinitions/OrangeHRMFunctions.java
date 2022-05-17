package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMFunctions 
{
	WebDriver driver;

	@Given("^i open a browser with url \"([^\"]*)\"$")
	public void i_open_a_browser_with_url(String url)  
	{
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	    
	}

	@Then("^i should see Login Module$")
	public void i_should_see_Login_Module() 
	{
		if (driver.findElement(By.id("logInPanelHeading")).isDisplayed())
		{
		System.out.println("Login Module Displayed Sucssessfully");	
		} else 
		{
			System.out.println("Login Module Display Failed");
		}
		
	    
	}

	@When("^i enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) 
	{
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
	   
	}

	@When("^i enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password)  
	{
	    
		driver.findElement(By.id("txtPassword")).sendKeys(password);		
	}

	@When("^i click login$")
	public void i_click_login() 
	{
		
		driver.findElement(By.id("btnLogin")).click();
	    
	}

	@Then("^i should see Admin Module$")
	public void i_should_see_Admin_Module() 
	{
		if (driver.findElement(By.linkText("Admin")).isDisplayed())
		{
		System.out.println("Admin Module Displayed Sucssessfully");	
		} else 
		{
			System.out.println("Admin Module Display Failed");
		}
		
	   
	}

	@When("^i click logout$")
	public void i_click_logout() throws Throwable 
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
	   
	}

	@Then("^i should see Login Moule$")
	public void i_should_see_Login_Moule() 
	{
		if (driver.findElement(By.id("logInPanelHeading")).isDisplayed())
		{
		System.out.println("Login Module Displayed Sucssessfully");	
		} else 
		{
			System.out.println("Login Module Display Failed");
		}
		
	   
	}
	
	@Then("^i close Browser$")
	public void i_close_Browser() 
	{
		driver.close();
	    
	}
	
	
}
