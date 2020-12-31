package step_definitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationPageTest extends TestBase{

	public RegistrationPageTest() throws IOException {
		super();
	}
	
	@Given("user is already in registration page")
	public void user_is_already_in_registration_page() {
		driver.findElement(By.linkText("REGISTER")).click();
	}

	// Data Driven in Cucumber = Scenario Outline, Examples, \"(.*)\" & arguments
	@When("^user provide \"(.*)\", \"(.*)\" and \"(.*)\"$")
	public void user_provide_username_password_and_confirmPassword(String username, String password,
			String confirmPassword) {
	    driver.findElement(By.name("email")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
	}

	@And ("user clicks submit")
	public void user_clicks_submit() {
		driver.findElement(By.name("submit")).click();
	}
	
	@Then("^user should be registered and should see confirmation of \"(.*)\"$")
	public void user_should_be_registered_and_should_see_confirmation_of_username(String username) {
	    Assert.assertEquals(driver.findElement(By.xpath("//b[contains(text(),"
	    		+ "'Note: Your user name is')]")).getText().trim(), 
	    		"Note: Your user name is "+username+".");
	}
	
	 @When("^registered user provides \"(.*)\", \"(.*)\" and \"(.*)\"$")
	    public void registered_user_provides_and(String username, String password, 
	    		String confirmpassword) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
	    }

	@Then("user should not be allowed to register and should see error message as registered already")
	public void user_should_not_be_allowed_to_register_and_should_see_error_message_as_registered_already() {
	    Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	}
}
