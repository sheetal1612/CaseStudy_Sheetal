package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import base.testBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class hooks {
	 WebDriver driver;
	 
	@BeforeAll
	public static void setup() {
		testBase.initDriver();
	}
	
	@After
	public void screenshots(Scenario scenario) {
		if(scenario.isFailed()) {
		TakesScreenshot ss=(TakesScreenshot)testBase.getDriver();
		byte[] img=ss.getScreenshotAs(OutputType.BYTES);
		scenario.attach(img, "image/png", "FailedScenarioScreenshots");
		}
	}
		@AfterAll
		public static void teardown() {
			testBase.tearDown();
		
}
}
