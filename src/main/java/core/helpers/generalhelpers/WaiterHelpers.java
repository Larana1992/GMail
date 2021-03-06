package core.helpers.generalhelpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class WaiterHelpers {

	public static void waitForElementIsClickable(WebElement webElement,
			WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(2, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public static void waitForElementIsVisible(WebElement webElement,
			WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(2, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void waitForElementNotVisible(By locator, WebDriver driver) {
		delay(1000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(2, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void waitForElementLocated(By locator, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(2, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public static void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public static void delay(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			Reporter.log("Interrupted Exception!");
		}
	}
}
