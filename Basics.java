import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		
		// Step 1: before click windows size
		System.out.println(driver.getTitle());
		Set<String> windows=driver.getWindowHandles();
		System.out.println("Before click : "+windows.size());
		
		driver.switchTo().frame(driver.findElement(By.tagName("frame")));
		driver.findElement(By.linkText("Click here")).click();
		Thread.sleep(6000);
		
		// Step 2: after click windows size
		windows=driver.getWindowHandles();
		System.out.println("After click : "+windows.size());
		for(String handle: windows)
		{
			System.out.println(handle);
			driver.switchTo().window(handle);
		}	
		
		// Step 3: Find the element in the new page and perform the operation
		driver.findElement(By.name("fldLoginUserId")).sendKeys("1234");
		System.out.println(driver.getTitle());
		Thread.sleep(6000);
		driver.close();
		System.out.println("After close : "+driver.getWindowHandles().size());
		driver.quit();
	}
	
	@Test
	public void doubleClick() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/DoubleClick.html");
		
		Actions actions=new Actions(driver);
		Thread.sleep(6000);
		actions
		.doubleClick(driver.findElement(By.name("dblClick")))
		.build()
		.perform();
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void contextClick() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/DoubleClick.html");
		
		Actions actions=new Actions(driver);
		Thread.sleep(6000);
		actions
		.contextClick(driver.findElement(By.name("dblClick")))
		.build()
		.perform();
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void dragAndDrop() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/DragAndDrop.html");
		
		Actions actions=new Actions(driver);
		Thread.sleep(6000);
		actions
		.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable")))
		.build()
		.perform();
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void keyDownAndKeyUp() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/Selectable.html");
		
		Actions actions=new Actions(driver);
		Thread.sleep(6000);
		actions
		.keyDown(Keys.CONTROL)
		.click(driver.findElement(By.name("one")))
		.click(driver.findElement(By.name("six")))
		.click(driver.findElement(By.name("eleven")))
		.keyUp(Keys.CONTROL)
		.build()
		.perform();
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void clickAndHoldAndRelease() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hanumanthargs/Downloads/HTML/Selectable.html");
		
		Actions actions=new Actions(driver);
		Thread.sleep(6000);
		actions		
		.clickAndHold(driver.findElement(By.name("one")))
		.moveToElement(driver.findElement(By.name("eleven")))
		.release()		
		.build()
		.perform();
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void clickOnRadioButton() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(6000);
		driver.findElement(By.id("u_0_b")).click();
		Boolean selected = driver.findElement(By.id("u_0_b")).isSelected();
		System.out.println("Female radio button selected : "+selected);
		
		selected = driver.findElement(By.id("u_0_c")).isSelected();
		System.out.println("Male radio button selected : "+selected);
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void clickOnCheckbox() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://uitestpractice.com/Students/Form");
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@value='dance']")).click();
		Boolean selected = driver.findElement(By.xpath("//*[@value='dance']")).isSelected();
		System.out.println("Dancing check box selected : "+selected);
		
		selected = driver.findElement(By.xpath("//*[@value='read']")).isSelected();
		System.out.println("Reading check box selected : "+selected);
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void SelectDropDownValue() throws InterruptedException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(6000);
		
		Select dropdown=new Select(driver.findElement(By.id("day")));		
		dropdown.selectByValue("14");
		
		dropdown=new Select(driver.findElement(By.id("month")));
		dropdown.selectByVisibleText("Sept");
		
		Thread.sleep(6000);
		
		driver.quit();
	}
	
	@Test
	public void takeScreenshot() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Test.png"));
				
		driver.quit();
	}
}
