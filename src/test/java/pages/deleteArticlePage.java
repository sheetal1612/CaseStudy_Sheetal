package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class deleteArticlePage {
	
	@FindBy(xpath="//*[text()='Home']")
	WebElement lnkHome;
	
	@FindBy(xpath="//*[text()='Global Feed']")
	WebElement btnGlobalFeed;
	
	@FindBy(xpath="(//*[text()=' Delete Article'])[2]")
	WebElement btnDeleteArticle;
	
	@FindBy(xpath="//*[@class='preview-link']")
	List<WebElement> articleList;
	
	public static String updatedValue="";
	
	
	public deleteArticlePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

public void deleteArticle(String updatedValue1, WebDriver driver) throws InterruptedException {
	updatedValue=updatedValue1;
	WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+updatedValue+"')]"));
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", ele);
	driver.findElement(By.xpath("//h1[contains(text(),'"+updatedValue+"')]")).click();
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", btnDeleteArticle);
	btnDeleteArticle.click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
}

public void isArticleDeleted() {
	for(WebElement article:articleList) {
		if(article.getText().trim().contains(updatedValue)) {
			Assert.assertFalse(false);
		}
	}
}
}
