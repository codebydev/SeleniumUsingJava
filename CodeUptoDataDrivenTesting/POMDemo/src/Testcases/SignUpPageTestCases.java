package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.SignUpPage;

public class SignUpPageTestCases {
	WebDriver driver;
	
	@BeforeTest
	public void before()
	{
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver=new FirefoxDriver();
		driver.get("http://facebook.com");
	}
	
	@AfterTest
	public void after()
	{
		driver.quit();
	}
	
	@Test
	public void VerifyValidSignUp()
	{
		
		SignUpPage signUpPage=new SignUpPage(driver);
		
		signUpPage.firstName.sendKeys("Ram");
		signUpPage.surname.sendKeys("Rao");
		signUpPage.email.sendKeys("a@a.com");
		signUpPage.password.sendKeys("abcd1234");
		
		Select dropdown=new Select(signUpPage.birthdayDay);
		dropdown.selectByIndex(2);
		
		
	}
}
