package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class editArticlePage {
	
	@FindBy(xpath="//*[text()='Home']")
	WebElement lnkHome;
	
	@FindBy(xpath="//*[text()='Global Feed']")
	WebElement btnGlobalFeed;

	@FindBy(xpath="(//*[text()=' Edit Article'])[2]")
	WebElement btnEditArticle;
	
	@FindBy(xpath="//*[@placeholder='Article Title']")
	WebElement txtArticleTitle;
	
	@FindBy(xpath="//*[@placeholder='What's this article about?']")
	WebElement txtArticleAbout;
	
	@FindBy(xpath="//*[@placeholder='Write your article (in markdown)']")
	WebElement txtArticleDescription;
	
	@FindBy(xpath="//*[text()='Update Article']")
	WebElement btnUpdateArticle;
	
	@FindBy(xpath="(//*[text()=' Delete Article'])[2]")
	WebElement btnDeleteArticle;
	
	@FindBy(xpath="//*[@class='preview-link']")
	List<WebElement> articleList;
	
	@FindBy(xpath="//h1")
	WebElement updatedArticle;
	
	public static String value="";
	public static String updatedValue="";
	
	public editArticlePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
public void editArticle(String value1, String updatedValue1, WebDriver driver) throws InterruptedException {
	value=value1;
	updatedValue=updatedValue1;
	Thread.sleep(2000);
	WebElement ele=driver.findElement(By.xpath("//h1[contains(text(),'"+value+"')]"));
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", ele);
	driver.findElement(By.xpath("//h1[contains(text(),'"+value+"')]")).click();
	btnEditArticle.click();
	txtArticleTitle.clear();
	Thread.sleep(2000);
	txtArticleTitle.sendKeys(updatedValue);
	Thread.sleep(2000);
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", btnUpdateArticle);
	btnUpdateArticle.click();
	Thread.sleep(2000);
}


public void clickGlobalFeed(WebDriver driver) throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor js= (JavascriptExecutor) driver;
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", lnkHome);
	lnkHome.click();
	Thread.sleep(2000);
	js.executeScript("arguments[0].setAttribute('style','border:solid 2px red')", btnGlobalFeed);
	btnGlobalFeed.click();
}
public void clickOnEditButton() {
	btnEditArticle.click();
}

public void articleList() throws InterruptedException{
	Thread.sleep(2000);
	if(articleList.size()>0)
	{
		Assert.assertTrue(true);
		System.out.println("Article List is present");
	}
	else {
		Assert.assertTrue(false);
	}
}


public void isArticleUpdated() throws InterruptedException {
	String valueAfterUpdate=updatedArticle.getText().trim();
	Assert.assertEquals(updatedValue, valueAfterUpdate);
	Thread.sleep(2000);
	
}


}
