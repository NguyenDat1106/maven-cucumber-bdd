package nopcommerce.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import page.objects.nopCommerce.user.UserLoginPageObject;

public class LoginPageSteps {
WebDriver driver;
UserLoginPageObject loginPage;

	
	public LoginPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
	}
	@Given("^Click to Logout link$")
	public void clickToLogoutLink() {
		loginPage.openLoginLink();
	}

	@When("^Intput to Email and Password testbox$")
	public void intputToEmailAndPasswordTestbox() {
		loginPage.inputToEmailTextbox(RegisterPageSteps.email);
		loginPage.inputToPasswordTextbox(RegisterPageSteps.password);
	}

	@Then("^Click to Login button$")
	public void clickToLoginButton() {
		loginPage.clickToLoginButton();
	}
	
}
