package nopcommerce.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import page.objects.nopCommerce.user.UserRegisterPageObject;
import utilities.DataHelper;

public class RegisterPageSteps {

WebDriver driver;
UserRegisterPageObject registerPage;
DataHelper dataHelper;
static String username, lastname, email, password;
TestContext testContext;

	public RegisterPageSteps(TestContext testContext) {
		driver = Hooks.openAndQuitBrowser();
		this.testContext = testContext;
		registerPage = PageGeneratorManager.getUserRegisterPage(driver);
		dataHelper = DataHelper.getDataHelper();
		
		username = dataHelper.getFirstName();
		lastname = dataHelper.getLastName();
		email = dataHelper.getEmailAddress();
		password = dataHelper.getPassword();
	
	}
	
	@Given("^Click Register link$")
	public void clickRegisterLink() {
		registerPage.openRegisterLink();
	}

	@When("^Submit value infor to register form$")
	public void submitValueInforToRegisterForm() {
		registerPage.inputToFirstNameTextbox(username);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
	}

	@When("^Click to Register button$")
	public void clickToRegisterButton() {
		registerPage.clickToRegisterButton();
	}
	
	@Then("^Click to Logout$")
	public void clickToLogout() {
		registerPage.clickToLogout();
	}


}
