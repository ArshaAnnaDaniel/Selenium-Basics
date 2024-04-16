package org.selenium.utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {
	public static void clickOnElement(WebElement element)
	{
		element.click();	}
	
	public static void enterValue(WebElement element, String valuetoenter)
	{
		element.sendKeys(valuetoenter);
	}
	public static String getText(WebElement element)
	{
		return element.getText();
	}
	public static boolean isElementSelected(WebElement element)
	{
		boolean status=element.isSelected();
		return status;
	}

}
