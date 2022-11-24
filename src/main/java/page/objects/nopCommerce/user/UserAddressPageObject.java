package page.objects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;

public class UserAddressPageObject extends BasePage {
	 WebDriver driver;
	 WebDriverWait expliciyWait;
	 boolean isPageReady;

	public UserAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
}

	public UserAddressPageObject(WebDriver driver, boolean isPageReady) {
		super(driver);
		this.driver = driver;
		this.isPageReady = isPageReady;
}
	
	public UserAddressPageObject(WebDriver driver, WebDriverWait expliciyWait) {
		super(driver);
		this.driver = driver;
		this.expliciyWait = expliciyWait;
}
	
}
