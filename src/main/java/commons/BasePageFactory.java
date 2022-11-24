package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	
	
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	  
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	protected void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver) {
		Alert alert = waitForAlertPresence(driver);
		alert.accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
    protected void switchToWindowByID(WebDriver driver, String parentID) {
	Set<String> allWindowIDs = driver.getWindowHandles();
	for (String id : allWindowIDs) { 
		if (!id.equals(parentID)) {
			driver.switchTo().window(id);	
			break;
		}
	}	
}

    protected void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {
    	Set<String> allWindowIDs = driver.getWindowHandles();
    	for (String id : allWindowIDs) { 
    		driver.switchTo().window(id);
    		String currentPageTitle = driver.getTitle();
    		if (currentPageTitle.equals(expectedPageTitle)) {
    			break;
			}
    	}
    }
    
    protected void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
    	Set<String> allWindowIDs = driver.getWindowHandles();
    	for (String id : allWindowIDs) { 
    		if (!id.equals(parentID)) {
    			driver.switchTo().window(id);
    			driver.close();
			}	
    		driver.switchTo().window(parentID);
    	}
    	
    }
    
    private By getByXpath(String xpathLocator) {
    	return By.xpath(xpathLocator);
    }
    
    private WebElement getWebElement(WebDriver driver, String xpathLocator) {
    	return driver.findElement(getByXpath(xpathLocator));
    }
    
    private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
    	return driver.findElements(getByXpath(xpathLocator));
    }

    
   
    
    protected void selectItemDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
    	Select select = new Select(getWebElement(driver, xpathLocator));
    	select.selectByValue(textItem);
    }
    
    protected void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
    protected String getFirstSelectItemDefaultDropdown(WebDriver driver, String xpathLocator) {
    	Select select = new Select(getWebElement(driver, xpathLocator));
    	return select.getFirstSelectedOption().getText();
    }
    
    protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
    	Select select = new Select(getWebElement(driver, xpathLocator));
    	return select.isMultiple();
    }
    
    protected void selectItemCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String textExpectedItem) {
		
    	getWebElement(driver, parentLocator).click();	
		WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
		List<WebElement> allItems = getListWebElement(driver, childLocator);
		for (WebElement item : allItems) {
		String textActualItem = item.getText();
		if (textActualItem.equals(textExpectedItem)) { 
		item.click();
		break;
			 }								
		   }
		}
    
    protected String geElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
    	return getWebElement(driver, xpathLocator).getAttribute(attributeName);
    }
    
    protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
    	return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }
    
    protected String getHexaColorFromRGBA(String rgbaValue) {
    	return Color.fromString(rgbaValue).asHex();
    }
    
    protected int getElementSize(WebDriver driver, String xpathLocator) {
    	return getListWebElement(driver, xpathLocator).size();
    }
    
    protected void checkToCheckboxRadio(WebDriver driver, String xpathLocator) {
    	WebElement element = getWebElement(driver, xpathLocator);
    	if (!element.isSelected()) {
    		element.click();
		}
    }
    	
    protected void uncheckToCheckboxRadio(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
    	if (element.isSelected()) {
    	   element.click();
    	}
    }
    
  
    
    protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
    	return getWebElement(driver, xpathLocator).isEnabled();
    }
    
    protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
    	return getWebElement(driver, xpathLocator).isSelected();
    }
    
    protected void switchToFrameIframe(WebDriver driver, String xpathLocator) {
    	driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }
    
    protected void swichToDefaultContent(WebDriver driver) {
    	driver.switchTo().defaultContent();
    }
    
    protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
    	Actions action = new Actions(driver);
    	action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

	protected void scrollToButtomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	protected void waitForElementInVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForAllElementInVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	  protected void clickToElement(WebDriver driver, WebElement element) {
		  element.click();
	    }
	  
	  protected void sendkeyToElement(WebDriver driver, WebElement element, String textValue) {
	    	element.clear();
	    	element.sendKeys(textValue);
	    }
	  
	  protected String getElementText(WebDriver driver, WebElement element) {
	    	return element.getText();
	    }
	  
	  protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
	    	return element.isDisplayed();
	    }
	
	private long longTimeout = 30;
}
