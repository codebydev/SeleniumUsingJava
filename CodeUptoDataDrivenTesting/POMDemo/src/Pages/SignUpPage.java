package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="u_0_l")
	public WebElement firstName;
	
	@FindBy(how=How.ID,using="u_0_n")
	public WebElement surname;
	
	@FindBy(how=How.ID,using="u_0_q")
	public WebElement email;
	
	@FindBy(how=How.ID,using="u_0_x")
	public WebElement password;
	
	@FindBy(how=How.NAME,using="birthday_day")
	public WebElement birthdayDay;
}
