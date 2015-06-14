package pages;

import core.helpers.generalhelpers.WaitHelper;
import core.helpers.pagehelpers.MyPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class PnMicrowavesPage extends CorePage {

	public final String ADD_TO_COMPARATIVE = "(//div[@class='compare-links']//span[1])[position() < 3]";
	public final String TO_COMPARATIVE_REDIRECT = "(//span[@class='compare_redirect_link']//a)[1]";
	@FindBy(xpath = ADD_TO_COMPARATIVE)
	private List<WebElement> toComparativList;

	public List<WebElement> getToComparativeList() {
		return toComparativList;
	}

	@FindBy(xpath = TO_COMPARATIVE_REDIRECT)
	private WebElement redirectToComparative;

	public WebElement getRedirectToComparative() {
		return redirectToComparative;
	}

	public PnMicrowavesPage clickAddToComperetive() {
		getToComparativeList().get(0).click();
		WaitHelper.waitForElementIsClickable(getToComparativeList().get(1),
				getDriver());
		getToComparativeList().get(1).click();
		return MyPages.getPnMicrowavesPage();
	}

	public ComparePage clickRedirectToCompare() {
		getRedirectToComparative().click();
		return MyPages.getComparePage();
	}
}
