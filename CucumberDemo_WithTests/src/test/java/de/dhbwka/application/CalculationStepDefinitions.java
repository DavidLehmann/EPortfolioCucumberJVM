package de.dhbwka.application;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculationStepDefinitions {
	
	private static WebDriver driver = null;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void cleanup() {
		driver.close();
	}
	
	@Given("^User is logged in as Administrator$")
	public void user_is_logged_in_as_Administrator() throws Throwable {
		
		driver.get("http://localhost:8080/CucumberDemo/Login.jsp");
		driver.findElement(By.id("usernameID")).sendKeys("Admin");
		driver.findElement(By.id("passwordID")).sendKeys("admin");
		driver.findElement(By.id("loginID")).click();
	}

	@When("^User provides celcius value (\\d+)$")
	public void user_provides_celcius_value(int arg1) throws Throwable {
		driver.findElement(By.id("celciusInputID")).sendKeys(String.valueOf(arg1));
		driver.findElement(By.id("calculateID")).click();
	}

	@Then("^the shown Fahrenheit value should be (\\d+)$")
	public void the_shown_Fahrenheit_value_should_be(double arg1) throws Throwable {
		String test = driver.findElement(By.id("fahrenheitOutputID")).getAttribute("value");
	    assertEquals("Calculated Fahrenheit value wrong", test ,String.valueOf(arg1));
	}

	@Given("^User is logged in as User$")
	public void user_is_logged_in_as_User() throws Throwable {
		driver.get("http://localhost:8080/CucumberDemo/Login.jsp");
		driver.findElement(By.id("usernameID")).sendKeys("Admin");
		driver.findElement(By.id("passwordID")).sendKeys("admin");
		driver.findElement(By.id("loginID")).click();
	}

	@Given("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		driver.get("http://localhost:8080/CucumberDemo/Login.jsp");
		driver.findElement(By.id("usernameID")).sendKeys("Admin");
		driver.findElement(By.id("passwordID")).sendKeys("admin");
		driver.findElement(By.id("loginID")).click();
	}

	@When("^User selects Logout$")
	public void user_selects_Logout() throws Throwable {
		driver.findElement(By.id("logoutID")).click();
	}

	@Then("^User should be redirected to login page$")
	public void user_should_be_redirected_to_login_page() throws Throwable {
		assertEquals("Should have logged out", driver.getCurrentUrl(), "http://localhost:8080/CucumberDemo/Login.jsp");
	}
	
}
