package org.selenium_core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_GuruElemant {
	public void verifyDemoTourRegistration(){
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
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
		country_element.sendKeys("india");
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

	public static void main(String[] args) {
		Demo_GuruElemant demo=new Demo_GuruElemant();
		demo.verifyDemoTourRegistration();


	}

}
