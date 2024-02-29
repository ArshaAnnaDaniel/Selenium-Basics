package org.selenium.commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Browser_Launch {
	public WebDriver driver;
	public void Initialize_Browser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("invalid browser recieved");
		}
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void classBrowser()
	{
		driver.close();
	}
	@BeforeMethod
	public void setup()
	{
		Initialize_Browser("chrome");
	}


}
