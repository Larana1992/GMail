package pages.gmail;

import java.util.Random;

import pages.base.CorePage;
import pages.base.MyPages;
import pages.base.ThemesPage;
import static pages.gmail.elements.GMailThemesPageElements.*;
import static core.helpers.generalhelpers.VerifyHelpers.isElementPresent;
import static core.helpers.generalhelpers.WaiterHelpers.*;
import static org.testng.Assert.assertTrue;

public class GMailThemesPage extends CorePage implements ThemesPage {
	@Override
	public GMailThemesPage chooseRandomTheme() {
		Random randomTheme = new Random();
		waitForPageLoad(getDriver());
		waitForElementLocated(NAVIGATE_MENU, getDriver());
		getListThemes().get(randomTheme.nextInt(getListThemes().size() - 1))
				.click();
		assertTrue(isElementPresent(THEME_CHENGED_MESSAGE, getDriver()),
				"Verify that new theme has been chose");
		delay(2000);
		return MyPages.getGMailThemesPage();
	}
}
