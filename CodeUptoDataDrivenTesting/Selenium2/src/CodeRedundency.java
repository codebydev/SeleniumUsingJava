import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CodeRedundency {

	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Within before class method");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("Within after class method");
	}
	
	@Before
	public void before()
	{
		System.out.println("In before method");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver=new FirefoxDriver();
		driver.get("http://facebook.com");
	}
	
	@After
	public void after()
	{
		System.out.println("In after method");
		driver.quit();
	}
	
	@Test
	public void Demo1()
	{
		System.out.println("In test1 method");
	}
	
	@Test
	public void Demo2()
	{
		System.out.println("In test2 method");
	}
}
