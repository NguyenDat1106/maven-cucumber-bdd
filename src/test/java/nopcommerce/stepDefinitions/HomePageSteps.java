package nopcommerce.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import page.objects.nopCommerce.user.UserHomePageObject;

public class HomePageSteps {
	WebDriver driver;
	UserHomePageObject homePage;
	
	
	
	public HomePageSteps() {
		driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Then("^Home page displayed$")
	public void homePageDisplayed() {
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
}
