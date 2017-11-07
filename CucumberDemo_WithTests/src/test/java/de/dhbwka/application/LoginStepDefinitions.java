package de.dhbwka.application;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {

	private static WebDriver driver = null;

	@Before("@web")
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@After("@web")
	public void cleanup() {
		driver.close();
	}

	@Given("^User is on Login page$")
	public void user_is_on_Login_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/CucumberDemo/Login.jsp");
	}

	@When("^User provides username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_provides_username_and_password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("usernameID")).sendKeys(arg1);
		driver.findElement(By.id("passwordID")).sendKeys(arg2);
		driver.findElement(By.id("loginID")).click();
	}

	@Then("^User should be successfully logged in as Admin$")
	public void user_should_be_successfully_logged_in_as_Admin() throws Throwable {
		String url = driver.getCurrentUrl();
		if (url.equals("http://localhost:8080/CucumberDemo/TempCalculator.jsp")) {
			assertEquals("Login failure",driver.findElement(By.id("userLevel")).getText(),"Administrator");
		} else {
			fail("Not logged in");
		}
	}
	@Then("^User should be successfully logged in as User$")
	public void user_should_be_successfully_logged_in_as_User() throws Throwable {
		String url = driver.getCurrentUrl();
		if (url.equals("http://localhost:8080/CucumberDemo/TempCalculator.jsp")) {
			assertEquals("Login failure",driver.findElement(By.id("userLevel")).getText(),"User");
		} else {
			fail("Not logged in");
		}
	}
	
	@When("^User provides username tester and User provides password test$")
	public void user_provides_username_tester_and_User_provides_password_test() throws Throwable {
		driver.findElement(By.id("usernameID")).sendKeys("tester");
		driver.findElement(By.id("passwordID")).sendKeys("test");
		driver.findElement(By.id("loginID")).click();
	}

	@Then("^User should not be logged in$")
	public void user_should_not_be_logged_in() throws Throwable {
		String url = driver.getCurrentUrl();
		assertEquals("User should have been logged in", url,"http://localhost:8080/CucumberDemo/Login.jsp"); 
	}

	@Then("^User should be shown an error message$")
	public void user_should_be_shown_an_error_message() throws Throwable {
		String statusMessageText = driver.findElement(By.id("loginStatusID")).getText();
		assertEquals("Login status message failure",statusMessageText,"Login Failed!");
	}

	@When("^User provides username Admin and User provides password wrong$")
	public void user_provides_username_Admin_and_User_provides_password_wrong() throws Throwable {
		driver.findElement(By.id("usernameID")).sendKeys("Admin");
		driver.findElement(By.id("passwordID")).sendKeys("wrong");
		driver.findElement(By.id("loginID")).click();
	}

}
