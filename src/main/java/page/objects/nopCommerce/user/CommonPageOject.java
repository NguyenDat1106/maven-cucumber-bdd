package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class CommonPageOject extends BasePage {
	 WebDriver driver;

	public CommonPageOject(WebDriver driver) {
		super(driver);
		this.driver = driver; 
	} 

	public void openMenuByHomePage(String textbox) {
		waitForElementClickable(driver, BasePageNopCommerceUI.DYNAMIC_MENU_BY_PAGE, textbox);
		clickToElement(driver, BasePageNopCommerceUI.DYNAMIC_MENU_BY_PAGE, textbox);

	}
}
