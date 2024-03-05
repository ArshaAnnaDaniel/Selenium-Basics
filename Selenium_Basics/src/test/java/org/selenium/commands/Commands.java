package org.selenium.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Commands extends Browser_Launch {
	@Test
	public void verifyCommunityPool()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> communitypollelements=driver.findElements(By.xpath("//label[starts-with(@for,'pollanswe')]//parent::li"));
		for(int i=0;i<communitypollelements.size();i++)
		{
			//System.out.println(communitypollelements.get(i).getText());
			String polloptiontext=communitypollelements.get(i).getText();
			if(polloptiontext.equals("Poor"))
			{
				communitypollelements.get(i).click();
			}
		}
	}
	@Test
	public void verifyCurrentUrl()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualcurrent_url=driver.getCurrentUrl();  //assertion
		String expectedcurrent_url="https://demowebshop.tricentis.com/";
		Assert.assertEquals(actualcurrent_url, expectedcurrent_url,"invalid current url");
		
	}
	@Test
	public void verifyPageTitle()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualcurrent_title=driver.getTitle(); 
		String expectedcurrent_title="Demo Web Shop";
		Assert.assertEquals(actualcurrent_title,expectedcurrent_title,"invalid current title" );
		
	}
	@Test
	public void verifyIsSelected()
	{
		boolean isfemaleselected;
		driver.get("https://demowebshop.tricentis.com/register");
		
		WebElement radiobuttonfemale=driver.findElement(By.xpath("//input[@id='gender-female']"));
		isfemaleselected=radiobuttonfemale.isSelected();  //actual result
		Assert.assertFalse(isfemaleselected,"radio button is selected");
		System.out.println("female element before selected:"+isfemaleselected);
		radiobuttonfemale.click();
		isfemaleselected=radiobuttonfemale.isSelected();
		Assert.assertTrue(isfemaleselected, "radiobutton is not selected");
		System.out.println("female element after selected:"+isfemaleselected);
		
		
		
	}
	@Test
	public void verifyIsEnabled()
	{
		driver.get("https://demowebshop.tricentis.com/");
		WebElement subscribebutton=driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean issubscribe=subscribebutton.isEnabled();
		Assert.assertTrue(issubscribe, "subscribe button is enabled");
		
		
		
		
	}
	@Test
	public void verifyIsDisplayed()
	{
		
		driver.get("https://demowebshop.tricentis.com/");
		
		WebElement votebutton=driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isvote=votebutton.isDisplayed();
		Assert.assertTrue(isvote, "vote button is displayed");
		
		

		
	}
	@Test
	public void verifyUserLogin()
	{
		String s="arshaanna23@gmail.com";
		driver.get("https://demowebshop.tricentis.com/");
		WebElement login=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		login.click();
		WebElement email=driver.findElement(By.cssSelector("#Email"));
		email.sendKeys("arshaanna23@gmail.com");
		WebElement password=driver.findElement(By.cssSelector("#Password"));
		password.sendKeys("kochu@2328");
		WebElement loginButton=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginButton.click();
		
		WebElement home_email=driver.findElement(By.cssSelector(".account"));
		Assert.assertEquals(home_email.getText(),s,"Invalid login");
		System.out.println(home_email.getText());
		
	}
	@Test
	public void verifyValuesFromDropdown()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(countryDropdown);
		//select.deselectByVisibleText("INDIA");
		//select.selectByIndex(5);
		select.selectByValue("AMERICAN SAMOA");
		WebElement getCountryName=select.getFirstSelectedOption();
		System.out.println(getCountryName.getText());

		//select.getFirstSelectedOption("");
		
	}
	@Test
	
	public void verifyTotalNoofDropdownValues()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countryDropdown=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(countryDropdown);
		List<WebElement>listofdropdownelements=select.getOptions();
		System.out.println(listofdropdownelements.size());
	}
	@Test
	public void verifyMultiSelectDropdown()
	{
		driver.get("https://selenium.qabible.in/select-input.php");
		WebElement multiselect=driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select select=new Select(multiselect);
		boolean selectedvalue=select.isMultiple();
		System.out.println(selectedvalue);
		select.selectByVisibleText("Red");
		select.selectByVisibleText("Yellow");
		List<WebElement>listofselectedvalues=select.getAllSelectedOptions();
		for(WebElement e:listofselectedvalues)
		{
			System.out.println(e.getText());
		}
		select.deselectByValue("Red");
		
	}

}
