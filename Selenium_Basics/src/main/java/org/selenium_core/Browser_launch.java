package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_launch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/"); //loading web url
		driver.manage().window().maximize();
		String page_title=driver.getTitle();
		System.out.println(page_title);
		String page_url=driver.getCurrentUrl();
		System.out.println(page_url);
		String page_source=driver.getPageSource(); //get html code
		System.out.println(page_source);
		driver.close();

	}

}
