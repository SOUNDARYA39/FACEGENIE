package Generic_utility;


	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public WebDriver driver;
		
	@BeforeSuite()
	public void beforeSuite()
	{
		System.out.println("database open");
	}

	@BeforeTest()
	public void beforeTest()
	{
		System.out.println("parallel execution");
	}

	@BeforeClass()
	public void beforeClass() throws Throwable
	{
		File_utility flib = new File_utility();
		
		
		
		String browser = flib.getUrlNBrowKey("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
		}
	    Thread.sleep(4000);
		 Webdriver_utility wlib = new Webdriver_utility();
		wlib.waitForPageToLoad(driver);
		System.out.println("Launch the browser");
	}
	
	@BeforeMethod()
	public void beforeMethod() throws Throwable
	{
		
		File_utility fis = new File_utility();
		String URL = fis.getUrlNBrowKey("url");
		driver.get(URL);
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.maximizeWindow(driver);

	}

	@AfterMethod()
	public void afterMethod()
	{
		System.out.println("logout");
	}

	@AfterClass()
	public void afterClass()
	{
		driver.quit();
	}

	@AfterTest()
	public void aftertest()
	{
		System.out.println("parallel execution closed");
	}
	@AfterSuite()
	public void afterSuite()
	{
		System.out.println("database close");
	}
		
	}

