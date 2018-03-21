import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridDemo {

	@Test
	public void Demo() throws MalformedURLException
	{
		// WebDriver driver=new FirefoxDriver()
		
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.ANY);
		
		WebDriver driver=new RemoteWebDriver(new URL("http://10.98.232.220:4444/wd/hub"),capabilities);
		
		driver.get("http://google.com");
		
		driver.quit();
	}
	
}
