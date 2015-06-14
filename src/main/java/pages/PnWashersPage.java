package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import core.helpers.pagehelpers.MyPages;
import java.util.List;

public class PnWashersPage extends CorePage {

	public final String PRICE_LIST = "//div[@class='price']/strong";
	public final String NEXT_PAGE_BUTTON = "(//ul[@class='pager']//li[@class='pager-next']/a)[1]";
	public final String MIN_BORDER_FILTER = "(//div[@class='is_empty_items']//a[1])[1]";
	public final String MAX_BORDER_FILTER = "(//div[@class='is_empty_items']//a[1])[2]";

	@FindBy(xpath = PRICE_LIST)
	private List<WebElement> priceList;

	public List<WebElement> getPriceList() {
		return priceList;
	}

	@FindBy(xpath = NEXT_PAGE_BUTTON)
	private WebElement nextPageButton;

	public WebElement getNextPageButton() {
		return nextPageButton;
	}

	@FindBy(xpath = MIN_BORDER_FILTER)
	private WebElement minBorderFilter;

	public WebElement getMinBorderFilter() {
		return minBorderFilter;
	}

	@FindBy(xpath = MAX_BORDER_FILTER)
	private WebElement maxBorderFilter;

	public WebElement getMaxBorderFilter() {
		return maxBorderFilter;
	}

	public PnWashersPage clickNextPageButton() {
		getNextPageButton().click();
		return MyPages.getPnWashersPage();
	}

	public PnWashersPage clickFilterOn() {
		getMinBorderFilter().click();
		getMaxBorderFilter().click();
		return MyPages.getPnWashersPage();
	}
}
