package facgenieapp;


import java.util.Random;
import org.openqa.selenium.ElementClickInterceptedException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_utility.Excel_utility;
import Generic_utility.File_utility;
import Generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogout {

	public static void main(String[] args) throws Throwable {
WebDriverManager.edgedriver().setup();
WebDriver driver=new EdgeDriver();
Random ran = new Random();
int data = ran.nextInt(1000);
 Excel_utility elib = new Excel_utility();
File_utility flib= new File_utility();

driver.get("https://facegenie-ams-school.web.app/");


WebElement email = driver.findElement(By.id("email"));
//String emdata = elib.getDataFormatter("Sheet1", 1, 0)+data;

  String emdata = flib.getUrlNBrowKey("email");
  email.sendKeys(emdata);
WebElement password = driver.findElement(By.id("password"));
//String padata = flib.getUrlNBrowKey("password");
String padata = elib.getDataFormatter("Sheet1", 1, 1)+data;
password.sendKeys(padata);


driver.findElement(By.xpath("//button[text()='Log In']")).click();

Thread.sleep(4000);
Webdriver_utility wlib = new Webdriver_utility();

wlib.waitForPageToLoad(driver);


Thread.sleep(2000);

//WebElement logout = driver.findElement(By.xpath("(//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-znl8sb'])[7]"));
//WebElement logout = driver.findElement(By.xpath("//span[text()='Log Out']"));
// wlib.waitForElementWithCustomTimeOut(driver, logout, 400);
// logout.click();





	}
	
	

}
