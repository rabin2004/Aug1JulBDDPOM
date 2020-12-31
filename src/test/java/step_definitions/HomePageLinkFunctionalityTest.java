package step_definitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageLinkFunctionalityTest extends TestBase{
	
	public HomePageLinkFunctionalityTest() throws IOException {
		super();
	}

	@Given("user is already in homePage")
	public void user_is_already_in_home_page() {
		System.out.println(driver.getTitle());
	}

	@When("user clicks register link")
	public void user_clicks_register_link() {
		driver.findElement(By.linkText("REGISTER")).click();
	}

	@Then("Register page should open")
	public void register_page_should_open() {
	    Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	}
	
	@When("user clicks flights link")
	public void user_clicks_flights_link() {
		driver.findElement(By.linkText("Flights")).click();
	}

	@Then("flight finder page should open")
	public void flight_finder_page_should_open() {
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours");
	}
}
