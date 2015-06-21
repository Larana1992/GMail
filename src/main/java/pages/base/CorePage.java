package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import core.Browser;

public abstract class CorePage {

	public WebDriver getDriver() {
		return Browser.getDriver();
	}

	public CorePage() {
		PageFactory.initElements(getDriver(), this);
	}
}
