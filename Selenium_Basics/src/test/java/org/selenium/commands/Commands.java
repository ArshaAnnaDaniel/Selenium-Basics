package org.selenium.commands;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


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
	@Test
	public void verifyFileUpload()
	{
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement choosefilefield=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		choosefilefield.sendKeys("C:\\Users\\Arsha\\git\\Selenium-Basics\\Selenium_Basics\\src\\main\\resources");
		WebElement acceptfield=driver.findElement(By.xpath("//input[@id='terms']"));
		acceptfield.click();
		WebElement submitbutton=driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submitbutton.click();

	}
	@Test
	public void verifyMultipleWindowHandling()
	{
		driver.get("https://demo.guru99.com/popup.php");
		String parentwindowhandleid=driver.getWindowHandle();
		System.out.println(parentwindowhandleid);  //alpha numeric string value
		WebElement clickhere=driver.findElement(By.xpath("//a[@target='_blank']"));
		clickhere.click();
		Set<String> windowhandlesid=driver.getWindowHandles();
		System.out.println(windowhandlesid);
		Iterator<String> value=windowhandlesid.iterator();
		while(value.hasNext())
		{
			String handleid=value.next();
			if(!handleid.equals(parentwindowhandleid)) //check wheather parent and child are equal
			{
				driver.switchTo().window(handleid);
				WebElement email=driver.findElement(By.xpath("//input[@name='emailid']"));  //locate the element
				email.sendKeys("arshaanna23@gmail.com");
				
				WebElement submit=driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submit.click();
				driver.close();  //close the child window
				
				
				
			}
			
		}
		driver.switchTo().window(parentwindowhandleid);  //switch to parent window
	}
	@Test
	public void validateSimpleAlert()
	{
		driver.get("https://demoqa.com/alerts");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='alertButton']")); 
		clickmebutton.click();
		Alert alert = driver.switchTo().alert();
		String clicktext=alert.getText();
		System.out.println(clicktext);
		alert.accept();
		
		
	}
	@Test
	public void validateConformationAlert()
	{
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement clickbutton=driver.findElement(By.xpath("//button[@id='confirmButton']")); 
		clickbutton.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement cancelmessage=driver.findElement(By.xpath("//span[@id='confirmResult']"));
		String actualmessage=cancelmessage.getText();
		String expectedmessage="You selected Cancel";
		Assert.assertEquals(actualmessage, expectedmessage,"Text selected is ok");
		
		
		
		
	}
	@Test
	public void validatePromptAlert()
	{
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebElement clickbutton=driver.findElement(By.xpath("//button[@id='promtButton']")); 
		clickbutton.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("arsha");
		alert.accept();
		WebElement promptafterclick=driver.findElement(By.xpath("//span[@id='promptResult']"));
        String actualmessage=promptafterclick.getText();
        System.out.println(actualmessage);
		String expectedmessage="You entered arsha";
		Assert.assertEquals(actualmessage, expectedmessage,"Text u entered doesn't match");
		
		}
	@Test
	public void verifyRightClick()
	{
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclickbutton=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions action=new Actions(driver);
		action.contextClick(rightclickbutton).build().perform();
		
		
	}
	@Test
	public void verifyDoubleClick()
	{
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclickbutton=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions action=new Actions(driver);
		action.doubleClick(doubleclickbutton).build().perform();
		Alert alert = driver.switchTo().alert();
		
		String alertmessage=alert.getText();
		System.out.println(alertmessage);
		alert.accept();
		
		
	}
	@Test
	public void verifyDragAndDrop()
	{
		driver.get("https://demoqa.com/droppable");
		WebElement dragbutton=driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dropbutton=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action=new Actions(driver);
		action.dragAndDrop(dragbutton,dropbutton).build().perform();
		
	}
	@Test
	public void verifyDragAndDropOffset()
	{
		driver.get("https://demoqa.com/dragabble");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		
		WebElement dragbutton=driver.findElement(By.xpath("//div[@id='dragBox']"));
		Actions action=new Actions(driver);
		action.dragAndDropBy(dragbutton, 150, 150).build().perform();
	}
	
	@Test
	public void verifyMouseOver()
	{
		driver.get("https://demoqa.com/menu/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
        Actions action=new Actions(driver);
        WebElement mainbutton=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        action.moveToElement(mainbutton).build().perform();
        WebElement subbutton=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        action.doubleClick(subbutton).build().perform();
        
		
	}
	@Test
	public void verifyJavascriptClickAndSendkeys()
	{
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js=(JavascriptExecutor)  driver; //convert driver to javascript
		js.executeScript("document.getElementById('newsletter-email').value='arshaanna23@gmail.com'");
		js.executeScript("document.getElementById('newsletter-subscribe-button').click()");
;
	}
	@Test
	public void verifyVerticalScroll()
	{
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	@Test
	public void verifyTestScreenshot()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualTitle=driver.getTitle();
		String expectedTitle="demowebshop";
		Assert.assertEquals(actualTitle,expectedTitle,"invalid title" );
		
	}
	@Test
	public void verifyFrames()
	{
		driver.get("https://demoqa.com/frames");
		List<WebElement> iframecount=driver.findElements(By.tagName("iframe"));
		int size=iframecount.size();
		System.out.println("Total no of iframe in webpage:"+ size);
		WebElement iframe=driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);    //switch to frame
		WebElement iframe_text=driver.findElement(By.id("sampleHeading"));
		String text=iframe_text.getText();
		System.out.println("iframe text is:"+text);
		driver.switchTo().defaultContent();     //back to webpage
	}
	@Test
	public void verifyDifferenceBetweenFindelementAndFindelements()
	{
		driver.get("https://demowebshop.tricentis.com/");
		//on match findelements
		WebElement subscribe=driver.findElement(By.id("newsletter-subscribe-button"));  
		System.out.println("WebElement on match:"+subscribe);
		List<WebElement> communitypool=driver.findElements(By.xpath("//li[@class='answer']//label"));
		int size=communitypool.size();
		System.out.println("the sizeof the community pool:"+size);
		
		//on zero match
		List<WebElement> communitypoolzeromatch=driver.findElements(By.xpath("//li[@class='answer12']//label"));
		int sizezeromatch=communitypoolzeromatch.size();
		System.out.println("the size of community pool on zero match:"+sizezeromatch);
		
		//on zero match findelement
		WebElement subscribebutton=driver.findElement(By.id("newsletter-subscribe-button12"));  
		System.out.println("WebElement on match:"+subscribebutton);
		
		//on 1 plus match
		WebElement communitypool2=driver.findElement(By.xpath("//li[@class='answer']//label"));
		communitypool2.click();  //returns first matching webelemnt
		
		
		
	}
	@Test
	
	public void verifyIframeHomework()
	{
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		WebElement text_input=driver.findElement(By.id("name"));
		text_input.sendKeys("iframe practice");
		WebElement iframe=driver.findElement(By.id("frm1"));
		driver.switchTo().frame(iframe);
		WebElement iframe_dropdown=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select=new Select(iframe_dropdown);
		select.selectByVisibleText("- Java");
		WebElement get_selected_value=select.getFirstSelectedOption();
		System.out.println(get_selected_value.getText());
		driver.switchTo().defaultContent();
		WebElement iframe2=driver.findElement(By.id("frm2"));
		driver.switchTo().frame(iframe2);
		WebElement iframe2_dropdown=driver.findElement(By.xpath("//select[@id='selectnav1']"));
		Select select2=new Select(iframe2_dropdown);
		select2.selectByVisibleText("- Java");
		
	}
	
	
	@Test
	public void verifyDynamicTable()
	{
		// to take value from table
		driver.get("https://money.rediff.com/indices");
		WebElement showmore=driver.findElement(By.id("showMoreLess"));
		showmore.click();
	    WebElement webtable=driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
	    List<WebElement> rows=webtable.findElements(By.tagName("tr"));
	    int rowcount=rows.size();
	    for(int i=0;i<rowcount;i++)
	    {
	    	List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));  //checking how many columns in that row
	    	int columncount=columns.size();
	    	for(int j=0;j<columncount;j++)
	    	{
	    		String cell_text=columns.get(j).getText();
	    		if(cell_text.equals("S&P BSE 200"))
	    		{
	    			System.out.println("previous close value is:"+columns.get(1).getText());
	    		}
	    	}
	    }
	}
	@Test
	public void verifyWaits()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait
		WebElement register=driver.findElement(By.className(".ico-register2"));
		register.click();
	}
	@Test
	public void verifyExplicitWait()
	{
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
		WebElement clickbutton=driver.findElement(By.id("timerAlertButton"));
		clickbutton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		
	}
	@Test
	public void verifyFluentWait()
	{
		driver.get("https://demoqa.com/alerts");
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
        FluentWait fluent=new FluentWait(driver);
        fluent.withTimeout(Duration.ofSeconds(20));
        fluent.pollingEvery(Duration.ofSeconds(2));  //after every execution it will wait for 2 seconds
        fluent.ignoring(NoSuchElementException.class);  //ignore the exception
        fluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("timerAlertButton")));
        WebElement clickme=driver.findElement(By.id("timerAlertButton"));
        clickme.click();
        fluent.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();
        
        
	}
	@Test
	public void verifySoftAssert()
	{
		SoftAssert soft=new SoftAssert();
		System.out.println("*******Testcase started***********");
		soft.assertEquals("Hello", "Hello","first soft assert is failed");
		System.out.println("************hard assert Successful*****************");
		soft.assertTrue("Hello".equals("hello"),"second soft assert is failed");
		System.out.println("********Second soft assert is failed***********");
		soft.assertTrue("Hi".equals("hi"),"third soft assert failed");
		System.out.println("********Testcase completed successfully***********");
		soft.assertAll();
		
		}
	
	
}
