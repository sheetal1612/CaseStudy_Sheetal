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
	WebDriver driver;
	
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
	
	@FindBy(xpath="//*[text()='Title already exists.. ']")
	WebElement articleAlreadyExist;
	
	

	public createArticle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void clickOnNewarticle() throws InterruptedException {
		Thread.sleep(2000);
		lnkNewArticle.click();
	}

	
	public void enterValues(String title, String about, String desc, String tag) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions aa=new Actions(driver);
		txtArticleTitle.sendKeys(title);
		txtArticleAbout.sendKeys(about);
		txtArticleDescription.clear();
		txtArticleDescription.sendKeys(desc);
		txtArticletags.sendKeys(tag);
		btnPublishArticle.click();
	}

public void isArticleCreated() {
	Assert.assertTrue(isArticleCreated.isDisplayed());
}

public void isArticleCreatedIfAlreadyExist() {
	Assert.assertEquals(articleAlreadyExist.getText(), "Title already exists..");
}

}
