package pages.gmail;

import org.openqa.selenium.By;
import core.Config;
import pages.base.CorePage;
import pages.base.LoginPage;
import pages.base.MyPages;
import static core.helpers.generalhelpers.VerifyHelpers.isElementPresent;
import static core.helpers.generalhelpers.WaiterHelpers.waitForElementIsClickable;
import static pages.gmail.elements.GMailLoginPageElements.*;
import static core.helpers.generalhelpers.WaiterHelpers.waitForElementLocated;

public class GMailLoginPage extends CorePage implements LoginPage {

	@Override
	public GMailMainPage logIn(int userNumber) {
		if (isElementPresent(By.xpath(ACCOUNT_CHOOSER_USER_BUTTON), getDriver())){
			getBtnChooseUser().click();}
		if (isElementPresent(By.xpath(ADD_ACCOUNT_BUTTON), getDriver())){
			getBtnAdd().click();}
		
		waitForElementIsClickable(getBtnNext().getWrappedElement(),
				getDriver());
		ifOneField(userNumber);
		return MyPages.getGMailMainPage();
	}

	private void ifOneField(int userNumber) {
		getTxtUserLogin().clear();
		getTxtUserLogin().sendKeys(Config.getLogin().get(userNumber));
		getBtnNext().click();
		waitForElementLocated(By.xpath(PASSWORD_TEXT_INPUT), getDriver());
		getTxtUserPassword().sendKeys(Config.getPassword());
		getBtnSignIn().click();
	}
}