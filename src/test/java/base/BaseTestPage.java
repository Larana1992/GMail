package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.base.CorePage;
import pages.gmail.GMailLoginPage;
import pages.gmail.GMailMainPage;
import pages.gmail.GMailThemesPage;
import pages.gmail.elements.GMailLetterElements;
import pages.gmail.elements.GMailLoginPageElements;
import pages.gmail.elements.GMailMainPageElements;
import pages.gmail.elements.GMailThemesPageElements;
import core.Config;
import core.helpers.pages.GMailMainPageHelper;

public class BaseTestPage extends CorePage {

	protected GMailLoginPage loginPage;
	protected GMailMainPage mainPage;
	protected GMailThemesPage themesPage;
	protected GMailMainPageHelper mainPageHelper;
	protected GMailLoginPageElements loginPageElements;
	protected GMailMainPageElements mainPageElements;
	protected GMailThemesPageElements themesPageElements;
	protected GMailLetterElements letterPageElements;

	@BeforeMethod
	protected void setupBeforeMethod() {
		getDriver().get(Config.getApplicationMainUrl());
		getDriver().manage().window().maximize();
	}

	@AfterSuite
	protected void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
}
