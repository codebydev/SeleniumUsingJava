package com.facebook.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginfb {

	@Test(dataProvider="authentication")	
	public void login(String email, String password)
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.quit();
	}
	
	@DataProvider(name="authentication")
	public static Object[][] credentials()
	{
		return new Object[][] {{"a@a.com","abcd1234"},{"b@b.com","abcd12*&"},{"b.b@b.com","@#$@12ab"}};
	}
}
