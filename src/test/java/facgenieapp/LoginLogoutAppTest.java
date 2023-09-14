package facgenieapp;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utility.BaseClass;
import Generic_utility.Excel_utility;

public class LoginLogoutAppTest extends BaseClass {
	@Test(dataProvider = "getFromExcel")
	public void login(String Email,String Password) throws Throwable
	{
	
		
		
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.linkText("Log In")).click();

	}

	@DataProvider
	public  Object[][] getFromExcel() throws EncryptedDocumentException, IOException 
	{
		
		
		Excel_utility elib=new Excel_utility();
		Object[][] value = elib.readMultipleData("Sheet1");
		return value;
		
		
		
	}



}
