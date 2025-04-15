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
import pages.viewPage;
import pages.editArticlePage;

public class articleStepDef {
	loginPage pageLogin;
	WebDriver driver=testBase.getDriver();;
	editArticlePage editPage;
	deleteArticlePage deletePage;
	createArticle createPage;
	viewPage viewArt;
	
	
	public articleStepDef() {
		pageLogin=new loginPage(driver);
		editPage=new editArticlePage(driver);
		createPage=new createArticle(driver);
		deletePage=new deleteArticlePage(driver);
		viewArt=new viewPage(driver);
		}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		testBase.openUrl("https://conduit-realworld-example-app.fly.dev/");
	}

	@When("User provide {string} and {string}")
	public void user_enters_and(String string, String string2) {
		pageLogin.loginApp(string,string2);
	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		pageLogin.isOnHomePage();
	}
	
	@Given("User should be on New Article page")
	public void user_click_on_new_article_page() throws InterruptedException {
		createPage.clickOnNewarticle();
	}

	@When("User enters Article details")
	public void user_fill_required_values(DataTable data) throws InterruptedException {
	    List<Map<String, String>> dataTables= data.asMaps();
	    for(Map<String, String> dataTable:dataTables) {
	    String title=dataTable.get("Title");
	    String body=dataTable.get("Desc");
	    String desc=dataTable.get("Content");
	    String tag=dataTable.get("Tag");
	    createPage.enterValues(title, body,desc,tag);
	    }
	}

	@Then("Article must be created")
	public void user_should_be_able_to_create_article_sucessfully() {
		createPage.isArticleCreated();
	}
	
	@Then("Article must not be created if already exist")
	public void user_should_not_be_able_to_create_article_sucessfully() {
		createPage.isArticleCreatedIfAlreadyExist();
	}

	@Given("User should be on Global Feed page")
	public void user_on_global_feed() throws InterruptedException {
		viewArt.clickGlobalFeed();
	}
	
	@When("User select an article {string}")
	public void selectArticle(String string) throws InterruptedException {
		viewArt.selectArticle(string);
	}
	
	@Then("Article details page must be displayed")
	public void articleDetails() throws InterruptedException {
		viewArt.isArticleDetailsPagedisplayed();
	}

	@Then("User update article detail")
	public void user_click_on_edit_button_for_required_article_and_update_some_field(DataTable data) throws InterruptedException {
		List<Map<String, String>> dataTables= data.asMaps();
	    for(Map<String, String> dataTable:dataTables) {
	    String title=dataTable.get("OldTitle");
	    String updatedTitle=dataTable.get("UpdateValue");
		editPage.editArticle(title, updatedTitle);
	    }
	}

	@Then("Article must be updated")
	public void user_should_be_able_to_updated_article() throws InterruptedException {
	   editPage.isArticleUpdated();
	}

	@Then("User delete article")
	public void user_click_on_delete_article_button(DataTable data) throws InterruptedException {
		List<Map<String, String>> dataTables= data.asMaps();
	    for(Map<String, String> dataTable:dataTables) {
	    String updatedTitle=dataTable.get("ArticleToBeDeleted");
		deletePage.deleteArticle(updatedTitle);
	    }
	}

	@Then("Article must be deleted")
	public void article_should_be_deleted_successfuly() {
		deletePage.isArticleDeleted();
	}

}
