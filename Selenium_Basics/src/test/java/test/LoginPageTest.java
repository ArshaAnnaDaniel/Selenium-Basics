package test;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.constants.Contants;
import org.selenium.constants.Messages;
import org.selenium.utilities.ExcelUtility;
import org.selenium.utilities.Random_Data_Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import data_provider.DataProviders;
import pages.HomePage;
import pages.LoginPage;
import pages.UserAccount;

public class LoginPageTest extends Base {
  @Test(priority=5,groups="Smoke")
  public void verifyLoginPageTitle()throws IOException
  {
	  
		  
		  //WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		  //login.click();
	      HomePage home=new HomePage(driver);  //aggregation oops concept
	      LoginPage login=home.clickOnLoginMenu();
		  String actual_tittle=driver.getTitle();
		  
		  String data=ExcelUtility.readStringData(0, 0, Contants.LOGIN_PAGE_DATA);
		  Assert.assertEquals(actual_tittle, data,Messages.TITLE_MISMATCH);

  }
  
  
	 
	  @Test(priority=6,groups={"Smoke","Regression"})

	  public void verifyUserLogin() throws IOException
	  {
		  

		  String email=ExcelUtility.readStringData(0, 1, Contants.LOGIN_PAGE_DATA);
		  String password=ExcelUtility.readStringData(0, 2, Contants.LOGIN_PAGE_DATA);
		  
		
		  HomePage home=new HomePage(driver);
		  LoginPage login=home.clickOnLoginMenu();
	      LoginPage login_page=new LoginPage(driver);
	      login_page.enterUsername(email);
		  login_page.enterPassword(password);
	      UserAccount userpage=login_page.clickOnLoginButton();
	  	  UserAccount user = new UserAccount(driver);
		  String user_text=user.userGetText();
		  Assert.assertEquals(user_text,email ,Messages.USER_LOGIN_FAIL);
		 
  }
  @Test(priority=7,groups="Sanity",dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)  //dataprovider
  public void verifyUserLoginWithInvalidCredentials(String username,String password)throws IOException
  {
	  //String email=ExcelUtility.readStringData(1, 0, Contants.LOGIN_PAGE_DATA);
	  //String password=ExcelUtility.readStringData(1, 1, Contants.LOGIN_PAGE_DATA);
	  String expected=ExcelUtility.readStringData(1, 2, Contants.LOGIN_PAGE_DATA);
	  //WebElement login=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
	  //login.click();
	  
	 // WebElement email_ele=driver.findElement(By.cssSelector("#Email"));
	  //email_ele.sendKeys(username);
	 // WebElement password_ele=driver.findElement(By.cssSelector("#Password"));
	 // password_ele.sendKeys(password);
	 // WebElement loginlink=driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.form-fields > form > div.buttons > input"));
	  //loginlink.click();
	  //WebElement error_message=driver.findElement(By.xpath("//span[text()=\"Login was unsuccessful. Please correct the errors and try again.\"]"));
	 // String error_actual=error_message.getText();
	  HomePage home=new HomePage(driver);
	  LoginPage login=home.clickOnLoginMenu();
      LoginPage login_page=new LoginPage(driver);
      login_page.enterUsername(username);
	  login_page.enterPassword(password);
      UserAccount userpage=login_page.clickOnLoginButton();
  	  UserAccount user = new UserAccount(driver);
  	 String error_actual=login_page.userGetText();

  
	  Assert.assertEquals(error_actual, expected,Messages.LOGIN_FAILED_WARNING_MESSAGE_NOT_FOUND);

  }
}
