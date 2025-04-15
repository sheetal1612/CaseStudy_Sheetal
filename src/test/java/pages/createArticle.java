package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class createArticle {
	
	
	@FindBy(xpath="//*[text()='New Article']")
	WebElement lnkNewArticle;
	
	@FindBy(xpath="//*[@placeholder='Article Title']")
	WebElement txtArticleTitle;
	
	@FindBy(xpath="(//*[@class='form-control '])[1]")
	WebElement txtArticleAbout;
	
	@FindBy(xpath="//*[@name='body']")
	WebElement txtArticleDescription;
	
	@FindBy(xpath="//*[@name='tags']")
	WebElement txtArticletags;
	
	@FindBy(xpath="//*[text()='Publish Article']")
	WebElement btnPublishArticle;
	
	@FindBy(xpath="//*[@class='article-actions']")
	WebElement isArticleCreated;
	

	public createArticle(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public void clickOnNewarticle() throws InterruptedException {
		Thread.sleep(2000);
		lnkNewArticle.click();
	}

	
	public void enterValues(String title, String about, String desc, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions aa=new Actions(driver);
		//txtArticleTitle.clear();
		txtArticleTitle.sendKeys(title);
		Thread.sleep(2000);
		//aa.moveToElement(txtArticleAbout).build().perform();
//		txtArticleAbout.clear();
//		js.executeScript("arguments[0].value='"+ about +"';",txtArticleAbout);
		txtArticleAbout.sendKeys(about);
		Thread.sleep(2000);
		txtArticleDescription.clear();
		//aa.moveToElement(txtArticleDescription).build().perform();
		//js.executeScript("arguments[0].value='"+ desc +"';",txtArticleDescription);
		txtArticleDescription.sendKeys(desc);
		Thread.sleep(2000);
		txtArticletags.sendKeys("check");
		btnPublishArticle.click();
		Thread.sleep(2000);
	}

public void isArticleCreated() {
	Assert.assertTrue(isArticleCreated.isDisplayed());
}

}
