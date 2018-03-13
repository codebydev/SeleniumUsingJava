package com.facebook.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginTest {

	@Parameters({"email","password"})
	@Test	
	public void login(String email,String password)
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://facebook.com");
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.quit();
	}
}
