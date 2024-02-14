package org.selenium_core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Web_Element_Commands {
	public void verify_SwagLabs_Username() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement username_element=driver.findElement(By.id("user-name"));
		username_element.sendKeys("standard_user");
		WebElement password_element=driver.findElement(By.id("password"));
		password_element.sendKeys("secret_sauce");
		WebElement login_element=driver.findElement(By.id("login-button"));
		login_element.click();
		/*String tagname=login_element.getTagName();
		System.out.println(tagname);*/
		driver.close();
		

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Web_Element_Commands  web = new Web_Element_Commands();
		web.verify_SwagLabs_Username();
		

		
		
		
		


	}

}
