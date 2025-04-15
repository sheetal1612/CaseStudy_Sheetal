package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features=".//src//test/resources//Features//createArticle.feature",
		glue={"stepDefinition"},
		monochrome=true,
		dryRun=false,
		plugin= {"pretty",
				"html:target/Reports/HtmlReport.html",
				}
		)

public class runner extends AbstractTestNGCucumberTests {
		
	}


