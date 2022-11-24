package facebook.stepDefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSteps {
	WebDriver driver;
	
	@Before("@parameter")
	public void openFacebookApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@When("^Input to Username application$")
	public void inputToUsernameApplication(){
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	}

	@When("^Input to Password application$")
	public void inputToPasswordApplication() {
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
	}

	@When("^Click to Submit button$")
	public void clickToSubmitButton(){
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	
	@When("^Input to Username textbox with \"([^\"]*)\"$")
	public void inputToUsernameTextboxWith(String email) {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	}

	@When("^Input to Password textbox with \"([^\"]*)\"$")
	public void inputToPasswordTextboxWith(String password) {
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	}
	
	@When("^Input to Username textbox with \"([^\"]*)\" and Password with \"([^\"]*)\"$")
	public void inputToUsernameTextboxWithAndPasswordWith(String email, String password) {
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	}
	
	@When("^Input to Username and Password$")
	public void inputToUsernameAndPassword(DataTable table) {
	   // List<Map<String, String>> cucumber = table.asMaps(String.class, String.class);
	    
	    
//		driver.findElement(By.xpath("//input[@id='email']")).clear();
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(cucumber.get(0).get("Username"));
//		
//		driver.findElement(By.xpath("//input[@id='pass']")).clear();
//		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(cucumber.get(0).get("Password"));
		

		for (Map<String, String> loginInfor : table.asMaps(String.class, String.class)) {
			driver.findElement(By.xpath("//input[@id='email']")).clear();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(loginInfor.get("Username"));
			
			driver.findElement(By.xpath("//input[@id='pass']")).clear();
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(loginInfor.get("Password"));

		}
	}

	
	@After("@parameter")
	public void closeApplication() {
		driver.quit();
	}
	

}
