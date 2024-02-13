package org.selenium_core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Web_Element_Commands {
	public void verify_SwagLabs_Username() {
		WebDriver driver = new ChromeDriver();
		WebElement username_element=driver.findElement(By.id("user-name"));
		WebElement password_element=driver.findElement(By.id("password"));
		WebElement login_element=driver.findElement(By.id("login-button"));
		

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		


	}

}
