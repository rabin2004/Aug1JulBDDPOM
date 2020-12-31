package step_definitions;

import java.io.IOException;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.HomePage;
import pageFactory.LoginSuccessPage;

public class LoginFunctionalityTest extends TestBase{
	HomePage hm;
	LoginSuccessPage lsp;
	
	public LoginFunctionalityTest() throws IOException {
		super();
		hm = new HomePage();
		lsp = new LoginSuccessPage();
	}
	
	@Given ("^user is in homePage$")
	public void user_is_in_homePage() {
		System.out.println(hm.getHomePageTitle());
	}
	
	@When ("^user provides valid username and valid password$")
	public void user_provides_valid_username_and_valid_password() {
		hm.typeUsername(prop.getProperty("validUsername"));
		hm.typePassword(prop.getProperty("validPassword"));
	}
	
	@And ("^user clicks submit button$")
	public void user_clicks_submit_button() {
		hm.clickSubmitBtn();
	}
	
	@Then ("^login should happen and login success message should be displayed$")
	public void login_should_happen_and_login_success_message_should_be_displayed() {
		Assert.assertEquals(lsp.getLoginSuccessMsg(), "Login Successfully");
	}
	
	@When("user provides invalid username and invalid password")
	public void user_provides_invalid_username_and_invalid_password() {
		hm.typeUsername(prop.getProperty("invalidUsername"));
		hm.typePassword(prop.getProperty("invalidPassword"));
	}

	@Then("login should not happen  and error message should be displayed")
	public void login_should_not_happen_and_error_message_should_be_displayed() {
		Assert.assertEquals(hm.getEnterValidCredentialsErrorMsg(), "Enter your userName and password correct");
	}
}
