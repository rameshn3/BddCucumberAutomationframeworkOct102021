package step_def;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginStepDefinition {
private WebDriver driver=null;
private WebDriverWait wait=null;
LoginPage lp=null;

@Given("I want to open chrome browser")
public void I_want_to_open_chrome_browser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wait=new WebDriverWait(driver,30);
	lp=new LoginPage(driver);
}

@Given("User opens URL {string}")
public void User_opens_URL(String url) {
	driver.get(url);
}


@When("User enters Email as {string} and password as {string}")
public void User_enters_Email_as_and_password_as(String uname,String pwd) {
	lp.setEmail(uname);
	lp.setPassword(pwd);
}

@When("Click on login button")
public void Click_on_login_button() {
	lp.clickOnLoginBtn();;
}

 @Then("Page title should be {string}")
 public void Page_title_should_be(String title) {

	 if(driver.getPageSource().contains("Login was unsuccessful")) {
		 wait.until(ExpectedConditions.titleContains("Your store. Login"));
		 //Assert.assertTrue(false);
	 }else {
		 Assert.assertEquals(title, driver.getTitle());
	 }
 }

 @When("User clicks on logout link")
 public void User_clicks_on_Logout_link() {
	 lp.clickOnLogoutLink();
 }
 
 @Then("Close the browser")
 public void close_the_browser() {
	 
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}finally {
		driver.quit();
	}
 }



}
