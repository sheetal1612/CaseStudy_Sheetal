package stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.testBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.createArticle;
import pages.deleteArticlePage;
import pages.loginPage;
import pages.editArticlePage;

public class articleStepDef {
	loginPage pageLogin;
	WebDriver driver=testBase.getDriver();;
	editArticlePage editPage;
	deleteArticlePage deletePage;
	createArticle createPage;
	
	
	public articleStepDef() {
		pageLogin=new loginPage(driver);
		editPage=new editArticlePage(driver);
		createPage=new createArticle(driver);
		deletePage=new deleteArticlePage(driver);
		}
	
//	@BeforeTest
//	public void setUp() {
//		
//		
//	}
	
//	@Test(priority=2)
//	public void editArticle() throws InterruptedException {
//		editDeletePage.editandDeleteArticle("testingSH3","updatetitleValue",driver);
//	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		testBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		pageLogin.loginApp(string,string2);
	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		pageLogin.isOnHomePage();
	}
	
	@When("User click on New Article page")
	public void user_click_on_new_article_page() throws InterruptedException {
		createPage.clickOnNewarticle();
	}

	@When("User fill required values")
	public void user_fill_required_values(DataTable data) throws InterruptedException {
	    List<Map<String, String>> dataTables= data.asMaps();
	    for(Map<String, String> dataTable:dataTables) {
	    String title=dataTable.get("Title");
	    String body=dataTable.get("Body");
	    String desc=dataTable.get("Description");
	    createPage.enterValues(title, body,desc,driver);
	    }
	}

	@Then("User should be able to create article sucessfully")
	public void user_should_be_able_to_create_article_sucessfully() {
		createPage.isArticleCreated();
	}

	@Given("User click on Global Feed")
	public void user_click_on_global_feed() throws InterruptedException {
		editPage.clickGlobalFeed(driver);
	}

	@Then("User should be able to find article list")
	public void user_should_be_able_to_find_article_list() throws InterruptedException {
		editPage.articleList();
	}

	@Then("User click on Edit button for required article and update some field")
	public void user_click_on_edit_button_for_required_article_and_update_some_field(DataTable data) throws InterruptedException {
		List<Map<String, String>> dataTables= data.asMaps();
	    for(Map<String, String> dataTable:dataTables) {
	    String title=dataTable.get("Title");
	    String updatedTitle=dataTable.get("UpdateValue");
		editPage.editArticle(title, updatedTitle, driver);
	    }
	}

	@Then("User should be able to updated article")
	public void user_should_be_able_to_updated_article() throws InterruptedException {
	   editPage.isArticleUpdated();
	}

	@Then("User click on Delete article button")
	public void user_click_on_delete_article_button(DataTable data) throws InterruptedException {
		List<Map<String, String>> dataTables= data.asMaps();
	    for(Map<String, String> dataTable:dataTables) {
	    String updatedTitle=dataTable.get("UpdatedValue");
		deletePage.deleteArticle(updatedTitle, driver);
	    }
	}

	@Then("Article should be deleted successfuly")
	public void article_should_be_deleted_successfuly() {
		deletePage.isArticleDeleted();
	}

}
