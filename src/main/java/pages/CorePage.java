package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import core.driver.Browser;

public abstract class CorePage {

	public WebDriver getDriver() {
		return Browser.getDriver();
	}

	public CorePage() {
		PageFactory.initElements(getDriver(), this);
	}
}
