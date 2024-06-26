package org.selenium.commands;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
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
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeScreenshot(result);
		}
	
		driver.close();
	}
	@BeforeMethod
	public void setup()
	{
		Initialize_Browser("chrome");
	}
	
	public void takeScreenshot(ITestResult result) throws IOException
	{
		TakesScreenshot takescreenshot=(TakesScreenshot) driver;                             //create reference
		File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);                     //getscreenshot are stored in to file
		FileUtils.copyFile(screenshot, new File("./ScreenShot/"+result.getName()+".png"));   //create a folder
		
		
	}


}
