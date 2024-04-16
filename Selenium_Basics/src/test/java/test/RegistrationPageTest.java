package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.constants.Contants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.Random_Data_Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationPageTest extends Base{
  @Test(priority=4,groups="Smoke")

  public void verifyRegisterPageTitle()throws IOException
  {
	  WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
	  register.click();
	  String actual_tittle=driver.getTitle();
	  //System.out.println(actual_tittle);
	  String data=ExcelUtility.readStringData(0, 0, Contants.REGISTRATION_PAGE_DATA);
	  Assert.assertEquals(actual_tittle, data,Messages.TITLE_MISMATCH);

  }
  @Test(priority=3,groups="Regression")

  public void verifyUserRegister() throws IOException
  {
	  String firstname=Random_Data_Utility.getFirstName();
	  String lastname=Random_Data_Utility.getLastName();
	  
	  String email=firstname+"."+lastname+"123@yahoo.com";
	  
	  String password=firstname+"."+lastname;
	 // String confirmpass=ExcelUtility.readStringData(5, 0, Contants.REGISTRATION_PAGE_DATA);
	  //WebElement register=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
	 // register.click();
	  HomePage home=new HomePage(driver);
	  RegistrationPage register=home.clickOnRegisterMenu();
	
	  WebElement gender=driver.findElement(By.xpath("//input[@id='gender-female']"));
	  gender.click();
	  WebElement first_name=driver.findElement(By.id("FirstName"));
	  first_name.sendKeys(firstname);
	  
	  WebElement last_name=driver.findElement(By.id("LastName"));
	  last_name.sendKeys(lastname);
	  WebElement e_mail=driver.findElement(By.id("Email"));
	  e_mail.sendKeys(email);
	  WebElement pass=driver.findElement(By.id("Password"));
	  pass.sendKeys(password);
	  WebElement con_pass=driver.findElement(By.id("ConfirmPassword"));
	  con_pass.sendKeys(password);
	  WebElement register_click=driver.findElement(By.id("register-button"));
	  register_click.click();
	  WebElement user_email_field=driver.findElement(By.className("account"));
	  String actual_email=user_email_field.getText();
	  
	  Assert.assertEquals(actual_email,email, Messages.USER_REGISTRATION_FAIL);

  }
}
