package tests;

import static pages.base.MyPages.getGMailLetterElements;
import static pages.base.MyPages.getGMailLoginPage;
import static pages.base.MyPages.getGMailLoginPageElements;
import static pages.base.MyPages.getGMailMainPage;
import static pages.base.MyPages.getGMailMainPageElements;
import static pages.base.MyPages.getGMailMainPageHelper;
import static pages.base.MyPages.getGMailThemesPage;
import static pages.base.MyPages.getGMailThemesPageElements;

import org.testng.annotations.*;

import base.BaseTestPage;

public class TestsForGMail extends BaseTestPage {
	int firstUser = 0;
	int secondUser = 1;

	@BeforeMethod(dependsOnMethods = "setupBeforeMethod")
	public void setUpConfiguration() {
		mainPage = getGMailMainPage();
		themesPage = getGMailThemesPage();
		mainPageHelper = getGMailMainPageHelper();
		loginPage = getGMailLoginPage();
		loginPageElements = getGMailLoginPageElements();
		mainPageElements = getGMailMainPageElements();
		themesPageElements = getGMailThemesPageElements();
		letterPageElements = getGMailLetterElements();
	}

	@Test(description = "Task #1")
	public void checkThatTheLetterSentToTheSpamFolder() {
		loginPage.logIn(secondUser).skipAll().createFillAndSendNewLetter(secondUser)
				.logOut().logIn(firstUser).markLetterAsASpam(secondUser)
				.logOut().logIn(secondUser).skipAll()
				.createFillAndSendNewLetter(secondUser).logOut()
				.logIn(firstUser).navigateToSpamFolder()
				.checkThatLetterInSpamFolder(secondUser);
	}

	@Test(description = "Task #2")
	public void checkThatTheLetterAddingToStarredFolderAfterMovingIt() {
		loginPage.logIn(firstUser).skipAll().createFillAndSendNewLetter(firstUser)
				.logOut().logIn(secondUser)
				.dragLetterToStarredFolder(firstUser)
				.checkThatLetterPresentInStarredFolder(firstUser);
	}

	@Test(description = "Task #3")
	public void checkThatTheLetterCanBeSendWithFile() {
		loginPage.logIn(firstUser).skipAll()
				.createFillAndNewLetterWithFile(firstUser).logOut()
				.logIn(secondUser).checkThatLetterContainFile(firstUser);
	}

	@Test(description = "Task #4")
	public void checkThatTheThemeSettingUp() {
		loginPage.logIn(secondUser).navigateToThemesPage().chooseRandomTheme();
	}
	@AfterMethod
    public void goBack() {
        mainPage.logOut();
    }
}
