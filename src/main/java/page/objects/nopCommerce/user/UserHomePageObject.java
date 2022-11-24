package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
private WebDriver driver;

public UserHomePageObject(WebDriver driver) {
	super(driver);
	this.driver = driver; 
}	

	
	public UserRegisterPageObject openRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);

	}
	
	
	public UserLoginPageObject openLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);

	}
	
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}
	
	public UserCustomerInforPageObject openMyAccountPage() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
		
	}
	
	public void openMenuByHomePage(String textbox) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_MENU_BY_PAGE);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_MENU_BY_PAGE, textbox);
	}

}
