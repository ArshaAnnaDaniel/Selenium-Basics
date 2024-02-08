package org.selenium_core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge_Browser_launch {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://demowebshop.tricentis.com/apparel-shoes"); //loading web url
		driver.manage().window().maximize();  // to maximize the window

	}

}
