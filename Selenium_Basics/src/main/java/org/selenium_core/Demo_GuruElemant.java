package org.selenium_core;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_GuruElemant {
	
	public void verifyDemoTourRegistration(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		//driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		//WebElement register_element=driver.findElement(By.partialLinkText("REGISTER"));
		//register_element.click();

		WebElement firstname_element=driver.findElement(By.name("firstName"));
		firstname_element.sendKeys("ArshaAnna");
		WebElement lastname_element=driver.findElement(By.name("lastName"));
		lastname_element.sendKeys("Daniel");
		WebElement phone_element=driver.findElement(By.name("phone"));
		phone_element.sendKeys("9754654334");
		WebElement email_element=driver.findElement(By.id("userName"));
		email_element.sendKeys("arshaanna23@gmail.com");
		WebElement address_element=driver.findElement(By.name("address1"));
		address_element.sendKeys("gfhtetretytu");
		WebElement city_element=driver.findElement(By.name("city"));
		city_element.sendKeys("ernakulam");
		WebElement state_element=driver.findElement(By.name("state"));
		state_element.sendKeys("kerala");
		WebElement postalcode_element=driver.findElement(By.name("postalCode"));
		postalcode_element.sendKeys("690102");
		WebElement country_element=driver.findElement(By.name("country"));
		//country_element.sendKeys("india");
		WebElement username_element=driver.findElement(By.id("email"));
		username_element.sendKeys("arsha");
		WebElement password_element=driver.findElement(By.name("password"));
		password_element.sendKeys("anna");
		WebElement confirmpassword_element=driver.findElement(By.name("confirmPassword"));
		confirmpassword_element.sendKeys("anna");
		WebElement submit_element=driver.findElement(By.name("submit"));
		submit_element.click();
		driver.close();
	}
	public void validateDemoWebShopUserLogin()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement login_element=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		login_element.click();
		WebElement emailField=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		emailField.sendKeys("arshaanna23@gmail.com");
		WebElement passwordField=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
		passwordField.sendKeys("arsha");
		WebElement loginButton=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[1]/h1"));
		loginButton.click();
		driver.close();
		
		
	}
	public void verifyLinkText()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement link_element=driver.findElement(By.linkText("your destination"));
		link_element.click();
		driver.close();
		
		
	}
	public void verifyPartialLinkText()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement link_element=driver.findElement(By.partialLinkText("destination"));
		link_element.click();
		driver.close();
	}
	public void validateTotalNumberOfTagsInTheApplication()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		List<WebElement> inputname=driver.findElements(By.tagName("input"));
		int numberoftags=inputname.size();
		System.out.println(numberoftags);
		driver.close();
	}
	public void validateDemoWebShopUserlogin()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement login=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.header > div.header-links-wrapper > div.header-links > ul > li:nth-child(2) > a"));
		login.click();
		WebElement email=driver.findElement(By.cssSelector("#Email"));
		email.sendKeys("artf2343@gmail.com");
		WebElement password=driver.findElement(By.cssSelector("#Password"));
		password.sendKeys("1234");
		WebElement loginButton=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
		loginButton.click();
		driver.close();
	
	}
	public void verifyIsSelected()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		WebElement radiobuttonfemale=driver.findElement(By.xpath("//input[@id='gender-female']"));
		boolean isfemaleselected=radiobuttonfemale.isSelected();
		System.out.println("female element before selected:"+isfemaleselected);
		radiobuttonfemale.click();
		boolean afterfemaleselected=radiobuttonfemale.isSelected();
		System.out.println("female element after selection:"+afterfemaleselected);
		driver.close();
		
	}
	public void verifyIsEnabled()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement subscribebutton=driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		boolean issubscribe=subscribebutton.isEnabled();
		System.out.println("subscribe button :"+issubscribe);
		
		driver.close();
		
	}
	public void verifyIsDisplayed()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement votebutton=driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		boolean isvote=votebutton.isDisplayed();
		System.out.println("vote button :"+isvote);
		
		driver.close();
		
	}

	public static void main(String[] args) {
		Demo_GuruElemant demo=new Demo_GuruElemant();
		//demo.verifyDemoTourRegistration();
		
		//demo.validateDemoWebShopUserLogin();
		//demo.verifyLinkText();
		//demo.verifyPartialLinkText();
		//demo.validateTotalNumberOfTagsInTheApplication();
		//demo.validateDemoWebShopUserlogin();
		//demo.verifyIsSelected();
		demo.verifyIsEnabled();
		//demo.verifyIsDisplayed();


	}

}
