package core.helpers.pages;

import static core.helpers.generalhelpers.WaiterHelpers.*;
import static org.openqa.selenium.By.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static core.Config.*;
import static pages.gmail.elements.GMailMainPageElements.*;
import pages.base.CorePage;
import pages.base.MyPages;
import pages.gmail.elements.GMailMainPageElements;

public class GMailMainPageHelper extends CorePage {
	final private String spanBText = "//span/b[text()='";
	private static GMailLetterHelper letterComponent = MyPages.getGMailLetterHelper();

	public void createAndFillNewLetter(int userNumber) {
		waitForPageLoad(getDriver());
		getBtnNewLetter().click();
		letterComponent.fillInField(userNumber);
		letterComponent.sendLetter();
	}

	public void createAndFillNewLetterAndAddFile(int userNumber) {
		waitForPageLoad(getDriver());
		getBtnNewLetter().click();
		letterComponent.fillFieldsAndFile(userNumber);
		waitForElementNotVisible(GMailMainPageElements.PROGRESS_BAR,
				getDriver());
		letterComponent.sendLetter();
	}

	public void goToThemes() {
		getBtnThemes().click();
	}

	public void logOut() {
		getBtnPopupMenu().click();
		getBtnExit().click();
	}

	public void findLetterWithCorrespondingTopic(int userNumber) {
		waitForElementLocated(xpath(spanBText + getSubject().get(userNumber)
				+ "']"), getDriver());
		getDriver().findElement(
				xpath(spanBText + getSubject().get(userNumber) + "']")).click();
	}

	public By findLetterInSpamFolder(int userNumber) {
		return xpath("//span[text()='" + getSubject().get(userNumber) + "']");
	}

	public void dragLetterWithCorrespondingTopicToStarred(int userNumber) {
		WebElement element = getDriver().findElement(
				xpath(spanBText + getSubject().get(userNumber) + "']"));
		(new Actions(getDriver())).dragAndDrop(element,
				getLnkStarred().getWrappedElement()).perform();
	}

	public By findLetterInStarredFolder(int userNumber) {
		getLnkStarred().click();
		return xpath(spanBText + getSubject().get(userNumber) + "']");
	}

	public By findFileInLetter(int userNumber) {
		return xpath("//span[contains(text(), '" + getFilePath() + "')]");
	}

	public void markLetterAsSpam() {
		waitForElementLocated(xpath(TO_SPAM_BUTTON), getDriver());
		getBtnToSpam().click();
	}
}