package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox_Browser_launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demowebshop.tricentis.com/"); //loading web url
		driver.manage().window().maximize();  // to maximize the window


	}

}
