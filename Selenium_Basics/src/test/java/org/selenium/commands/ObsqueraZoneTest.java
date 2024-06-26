package org.selenium.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ObsqueraZoneTest extends Browser_Launch {
	@Test
	public void verifySingleInputField()
	{
		String s="hai obsquara";

		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
		WebElement singleformdemo=driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
		singleformdemo.click();
		WebElement enter_message=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		enter_message.sendKeys(s);
		WebElement show_message=driver.findElement(By.xpath("//button[@id='button-one']"));
		show_message.click();
		WebElement your_message=driver.findElement(By.xpath("//div[@id='message-one']"));
		Assert.assertEquals(your_message.getText(),"Your Message : "+s ,"invalid message enterd");
		System.out.println(your_message.getText());

		
		
	}
	@Test
	public void verifyTwoInputFields()
	{
		int sum=15;
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
		WebElement singleformdemo=driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
		singleformdemo.click();
		WebElement enter_valueA=driver.findElement(By.xpath("//input[@id='value-a']"));
		enter_valueA.sendKeys("5");
		WebElement enter_valueB=driver.findElement(By.xpath("//input[@id='value-b']"));
		enter_valueB.sendKeys("10");
		WebElement get_total=driver.findElement(By.xpath("//button[@id='button-two']"));
		get_total.click();
		WebElement total_sum=driver.findElement(By.xpath("//div[@id='message-two']"));
		Assert.assertEquals(total_sum.getText(),"Total A + B : "+sum ,"incorrect sum");
		System.out.println(total_sum.getText());

	   
		
		
	}
	@Test
	public void verifyCheckBoxDemo()
	{
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		WebElement check_box_demo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		check_box_demo.click();
		WebElement check_box_click=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		check_box_click.click();
		boolean isselected=check_box_click.isSelected();
		Assert.assertTrue(isselected, "check box is selected");
		System.out.println("IsSelected "+isselected);

	}
	@Test
	public void verifyRadioButtonDemo()
	{
		
			 driver.get("https://selenium.qabible.in/simple-form-demo.php");
				WebElement radio_button_demo=driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
				radio_button_demo.click();
				WebElement female_radiobutton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
				female_radiobutton.click();
				boolean isselected=female_radiobutton.isSelected();
				Assert.assertTrue(isselected, "radio button is selected");
				System.out.println("IsSelected "+isselected);

	}
	@Test
	public void verifyFormWithValidation()
	{

			
			driver.get("https://selenium.qabible.in/simple-form-demo.php");
			WebElement form_submit=driver.findElement(By.xpath("//a[text()='Form Submit']"));
			form_submit.click();
			WebElement first_name=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
			first_name.sendKeys("arsha");
			WebElement last_name=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
			last_name.sendKeys("daniel");
			WebElement user_name=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
			user_name.sendKeys("anna");
			WebElement city=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
			city.sendKeys("mavelikara");
			WebElement state=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
			state.sendKeys("kerala");
			WebElement pincode=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
			pincode.sendKeys("690102");
			WebElement terms=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
			terms.click();
			WebElement submit=driver.findElement(By.xpath("//button[text()='Submit form']"));
			submit.click();
			WebElement message=driver.findElement(By.xpath("//div[text()='Form has been submitted successfully!']"));
			Assert.assertEquals(message.getText(),"Form has been submitted successfully!" ,"invalid user");
			System.out.println(message.getText());
			

	}
	@Test
	public void verifyTotalNumberOfDropDown() {
		driver.get("https://selenium.qabible.in/index.php");
		WebElement input_form=driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		input_form.click();
		WebElement select_input=driver.findElement(By.xpath("//a[text()='Select Input']"));
		select_input.click();
		WebElement colour_drop_down=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select= new Select(colour_drop_down);
		List<WebElement> drop_downcolours =select.getOptions();
		System.out.println(drop_downcolours.size());
		
	}
	@Test
	
    public void verifyColourSelectFromDropDown() {
		
		driver.get("https://selenium.qabible.in/index.php");
		WebElement input_form=driver.findElement(By.xpath("(//div[@id='collapsibleNavbar']//li[@class='nav-item'])[1]"));
		input_form.click();
		WebElement select_input=driver.findElement(By.xpath("//a[text()='Select Input']"));
		select_input.click();
		WebElement colour_drop_down=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select= new Select(colour_drop_down);
		select.selectByVisibleText("Red");
		WebElement selected=select.getFirstSelectedOption();
		Assert.assertEquals(selected.getText(),"Red","colour doesn't match");
		System.out.println(selected.getText());
		
	}

	

}
