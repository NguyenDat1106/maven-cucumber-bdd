package nopcommerce.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Given;
import cucumberOptions.Hooks;
import page.objects.nopCommerce.user.CommonPageOject;

public class CommonPageSteps {
	WebDriver driver;
	CommonPageOject commonPage;
	
	public CommonPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		commonPage = PageGeneratorManager.getCommonPage(driver);
	}
	
	@Given("^Open \"([^\"]*)\" to Menu home pag$")
	public void openToMenuHomePag(String pageName)  {
		commonPage.openMenuByHomePage(pageName);
	}
	
}
