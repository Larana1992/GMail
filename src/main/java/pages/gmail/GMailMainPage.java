package pages.gmail;

import org.openqa.selenium.By;
import static org.testng.Assert.*;
import pages.base.CorePage;
import pages.base.MainPage;
import static pages.base.MyPages.*;
import static pages.gmail.elements.GMailMainPageElements.*;
import static core.helpers.generalhelpers.WaiterHelpers.*;
import static core.helpers.generalhelpers.VerifyHelpers.*;
import static core.helpers.pages.GMailAddFileToNotWebWindow.action;

public class GMailMainPage extends CorePage implements MainPage {
	@Override
	public GMailMainPage createFillAndSendNewLetter(int userNumber) {
		getGMailMainPageHelper().createAndFillNewLetter(userNumber);
		waitForElementLocated(LETTER_SENT_MESSAGE_BUTTON, getDriver());
		return getGMailMainPage();
	}

	@Override
	public GMailMainPage skipAll() {
		delay(2000);
		action();
		return getGMailMainPage();
	}

	@Override
	public GMailMainPage createFillAndNewLetterWithFile(int userNumber) {
		getGMailMainPageHelper().createAndFillNewLetterAndAddFile(userNumber);
		waitForElementLocated(LETTER_SENT_MESSAGE_BUTTON, getDriver());
		return getGMailMainPage();
	}
	
	@Override
	public GMailLoginPage logOut() {
		waitForPageLoad(getDriver());
		action();
		getGMailMainPageHelper().logOut();
		return getGMailLoginPage();
	}

	@Override
	public GMailMainPage markLetterAsASpam(int userNumber) {
		getGMailMainPageHelper().findLetterWithCorrespondingTopic(userNumber);
		getGMailMainPageHelper().markLetterAsSpam();
		if (isElementPresent(By.xpath(SPAM_CONFIRM_BUTTON), getDriver())) {
			getBtnSpanConfirm().click();
			waitForElementNotVisible(By.xpath(SPAM_CONFIRM_BUTTON), getDriver());
		}
		return getGMailMainPage();
	}

	@Override
	public GMailMainPage dragLetterToStarredFolder(int userNumber) {
		waitForElementLocated(By.xpath(STARRED_LINK), getDriver());
		getGMailMainPageHelper().dragLetterWithCorrespondingTopicToStarred(
				userNumber);
		return getGMailMainPage();
	}

	@Override
	public GMailMainPage checkThatLetterPresentInStarredFolder(int userNumber) {
		waitForElementLocated(getGMailMainPageHelper()
				.findLetterInStarredFolder(userNumber), getDriver());
		assertTrue(
				isElementPresent(getGMailMainPageHelper()
						.findLetterInStarredFolder(userNumber), getDriver()),
				"Verify that letter present in starred folder");
		return getGMailMainPage();
	}

	@Override
	public GMailMainPage checkThatLetterContainFile(int userNumber) {
		waitForPageLoad(getDriver());
		getGMailMainPageHelper().findLetterWithCorrespondingTopic(userNumber);
		assertTrue(
				isElementPresent(
						getGMailMainPageHelper().findFileInLetter(userNumber),
						getDriver()), "Verify that letter contains file");
		return getGMailMainPage();
	}

	@Override
	public GMailThemesPage navigateToThemesPage() {
		getGMailMainPageHelper().goToThemes();
		return getGMailThemesPage();
	}

	@Override
	public GMailMainPage navigateToSpamFolder() {
		getLnkMore().click();
		waitForElementIsVisible(getLnkSpamFolder().getWrappedElement(),
				getDriver());
		getLnkSpamFolder().click();
		return getGMailMainPage();
	}

	@Override
	public GMailMainPage checkThatLetterInSpamFolder(int userNumber) {
		waitForPageLoad(getDriver());
		assertTrue(
				isElementPresent(getGMailMainPageHelper()
						.findLetterInSpamFolder(userNumber), getDriver()),
				"Verify that letter present in spam folder");
		return getGMailMainPage();
	}
}