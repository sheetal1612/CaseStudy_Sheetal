package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class testBase {
	
	private static testBase base;
	private static WebDriver driver;
	
	private testBase() {
		String browserName="chrome";
		
		 if(browserName.equalsIgnoreCase("chrome"))
		  {
			 ChromeOptions cp=new ChromeOptions();
			 cp.addArguments("--incognito");
			  driver= new ChromeDriver(cp);
		  }
		  else if(browserName.equalsIgnoreCase("edge")){
			  driver= new EdgeDriver();
		  }
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.manage().deleteAllCookies();
	}
	
	public static void initDriver() {
		if(base==null)
		{
			base=new testBase();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void tearDown() {
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
		base=null;
	}

}
