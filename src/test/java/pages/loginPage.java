package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginPage {
	
	@FindBy(className="ion-log-in")
	WebElement btnLogin;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="(//a[text()='conduit'])[1]")
	WebElement homePage;
	
	
	
	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

 public void loginApp(String user, String password1)
 {
	 btnLogin.click();
	 username.sendKeys(user);
	 password.sendKeys(password1);
	 loginButton.click();
 }

public void isOnHomePage() {
	if(homePage.isDisplayed())
	{
		Assert.assertTrue(true);
	}
	else {
		Assert.assertTrue(false);
	}	
}
}
