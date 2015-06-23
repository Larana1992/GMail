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

public class TestsForGMail extends CorePage {
	protected GMailLoginPage loginPage;
	protected GMailMainPage mainPage;
	protected GMailThemesPage themesPage;
	protected GMailMainPageHelper mainPageHelper;
	protected GMailLoginPageElements loginPageElements;
	protected GMailMainPageElements mainPageElements;
	protected GMailThemesPageElements themesPageElements;
	protected GMailLetterElements letterPageElements;
	int firstUser = 0;
	int secondUser = 1;

	@BeforeClass
	protected void setupBeforeMethod() {
		getDriver().get(Config.getApplicationMainUrl());
		getDriver().manage().window().maximize();
	}

	@BeforeMethod
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
		loginPage.logIn(secondUser)
				.createFillAndSendNewLetter(secondUser).logOut()
				.logIn(firstUser).markLetterAsASpam(secondUser).skipAll().logOut()
				.logIn(secondUser)
				.createFillAndSendNewLetter(secondUser).logOut()
				.logIn(firstUser).navigateToSpamFolder()
				.checkThatLetterInSpamFolder(secondUser);
	}

	@Test(description = "Task #2")
	public void checkThatTheLetterAddingToStarredFolderAfterMovingIt() {
		loginPage.logIn(firstUser).skipAll()
				.createFillAndSendNewLetter(firstUser).logOut()
				.logIn(secondUser).dragLetterToStarredFolder(firstUser)
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
		loginPage.logIn(secondUser);
		mainPageHelper.selectFolderAndDeleteLetter();
		mainPage.logOut();
		loginPage.logIn(firstUser);
		mainPageHelper.selectFolderAndDeleteLetter();
		mainPage.logOut();
	}

	@AfterClass
	protected void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}
}
