import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Basics {

	@Test
	public void launchBrowser()
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.navigate().to("https://www.theonlinecalculator.com/");
		driver.findElement(By.xpath("html/body/main/div/div/div/div/form/div[5]/input[3]")).click();
		String result= driver.findElement(By.xpath("//*[@itemprop='name']")).getText();
		System.out.println(result);
		driver.quit();
	}
	
	@Test
	public void handleAlert() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/test1.html");
		
		Thread.sleep(2000);
		driver.findElement(By.id("alert")).click();
		Thread.sleep(2000);
		String text=driver.switchTo().alert().getText();
		
		System.out.println(text);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		Assert.assertEquals(text, "Hello Alert window");
		driver.quit();
	}
	
	@Test
	public void handleConfirm() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/test1.html");
		
		Thread.sleep(2000);
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(2000);
		String text=driver.switchTo().alert().getText();
		
		System.out.println(text);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	@Test
	public void handlePrompt() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/test1.html");
		
		Thread.sleep(2000);
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(2000);
		String text=driver.switchTo().alert().getText();		
		System.out.println(text);
		driver.switchTo().alert().sendKeys("Harman");
		driver.switchTo().alert().accept();;
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	@Test
	public void switchFrame() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys("1234");
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void switchWindow() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Set<String> windows=driver.getWindowHandles();
		System.out.println("Before click : "+windows.size());
		driver.switchTo().frame(driver.findElement(By.tagName("frame")));
		driver.findElement(By.linkText("Click here")).click();
		Thread.sleep(6000);
		windows=driver.getWindowHandles();
		System.out.println("After click : "+windows.size());
		driver.switchTo().window();
		//driver.findElement(By.name("fldLoginUserId")).sendKeys("1234");
		Thread.sleep(6000);
		driver.quit();
	}
}
