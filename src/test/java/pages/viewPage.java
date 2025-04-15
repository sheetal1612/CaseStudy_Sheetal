package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class viewPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[text()='Home']")
	WebElement lnkHome;
	
	@FindBy(xpath="//*[text()='Global Feed']")
	WebElement btnGlobalFeed;
	
	public viewPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

public static String value="";
public void clickGlobalFeed() throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", lnkHome);
	lnkHome.click();
	Thread.sleep(2000);
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", btnGlobalFeed);
	btnGlobalFeed.click();
}

public void selectArticle(String value1) throws InterruptedException {
	Thread.sleep(2000);
	value=value1;
	WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+value+"')]"));
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", ele);
	driver.findElement(By.xpath("//h1[contains(text(),'"+value+"')]")).click();
	
}


public void isArticleDetailsPagedisplayed() {
	if(!driver.getPageSource().contains(value)) {
		Assert.assertTrue(false);
	}
}


}
